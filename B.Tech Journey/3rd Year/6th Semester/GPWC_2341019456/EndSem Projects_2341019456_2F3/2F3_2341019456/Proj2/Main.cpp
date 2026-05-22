#include <SFML/Graphics.hpp>
#include <SFML/Audio.hpp>
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <ctime>
#include <cstdlib>
#include <algorithm>
#include "Bird.h"
#include "Pipe.h"
using namespace sf;

// Window Settings
const int WIN_W = 900;
const int WIN_H = 600;
const float GROUND_H = 60.f;
const float PIPE_SPAWN_X = WIN_W + 50.f;
const float PIPE_INTERVAL = 2.0f;

// Difficulty Settings
struct DifficultySettings
{
    std::string name;
    float gapSize;
    float pipeSpeed;
    bool oscillate;
};

// EASY / MEDIUM / HARD
const DifficultySettings DIFFICULTIES[3] =
    {
        {"EASY", 220.f, 180.f, false},
        {"MEDIUM", 180.f, 240.f, false},
        {"HARD", 150.f, 300.f, true}};

// Game States
enum class GameState
{
    MENU,
    PLAYING,
    PAUSED,
    GAMEOVER
};

// Load High Score
int loadHighScore()
{
    std::ifstream file("HighScore.txt");
    int hs = 0;
    if (file.is_open())
    {
        std::string text;
        std::getline(file, text);
        std::string prefix = "High Score Till Now Is : ";
        if (text.find(prefix) != std::string::npos)
        {
            std::string number = text.substr(prefix.length());
            hs = std::stoi(number);
        }
        file.close();
    }
    return hs;
}

// Save High Score
void saveHighScore(int hs)
{
    std::ofstream file("HighScore.txt");
    if (file.is_open())
    {
        file << "High Score Till Now Is : " << hs;
        file.close();
    }
}

int main()
{
    std::srand(static_cast<unsigned>(std::time(nullptr)));

    // Create Window
    RenderWindow window(VideoMode(WIN_W, WIN_H), "Flappy Bird");
    window.setFramerateLimit(60);

    // VERY IMPORTANT FOR KEYBOARD INPUT
    window.requestFocus();

    // Load Font
    Font font;
    if (!font.loadFromFile("Assets/arial.ttf"))
    {
        std::cout << "Could not load font\n";
    }

    // Load Textures
    Texture birdTex;
    Texture pipeTex;

    if (!birdTex.loadFromFile("Assets/Bird.png"))
    {
        std::cout << "Could not load Bird texture\n";
    }

    if (!pipeTex.loadFromFile("Assets/Pipes.png"))
    {
        std::cout << "Could not load Pipe texture\n";
    }

    // Ground
    RectangleShape ground(Vector2f((float)WIN_W, GROUND_H));

    ground.setFillColor(Color(210, 180, 100));
    ground.setPosition(0.f, WIN_H - GROUND_H);

    // Sounds
    SoundBuffer flapBuf;
    SoundBuffer hitBuf;
    SoundBuffer scoreBuf;

    // Correct sound file names
    if (!flapBuf.loadFromFile("Assets/chop.wav"))
    {
        std::cout << "Could not load flap sound\n";
    }

    if (!hitBuf.loadFromFile("Assets/death.wav"))
    {
        std::cout << "Could not load hit sound\n";
    }

    if (!scoreBuf.loadFromFile("Assets/out_of_time.wav"))
    {
        std::cout << "Could not load score sound\n";
    }

    Sound flapSound;
    Sound hitSound;
    Sound scoreSound;

    flapSound.setBuffer(flapBuf);
    hitSound.setBuffer(hitBuf);
    scoreSound.setBuffer(scoreBuf);

    flapSound.setVolume(60.f);
    hitSound.setVolume(70.f);
    scoreSound.setVolume(50.f);

    // Background Music
    Music bgMusic;
    if (bgMusic.openFromFile("Assets/bgmusic.wav"))
    {
        bgMusic.setLoop(true);
        bgMusic.setVolume(40.f);
        bgMusic.play();
    }

    // Game Variables
    GameState state = GameState::MENU;

    int diffIndex = 0;
    int score = 0;

    // Load High Score From File
    int highScore = loadHighScore();

    Bird bird(birdTex, WIN_W * 0.25f, WIN_H / 2.f);

    std::vector<Pipe> pipes;
    float pipeTimer = 0.f;

    Clock clock;

    // Helper Function for Text
    auto makeText =
        [&](const std::string &str,
            unsigned size,
            Color color,
            float x,
            float y)
    {
        Text text(str, font, size);
        text.setFillColor(color);
        text.setOutlineColor(Color::Black);
        text.setOutlineThickness(2.f);
        FloatRect r = text.getLocalBounds();
        text.setOrigin(r.width / 2.f, r.height / 2.f);
        text.setPosition(x, y);
        return text;
    };

    // Reset Game
    auto resetGame = [&]()
    {
        bird.reset(WIN_W * 0.25f, WIN_H / 2.f);
        pipes.clear();
        pipeTimer = 0.f;
        score = 0;
        state = GameState::PLAYING;
    };

    // GAME LOOP
    while (window.isOpen())
    {
        float dt = clock.restart().asSeconds();
        if (dt > 0.05f)
            dt = 0.05f;
        Event event;

        // Event Handling
        while (window.pollEvent(event))
        {
            if (event.type == Event::Closed)
            {
                window.close();
            }

            // KEYBOARD INPUT
            if (event.type == Event::KeyPressed)
            {
                // ESC = EXIT GAME
                if (event.key.code == Keyboard::Escape)
                {
                    window.close();
                }

                // ---------------- MENU ----------------
                if (state == GameState::MENU)
                {
                    // EASY
                    if (event.key.code == Keyboard::Num1 ||
                        event.key.code == Keyboard::Numpad1)
                    {
                        diffIndex = 0;
                        resetGame();
                    }

                    // MEDIUM
                    if (event.key.code == Keyboard::Num2 ||
                        event.key.code == Keyboard::Numpad2)
                    {
                        diffIndex = 1;
                        resetGame();
                    }

                    // HARD
                    if (event.key.code == Keyboard::Num3 ||
                        event.key.code == Keyboard::Numpad3)
                    {
                        diffIndex = 2;
                        resetGame();
                    }
                }

                // ---------------- PLAYING ----------------
                else if (state == GameState::PLAYING)
                {
                    // Bird Jump
                    if (event.key.code == Keyboard::Space)
                    {
                        bird.flap();
                        flapSound.play();
                    }

                    // Pause Game
                    if (event.key.code == Keyboard::P)
                    {
                        state = GameState::PAUSED;
                    }
                }

                // ---------------- PAUSED ----------------
                else if (state == GameState::PAUSED)
                {
                    // Resume Game
                    if (event.key.code == Keyboard::R)
                    {
                        state = GameState::PLAYING;
                    }
                }

                // ---------------- GAME OVER ----------------
                else if (state == GameState::GAMEOVER)
                {
                    // Restart
                    if (event.key.code == Keyboard::Space)
                    {
                        resetGame();
                    }

                    // Back To Menu
                    if (event.key.code == Keyboard::M)
                    {
                        state = GameState::MENU;
                    }
                }
            }
        }

        // Game Logic
        if (state == GameState::PLAYING)
        {
            const DifficultySettings &diff =
                DIFFICULTIES[diffIndex];

            // Bird Physics
            bird.update(dt);

            // Spawn Pipes
            pipeTimer += dt;

            if (pipeTimer >= PIPE_INTERVAL)
            {
                pipeTimer = 0.f;
                pipes.emplace_back(
                    pipeTex,
                    PIPE_SPAWN_X,
                    (float)(WIN_H - GROUND_H),
                    diff.gapSize,
                    diff.pipeSpeed,
                    diff.oscillate);
            }

            // Update Pipes
            for (auto &p : pipes)
            {
                p.update(dt, (float)(WIN_H - GROUND_H));
            }

            // Remove Offscreen Pipes
            pipes.erase(
                std::remove_if(
                    pipes.begin(),
                    pipes.end(),
                    [](const Pipe &p)
                    {
                        return p.isOffScreen();
                    }),
                pipes.end());

            // Score System
            for (auto &p : pipes)
            {
                if (p.checkScore(
                        bird.sprite.getPosition().x))
                {
                    score++;
                    scoreSound.play();

                    // Save New High Score
                    if (score > highScore)
                    {
                        highScore = score;
                        saveHighScore(highScore);
                    }
                }
            }

            // Collision Detection
            bool hit = false;

            for (auto &p : pipes)
            {
                if (p.collides(bird.getBounds()))
                {
                    hit = true;
                    break;
                }
            }

            // Top or Ground Collision
            float birdTop =
                bird.getBounds().top;
            float birdBottom =
                bird.getBounds().top +
                bird.getBounds().height;
            if (birdTop <= 0.f ||
                birdBottom >= WIN_H - GROUND_H)
            {
                hit = true;
            }

            // GAME OVER
            if (hit)
            {
                hitSound.play();
                state = GameState::GAMEOVER;
            }
        }

        // DRAWING
        window.clear(Color(113, 197, 207));

        // Draw Ground
        window.draw(ground);

        // ---------------- MENU ----------------
        if (state == GameState::MENU)
        {
            window.draw(makeText(
                "FLAPPY BIRD",
                55,
                Color::Yellow,
                WIN_W / 2.f,
                140.f));

            window.draw(makeText(
                "Press 1 / 2 / 3",
                30,
                Color::White,
                WIN_W / 2.f,
                240.f));

            window.draw(makeText(
                "[1] EASY",
                28,
                Color::Green,
                WIN_W / 2.f,
                320.f));

            window.draw(makeText(
                "[2] MEDIUM",
                28,
                Color::Yellow,
                WIN_W / 2.f,
                380.f));

            window.draw(makeText(
                "[3] HARD",
                28,
                Color::Red,
                WIN_W / 2.f,
                440.f));

            window.draw(makeText(
                "HIGH SCORE : " +
                    std::to_string(highScore),
                22,
                Color::White,
                WIN_W / 2.f,
                530.f));
        }

        // ---------------- GAMEPLAY ----------------
        else
        {
            // Draw Pipes
            for (auto &p : pipes)
            {
                p.draw(window);
            }

            // Draw Bird
            bird.draw(window);

            // Score
            window.draw(makeText(
                "SCORE : " +
                    std::to_string(score),
                28,
                Color::White,
                110.f,
                30.f));

            // Difficulty Name
            window.draw(makeText(
                DIFFICULTIES[diffIndex].name,
                22,
                Color::White,
                WIN_W / 2.f,
                30.f));

            // High Score
            window.draw(makeText(
                "HIGH SCORE : " +
                    std::to_string(highScore),
                24,
                Color::White,
                WIN_W - 170.f,
                30.f));

            // ---------------- PAUSED ----------------
            if (state == GameState::PAUSED)
            {
                window.draw(makeText(
                    "PAUSED",
                    60,
                    Color::White,
                    WIN_W / 2.f,
                    WIN_H / 2.f));

                window.draw(makeText(
                    "Press R To Resume",
                    28,
                    Color::Yellow,
                    WIN_W / 2.f,
                    WIN_H / 2.f + 70.f));
            }

            // ---------------- GAME OVER ----------------
            if (state == GameState::GAMEOVER)
            {
                window.draw(makeText(
                    "GAME OVER",
                    60,
                    Color::Red,
                    WIN_W / 2.f,
                    220.f));

                window.draw(makeText(
                    "SPACE = Restart",
                    28,
                    Color::White,
                    WIN_W / 2.f,
                    320.f));

                window.draw(makeText(
                    "M = Menu",
                    28,
                    Color::White,
                    WIN_W / 2.f,
                    370.f));

                window.draw(makeText(
                    "ESC = Exit",
                    24,
                    Color::White,
                    WIN_W / 2.f,
                    420.f));
            }
        }
        window.display();
    }
    return 0;
}