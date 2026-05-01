#include <SFML/Graphics.hpp>
#include "Player.cpp"
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
    RenderWindow window(VideoMode(resolution.x, resolution.y), "ZOMBIEARena", Style::Fullscreen);
    // Create a SFML view for main action
    View mainViews(sf::FloatRect(0, 0, resolution.x, resolution.y));
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
        }
    }
}