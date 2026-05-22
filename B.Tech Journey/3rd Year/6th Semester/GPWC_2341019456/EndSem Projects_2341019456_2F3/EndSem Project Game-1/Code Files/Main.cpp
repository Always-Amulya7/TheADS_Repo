#include <SFML/Graphics.hpp>
#include <SFML/Audio.hpp>
#include <vector>
#include <cstdlib>
#include <algorithm>
#include <string>
#include "PlayerCar.h"
#include "EnemyCar.h"
using namespace sf;

int main()
{
    // Create the game window
    RenderWindow window(VideoMode(800, 600), "Car Dodging Game");
    window.setFramerateLimit(60);

    // Load Textures
    Texture playerTex;

    Texture red1;
    Texture red2;

    Texture yellow1;
    Texture yellow2;
    Texture yellow3;

    // Load Player Car Texture
    if (!playerTex.loadFromFile("Assets/WhiteCar.png"))
    {
        return -1;
    }

    // Load Enemy Car Textures
    if (!red1.loadFromFile("Assets/RedCar1.png"))
    {
        return -1;
    }

    if (!red2.loadFromFile("Assets/RedCar2.png"))
    {
        return -1;
    }

    if (!yellow1.loadFromFile("Assets/YellowCar1.png"))
    {
        return -1;
    }

    if (!yellow2.loadFromFile("Assets/YellowCar2.png"))
    {
        return -1;
    }

    if (!yellow3.loadFromFile("Assets/YellowCar3.png"))
    {
        return -1;
    }

    // Store enemy textures
    std::vector<Texture *> enemyTextures =
        {
            &red1,
            &red2,
            &yellow1,
            &yellow2,
            &yellow3};

    // Create player object
    PlayerCar player(playerTex);

    // Set Initial Player Position
    player.getSprite().setPosition(550, 500);

    // Enemy vector
    std::vector<EnemyCar> enemies;

    // Score tracker
    std::vector<bool> scored;

    // Lane Positions
    std::vector<float> lanes =
        {
            250,
            400,
            550};

    Clock clock;

    float spawnTimer = 0.0f;
    float speedMultiplier = 1.0f;
    bool gameOver = false;
    bool paused = false;
    bool gameStarted = false;

    // Difficulty
    int difficulty = 2;
    float spawnDelay = 1.0f;
    float speedGrowth = 0.05f;

    // Load Font
    Font font;

    if (!font.loadFromFile("Assets/arial.ttf"))
    {
        return -1;
    }

    int score = 0;

    // UI Text Objects
    Text scoreText;
    Text speedText;
    Text modeText;
    Text gameOverText;
    Text pauseText;
    Text startText;

    // Same Text Size
    int uiSize = 24;

    // Score Text
    scoreText.setFont(font);
    scoreText.setCharacterSize(uiSize);
    scoreText.setPosition(20, 15);
    scoreText.setFillColor(Color::White);

    // Mode Text
    modeText.setFont(font);
    modeText.setCharacterSize(uiSize);
    modeText.setPosition(20, 55);
    modeText.setFillColor(Color::White);

    // Speed Text
    speedText.setFont(font);
    speedText.setCharacterSize(22);
    speedText.setPosition(620, 15);
    speedText.setFillColor(Color::White);

    // Pause Text
    pauseText.setFont(font);
    pauseText.setCharacterSize(18);
    pauseText.setFillColor(Color::Yellow);

    // PERFECTLY ALIGNED WITH SPEED TEXT
    pauseText.setPosition(speedText.getPosition().x, 70);

    // Better spacing
    pauseText.setLineSpacing(1.2f);

    pauseText.setString(
        "PAUSED\n"
        "Press R\n"
        "To Resume");

    // Start Menu Text
    startText.setFont(font);
    startText.setCharacterSize(18);
    startText.setFillColor(Color::White);

    // PERFECTLY ALIGNED WITH SPEED TEXT
    startText.setPosition(speedText.getPosition().x, 70);

    // Better spacing
    startText.setLineSpacing(1.2f);
    startText.setString(
        "ENTER\n"
        "To Start\n\n"
        "1 : Easy\n"
        "2 : Medium\n"
        "3 : Hard");

    // Game Over Text
    gameOverText.setFont(font);
    gameOverText.setCharacterSize(18);
    gameOverText.setFillColor(Color::Red);

    // PERFECTLY ALIGNED WITH SPEED TEXT
    gameOverText.setPosition(speedText.getPosition().x, 70);

    // Better spacing
    gameOverText.setLineSpacing(1.2f);

    gameOverText.setString(
        "GAME OVER\n\n"
        "ENTER\n"
        "To Restart");

    // Load Sounds
    SoundBuffer crashBuffer;
    SoundBuffer moveBuffer;

    // Load Crash Sound
    if (!crashBuffer.loadFromFile("Assets/death.wav"))
    {
        return -1;
    }

    // Load Move Sound
    if (!moveBuffer.loadFromFile("Assets/chop.wav"))
    {
        return -1;
    }

    Sound crashSound;
    Sound moveSound;
    crashSound.setBuffer(crashBuffer);
    moveSound.setBuffer(moveBuffer);

    // Background Music
    Music bgMusic;

    // Load Background Music
    if (bgMusic.openFromFile("Assets/bgmusic.wav"))
    {
        bgMusic.setLoop(true);
        bgMusic.setVolume(40.f);
        bgMusic.play();
    }

    // GAME LOOP
    while (window.isOpen())
    {
        float dt = clock.restart().asSeconds();

        Event event;

        // Event Handling
        while (window.pollEvent(event))
        {
            if (event.type == Event::Closed)
            {
                window.close();
            }

            if (event.type == Event::KeyPressed)
            {
                // Exit Game
                if (event.key.code == Keyboard::Escape)
                {
                    window.close();
                }

                // Difficulty Selection
                if (!gameStarted)
                {
                    if (event.key.code == Keyboard::Num1 ||
                        event.key.code == Keyboard::Numpad1)
                    {
                        difficulty = 1;
                    }

                    if (event.key.code == Keyboard::Num2 ||
                        event.key.code == Keyboard::Numpad2)
                    {
                        difficulty = 2;
                    }

                    if (event.key.code == Keyboard::Num3 ||
                        event.key.code == Keyboard::Numpad3)
                    {
                        difficulty = 3;
                    }
                }

                // Start Game
                if (event.key.code == Keyboard::Enter &&
                    !gameStarted)
                {
                    gameStarted = true;
                }

                // Restart Game
                if (event.key.code == Keyboard::Enter &&
                    gameOver)
                {
                    enemies.clear();
                    scored.clear();
                    score = 0;
                    spawnTimer = 0;
                    speedMultiplier = 1.0f;
                    gameOver = false;
                    paused = false;
                    gameStarted = false;

                    // RESET PLAYER COMPLETELY
                    player.reset();
                }

                // Pause
                if (event.key.code == Keyboard::P &&
                    gameStarted &&
                    !gameOver)
                {
                    paused = true;
                }

                // Resume
                if (event.key.code == Keyboard::R &&
                    gameStarted &&
                    !gameOver)
                {
                    paused = false;
                }

                // PLAYER MOVEMENT FIXED
                if (gameStarted &&
                    !paused &&
                    !gameOver)
                {
                    Vector2f pos = player.getSprite().getPosition();
                    // Move Left
                    if (event.key.code == Keyboard::Left)
                    {
                        if (pos.x > 260)
                        {
                            player.moveLeft();
                            moveSound.play();
                        }
                    }

                    // Move Right
                    if (event.key.code == Keyboard::Right)
                    {
                        if (pos.x < 540)
                        {
                            player.moveRight();
                            moveSound.play();
                        }
                    }
                }
            }
        }

        // Game Updates
        if (gameStarted &&
            !paused &&
            !gameOver)
        {
            // Difficulty Settings
            if (difficulty == 1)
            {
                spawnDelay = 1.5f;
                speedGrowth = 0.03f;
            }
            else if (difficulty == 2)
            {
                spawnDelay = 1.0f;
                speedGrowth = 0.05f;
            }
            else
            {
                spawnDelay = 0.6f;
                speedGrowth = 0.08f;
            }

            // Increase Speed
            speedMultiplier += dt * speedGrowth;

            // Spawn Timer
            spawnTimer += dt;

            // Spawn Enemy Cars
            if (spawnTimer > spawnDelay)
            {
                int lane = rand() % 3;
                int texIndex = rand() % enemyTextures.size();
                enemies.push_back(
                    EnemyCar(
                        *enemyTextures[texIndex],
                        lanes[lane],
                        lane));
                scored.push_back(false);
                spawnTimer = 0;
            }

            // Move Enemy Cars
            for (auto &e : enemies)
            {
                e.move(dt * speedMultiplier);
            }

            // Score Update
            for (size_t i = 0; i < enemies.size(); i++)
            {
                if (!scored[i] &&
                    enemies[i].getSprite().getPosition().y >
                        player.getSprite().getPosition().y)
                {
                    score++;
                    scored[i] = true;
                }
            }

            // Collision Detection
            for (auto &e : enemies)
            {
                if (player.getSprite()
                        .getGlobalBounds()
                        .intersects(
                            e.getSprite()
                                .getGlobalBounds()))
                {
                    crashSound.play();
                    gameOver = true;
                    break;
                }
            }

            // Remove Offscreen Cars
            for (size_t i = 0; i < enemies.size();)
            {
                if (enemies[i].getSprite().getPosition().y > 700)
                {
                    enemies.erase(enemies.begin() + i);
                    scored.erase(scored.begin() + i);
                }
                else
                {
                    i++;
                }
            }
        }

        // Update UI Text
        scoreText.setString("Score : " + std::to_string(score));

        speedText.setString("Speed : " + std::to_string((int)(speedMultiplier * 10)));
        std::string diffName;

        if (difficulty == 1)
        {
            diffName = "Easy";
        }
        else if (difficulty == 2)
        {
            diffName = "Medium";
        }
        else
        {
            diffName = "Hard";
        }

        modeText.setString("Mode : " + diffName);

        // Render
        window.clear(Color(20, 20, 20));

        // Road
        RectangleShape road(Vector2f(420, 600));

        road.setFillColor(Color(65, 65, 65));
        road.setPosition(190, 0);
        window.draw(road);

        // Left Border
        RectangleShape leftBorder(Vector2f(8, 600));

        leftBorder.setFillColor(Color::White);
        leftBorder.setPosition(190, 0);
        window.draw(leftBorder);

        // Right Border
        RectangleShape rightBorder(Vector2f(8, 600));

        rightBorder.setFillColor(Color::White);
        rightBorder.setPosition(602, 0);
        window.draw(rightBorder);

        // Dotted Road Lines
        for (int i = 0; i < 12; i++)
        {
            RectangleShape dash(Vector2f(10, 35));
            dash.setFillColor(Color::White);

            // Left Divider
            dash.setPosition(335, i * 60);
            window.draw(dash);

            // Right Divider
            dash.setPosition(
                465,
                i * 60);
            window.draw(dash);
        }

        // Draw Player
        if (gameStarted)
        {
            window.draw(player.getSprite());
        }

        // Draw Enemy Cars
        for (auto &e : enemies)
        {
            window.draw(e.getSprite());
        }

        // Draw UI
        window.draw(scoreText);
        window.draw(modeText);
        window.draw(speedText);

        // Draw Start Menu
        if (!gameStarted)
        {
            window.draw(startText);
        }

        // Draw Pause Text
        if (paused)
        {
            window.draw(pauseText);
        }

        // Draw Game Over Text
        if (gameOver)
        {
            window.draw(gameOverText);
        }
        window.display();
    }
    return 0;
}