// To run the code- g++ Timber.cpp -lsfml-graphics -lsfml-window -lsfml-system

#include <SFML/Graphics.hpp>
#include <sstream>
#include <SFML/Audio.hpp>
using namespace sf;

// Function Declaration
void updateBranches(int seed);
const int NUM_BRANCHES = 6;
enum class side
{
    LEFT,
    RIGHT,
    NONE
};
side branchPosition[NUM_BRANCHES];
Sprite branches[NUM_BRANCHES];

int main()
{

    VideoMode vm(1920, 1080);

    RenderWindow window(vm, "Timber!!!");

    View view(FloatRect(0, 0, 1920, 1080));
    window.setView(view);
    Texture backgroundTexture;
    backgroundTexture.loadFromFile("graphics/background.png");

    Sprite backgroundSprite;
    backgroundSprite.setTexture(backgroundTexture);
    backgroundSprite.setPosition(0, 0);
    Texture treeTexture;
    treeTexture.loadFromFile("graphics/tree.png");

    Sprite treeSprite;
    treeSprite.setTexture(treeTexture);
    treeSprite.setPosition(810, 0);
    Texture beeTexture;
    beeTexture.loadFromFile("graphics/bee.png");

    Sprite beeSprite;
    beeSprite.setTexture(beeTexture);
    beeSprite.setPosition(200, 800);

    bool beeActive = false;
    float beeSpeed = 0.0f;
    float beeHeight = 0.0f;

    Texture cloudTexture;
    cloudTexture.loadFromFile("graphics/cloud.png");

    Sprite cloudSprite1;
    cloudSprite1.setTexture(cloudTexture);
    cloudSprite1.setPosition(0, 0);

    bool cloudActive1 = false;
    float cloudSpeed1 = 0.0f;
    float cloudHeight1 = 0.0f;

    Sprite cloudSprite2;
    cloudSprite2.setTexture(cloudTexture);
    cloudSprite2.setPosition(0, 150);

    bool cloudActive2 = false;
    float cloudSpeed2 = 0.0f;
    float cloudHeight2 = 0.0f;

    Sprite cloudSprite3;
    cloudSprite3.setTexture(cloudTexture);
    cloudSprite3.setPosition(0, 300);

    bool cloudActive3 = false;
    float cloudSpeed3 = 0.0f;
    float cloudHeight3 = 0.0f;

    Clock clock;

    // Time bar
    RectangleShape timeBar;
    float timeBarStartWidth = 400;
    float timeBarHeight = 80;
    timeBar.setSize(Vector2f(timeBarStartWidth, timeBarHeight));
    timeBar.setFillColor(Color::Red);
    timeBar.setPosition((1920 / 2) - timeBarStartWidth / 2, 980);

    // Time game time
    float timeRemaining = 6.0f;
    float timeBarWidthPerSecond = timeBarStartWidth / timeRemaining;
    bool paused = true;

    // Score
    int score = 0;
    Text scoreText;
    Font font;
    font.loadFromFile("font/KOMIKAP_.ttf");
    scoreText.setFont(font);
    scoreText.setString("Score=0");
    scoreText.setPosition(20, 20);
    scoreText.setCharacterSize(80);
    scoreText.setFillColor(Color::White);

    // Text Message
    Text messageText;
    messageText.setFont(font);
    messageText.setString("Press Enter to Start");
    messageText.setCharacterSize(75);
    messageText.setFillColor(Color::White);

    // Position to the text
    FloatRect textRect = messageText.getLocalBounds();
    messageText.setOrigin(textRect.left + textRect.width / 2, textRect.top + textRect.height / 2);
    messageText.setPosition(1920 / 2, 1080 / 2);

    // Prepare Branches
    Texture textureBranch;
    textureBranch.loadFromFile("graphics/branch.png");

    // Set the texture for each branch Sprite
    for (int i = 0; i < NUM_BRANCHES; i++)
    {
        branches[i].setTexture(textureBranch);
        branches[i].setPosition(-2000, -2000);

        // Set Sprite's origin to dead center
        branches[i].setOrigin(220, 20);
    }

    // updateBranches(1);
    // updateBranches(2);
    // updateBranches(3);
    // updateBranches(4);
    // updateBranches(5);

    // Player
    Texture texturePlayer;
    texturePlayer.loadFromFile("graphics/player.png");
    Sprite spritePlayer;
    spritePlayer.setTexture(texturePlayer);
    spritePlayer.setPosition(580, 720);
    // Side of the player
    side sidePlayer = side::LEFT;

    // Grave stone
    Texture textureRIP;
    textureRIP.loadFromFile("graphics/rip.png");
    Sprite spriteRIP;
    spriteRIP.setTexture(textureRIP);
    spriteRIP.setPosition(600, 860);

    // Axe
    Texture textureAxe;
    textureAxe.loadFromFile("graphics/axe.png");
    Sprite spriteAxe;
    spriteAxe.setTexture(textureAxe);
    spriteAxe.setPosition(700, 830);

    // Line up the Axe with tree
    const int AXE_POSITION_LEFT = 700;
    const int AXE_POSITION_RIGHT = 1075;

    // Flying Log
    Texture textureLog;
    textureLog.loadFromFile("graphics/log.png");
    Sprite spriteLog;
    spriteLog.setTexture(textureLog);
    spriteLog.setPosition(810, 720);

    // Other declaration of the log
    bool logActive = false;
    float logSpeedX = 1000;
    float logSpeedY = -1500;

    // Player input
    bool acceptInput = false;

    // Sound
    SoundBuffer chopBuffer;
    chopBuffer.loadFromFile("sound/chop.wav");

    while (window.isOpen())
    {

        Event event;
        while (window.pollEvent(event))
        {
            if (event.type == Event::KeyReleased && !paused)
            {
                acceptInput = true;
                spriteAxe.setPosition(2000, spriteAxe.getPosition().y);
            }
        }

        if (Keyboard::isKeyPressed(Keyboard::Escape))
        {
            window.close();
        }

        // Start the game
        if (Keyboard::isKeyPressed(Keyboard::Return))
        {
            paused = false;
            score = 0;
            timeRemaining = 6;
            // Make all branches disappear
            for (int i = 0; i < NUM_BRANCHES; i++)
            {
                branchPosition[i] = side::NONE;
            }
            // Make Grave Stone hidden
            spriteRIP.setPosition(675, 2000);

            // Player position
            spritePlayer.setPosition(580, 720);

            // Make accept input true
            acceptInput = true;
        }

        // To make sure the game is accepting input properly
        if (acceptInput)
        {
            if (Keyboard::isKeyPressed(Keyboard::Right))
            {

                // Update score
                score++;

                // Update time Remaining
                timeRemaining += 2 / score + .15;

                // Player side
                sidePlayer = side::RIGHT;

                // Player Position
                spritePlayer.setPosition(1200, 720);

                // Axe position
                spriteAxe.setPosition(AXE_POSITION_RIGHT, spriteAxe.getPosition().y);

                // Set log Position, Speed of log and log enable
                spriteLog.setPosition(810, 720);
                logSpeedX = -5000;
                logActive = true;

                // Update Branch
                updateBranches(score);

                // Accept input false
                acceptInput = false;
            }

            if (Keyboard::isKeyPressed(Keyboard::Left))
            {

                // Update score
                score++;

                // Update time Remaining
                timeRemaining += 2 / score + .15;

                // Player side
                sidePlayer = side::LEFT;

                // Player Position
                spritePlayer.setPosition(580, 720);

                // Axe position
                spriteAxe.setPosition(AXE_POSITION_LEFT, spriteAxe.getPosition().y);

                // Set log Position, Speed of log and log enable
                spriteLog.setPosition(810, 720);
                logSpeedX = 5000;
                logActive = true;

                // Update Branch
                updateBranches(score);

                // Accept input false
                acceptInput = false;
            }
        }

        // Time dt = clock.restart();

        if (!paused)
        {

            Time dt = clock.restart();

            // subtract from the amount of time remaining
            timeRemaining -= dt.asSeconds();

            // size up the timer
            timeBar.setSize(Vector2f(timeBarWidthPerSecond * timeRemaining, timeBarHeight));

            if (timeRemaining <= 0.0f)
            {
                paused = true;

                messageText.setString("Out of time");

                FloatRect textRect = messageText.getLocalBounds();

                messageText.setOrigin(textRect.left + textRect.width / 2, textRect.top + textRect.height / 2);

                messageText.setPosition(1920 / 2, 1080 / 2);
            }

            if (!beeActive)
            {
                srand((int)time(0) * 10);
                beeSpeed = (rand() % 200) + 200;
                srand((int)time(0) * 20);
                beeHeight = (rand() % 500) + 500;
                beeSprite.setPosition(2000, beeHeight);
                beeActive = true;
            }
            else
            {
                // Move Bee
                beeSprite.setPosition(beeSprite.getPosition().x - beeSpeed * dt.asSeconds(), beeSprite.getPosition().y);
                if (beeSprite.getPosition().x < -100)
                {
                    beeActive = false;
                }
            }

            // Cloud 1
            if (!cloudActive1)
            {
                srand((int)time(0) * 10);
                cloudSpeed1 = rand() % 200;
                srand((int)time(0) * 10);
                cloudHeight1 = rand() % 150;
                cloudSprite1.setPosition(-200, cloudHeight1);
                cloudActive1 = true;
            }
            else
            {
                cloudSprite1.setPosition(cloudSprite1.getPosition().x + cloudSpeed1 * dt.asSeconds(), cloudSprite1.getPosition().y);
                if (cloudSprite1.getPosition().x > 1920)
                {
                    cloudActive1 = false;
                }
            }

            // Cloud 2
            if (!cloudActive2)
            {
                srand((int)time(0) * 20);
                cloudSpeed2 = rand() % 200;
                srand((int)time(0) * 20);
                cloudHeight2 = rand() % 300 - 150;
                cloudSprite2.setPosition(-200, cloudHeight2);
                cloudActive2 = true;
            }
            else
            {
                cloudSprite2.setPosition(cloudSprite2.getPosition().x + cloudSpeed2 * dt.asSeconds(), cloudSprite2.getPosition().y);
                if (cloudSprite2.getPosition().x > 1920)
                {
                    cloudActive2 = false;
                }
            }

            // Cloud 3
            if (!cloudActive3)
            {
                srand((int)time(0) * 30);
                cloudSpeed3 = rand() % 200;
                srand((int)time(0) * 30);
                cloudHeight3 = rand() % 450 - 150;
                cloudSprite3.setPosition(-200, cloudHeight3);
                cloudActive3 = true;
            }
            else
            {
                cloudSprite3.setPosition(cloudSprite3.getPosition().x + cloudSpeed3 * dt.asSeconds(), cloudSprite3.getPosition().y);
                if (cloudSprite3.getPosition().x > 1920)
                {
                    cloudActive3 = false;
                }
            }

            // Update the score text
            std::stringstream ss;
            ss << "score= " << score;
            scoreText.setString(ss.str());

            // Update the branch
            for (int i = 0; i < NUM_BRANCHES; i++)
            {
                float height = i * 150;
                if (branchPosition[i] == side::LEFT)
                {
                    branches[i].setPosition(600, height);
                    branches[i].setRotation(180);
                }
                else if (branchPosition[i] == side::RIGHT)
                {
                    branches[i].setPosition(1330, height);
                    branches[i].setRotation(0);
                }
                else
                {
                    branches[i].setPosition(3000, height);
                }
            }

            // Handle a flylog
            if (logActive)
            {
                spriteLog.setPosition(spriteLog.getPosition().x + logSpeedX * dt.asSeconds(), spriteLog.getPosition().y + logSpeedY * dt.asSeconds());

                // Check the log if it return to the boundary then set it again at initial position
                if (spriteLog.getPosition().x < -100 || spriteLog.getPosition().x > 2000)
                {
                    spriteLog.setPosition(810, 720);
                    logActive = false;
                }
            }

            // Has the Player been squished by a branch and update
            if (branchPosition[5] == sidePlayer)
            {
                paused = true;
                acceptInput = false;
                spritePlayer.setPosition(2000, 2000);
                spriteRIP.setPosition(525, 760);

                // Game Over Message
                messageText.setString("Game Over!!");

                FloatRect textRect = messageText.getLocalBounds();

                messageText.setOrigin(textRect.left + textRect.width / 2, textRect.top + textRect.height / 2);

                messageText.setPosition(1920 / 2, 1080 / 2);
            }
        }

        window.clear();
        window.setView(view);
        window.draw(backgroundSprite);
        window.draw(cloudSprite1);
        window.draw(cloudSprite2);
        window.draw(cloudSprite3);

        // Draw the branches
        for (int i = 0; i < NUM_BRANCHES; i++)
        {
            window.draw(branches[i]);
        }

        window.draw(treeSprite);
        window.draw(spritePlayer);
        window.draw(spriteAxe);
        window.draw(spriteLog);
        window.draw(spriteRIP);
        window.draw(beeSprite);
        window.draw(scoreText);
        window.draw(messageText);
        window.draw(timeBar);
        window.display();
    }
    return 0;
}

// Function Definition
void updateBranches(int seed)
{

    // Move all the branches down one place
    for (int j = NUM_BRANCHES - 1; j > 0; j--)
    {
        branchPosition[j] = branchPosition[j - 1];
    }

    // Spawn a new branch at position 0
    srand((int)time(0) + seed);
    int r = (rand() % 5);
    switch (r)
    {
    case 0:
        branchPosition[0] = side::LEFT;
        break;

    case 1:
        branchPosition[0] = side::RIGHT;
        break;

    default:
        branchPosition[0] = side::NONE;
        break;
    }
}