#include <SFML/Graphics.hpp>
#include "Player.cpp"
using namespace sf;
int main()
{
    enum class State
    {
        PAUSED,
        LEVELING_UP,
        GAME_OVER,
        PLAYING
    };
    // Start with game over staate
    State state = State::GAME_OVER;
    // Get the screen resolution and creeate SFML window
    Vector2f resolution;
    resolution.x = VideoMode::getDesktopMode().width;
    resolution.y = VideoMode::getDesktopMode().height;
    RenderWindow window(VideoMode(resolution.x, resolution.y), "ZOMBIEArena", Style::Fullscreen);
    // Create a SFML view for main action
    View mainView(sf::FloatRect(0, 0, resolution.x, resolution.y));
    // Clock
    Clock clock;
    // How long has the playing active
    Time gameTimeTotal;
    // Where is the Mouse in relation to world coordinate
    Vector2f mouseWorldPosition;
    // Where is the mouse in relation screen coordinate
    Vector2i mouseScreenPosition;
    // Create an instance of the Player
    Player player;
    // The boundaries of the arena
    IntRect arena;
    // The main game loop
    while (window.isOpen())
    {
        // Handle input
        // Handle Events
        Event event;
        while (window.pollEvent(event))
        {
            if (event.type == Event::KeyPressed)
            {
                // Paused a game while playing
                if (event.key.code == Keyboard::Return && state == State::PLAYING)
                {
                    state = State::PAUSED;
                }
                else if (event.key.code == Keyboard::Return && state == State::PAUSED)
                {
                    state = State::PLAYING;
                    clock.restart();
                }
                // Start a new game while the game over
                else if (event.key.code == Keyboard::Return && state == State::GAME_OVER)
                {
                    state = State::LEVELING_UP;
                }

                // Handle the levelling up
                if (state == State::LEVELING_UP)
                {
                    // Handle the player levelling up
                    if (event.key.code == Keyboard::Num1)
                    {
                        state = State::PLAYING;
                    }
                    if (event.key.code == Keyboard::Num2)
                    {
                        state = State::PLAYING;
                    }
                    if (event.key.code == Keyboard::Num3)
                    {
                        state = State::PLAYING;
                    }
                    if (event.key.code == Keyboard::Num4)
                    {
                        state = State::PLAYING;
                    }
                    if (event.key.code == Keyboard::Num5)
                    {
                        state = State::PLAYING;
                    }
                    if (event.key.code == Keyboard::Num6)
                    {
                        state = State::PLAYING;
                    }
                    if (state == State::PLAYING)
                    {
                        // Prepare the level
                        // We will modify the next two lines later
                        arena.width = 500;
                        arena.height = 300;
                        arena.left = 0;
                        arena.top = 0;

                        // We will modify this line of code later
                        int tileSize = 50;

                        // Spawn the player in the middle of the arena
                        player.spawn(arena, resolution, tileSize);

                        // Reset the clock so there isn't a frame jump
                        clock.restart();
                    }
                }

                if (state == State::PLAYING)
                {
                }
            }
            if (Keyboard::isKeyPressed(Keyboard::Escape))
            {
                window.close();
            }
        }
        // Handle controls while playing
        if (state == State::PLAYING)
        {
            // Handle the pressing and releasing the WSAD keys
            if (Keyboard::isKeyPressed(Keyboard::W))
            {
                player.moveUp();
            }
            else
            {
                player.stopUp();
            }
            if (Keyboard::isKeyPressed(Keyboard::S))
            {
                player.moveDown();
            }
            else
            {
                player.stopDown();
            }
            if (Keyboard::isKeyPressed(Keyboard::A))
            {
                player.moveLeft();
            }
            else
            {
                player.stopLeft();
            }
            if (Keyboard::isKeyPressed(Keyboard::D))
            {
                player.moveRight();
            }
            else
            {
                player.stopRight();
            }
            // End of WASD key
            /*
            ****************
            Update the frame
            ****************
            */
            if (state == State::PLAYING)
            {
                // Update the delta time
                Time dt = clock.restart();
                // Update the total game time
                gameTimeTotal += dt;
                // Make a decimal fraction of 1 from the delta time
                float dtAsSeconds = dt.asSeconds();

                // Where is the mouse pointer
                mouseScreenPosition = Mouse::getPosition();

                // Convert mouse position to world coordinates of mainView
                mouseWorldPosition = window.mapPixelToCoords(Mouse::getPosition(), mainView);

                // Update the player
                player.update(dtAsSeconds, mouseWorldPosition);

                // Make a note of the players new position
                Vector2f playerPosition(player.getCenter());

                // Make the view centre around the player
                mainView.setCenter(player.getCenter());
            } // End updating the scene
            /*
            **************
            Draw the scene
            **************
            */
            if (state == State::PLAYING)
            {
                window.clear();

                // set the mainView to be displayed in the window
                // And Draw everything related to it
                window.setView(mainView);

                // Draw the player
                window.draw(player.getSprite());
            }
            if (state == State::LEVELING_UP)
            {
            }
            if (state == State::PAUSED)
            {
            }
            if (state == State::GAME_OVER)
            {
            }
            window.display();
        } // End Game Loop
    }
}