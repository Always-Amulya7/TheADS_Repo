#include <SFML/Graphics.hpp>
#include <cmath>
using namespace sf;
class Player
{
private:
    const float START_SPEED = 200;
    const float START_HEALTH = 100;
    // Where is the Player
    Vector2f m_Position;
    // Sprite
    Sprite m_Sprite;
    // Add a texture
    Texture m_Texture;
    // Screen Resolution
    Vector2f m_Resolution;
    // Size arena
    IntRect m_Arena;
    // Tile
    int m_TileSize;
    // Direction of the Player
    bool m_UpPressed, m_DownPressed, m_LeftPressed, m_RightPressed;
    // Health
    int m_Health;
    // Maximum Health
    int m_maxHealth;
    // Player Last Hit
    Time m_LastHit;
    // Speed in Pixcel per second
    float m_Speed;

public:
    Player();
    void spawn(IntRect arena, Vector2f resolution, int tileSize);
    // Where is the player
    FloatRect getPosition();
    // Send a copy of the sprite to main
    Sprite getSprite();
    // Where is the center of the player
    Vector2f getCenter();
    // Player Angle facing
    float getRotation();
    // Four function to movement
    void moveLeft();
    void moveRight();
    void moveUp();
    void moveDown();
    // Stop Player Movement
    void stopLeft();
    void stopRight();
    void stopUp();
    void stopDown();
    // We will call this function once every frame
    void update(float elapsedTime, Vector2f mousePosition);
    // Handle Player getting hit by Zombie
    bool hit(Time timeHit);
    // How long ago was the player last hit
    Time getLastHitTime();
    // How much health the player curently got
    int getHealth();
    // Give Player a speed boost
    void upgradeSpeed();
    // Give health upgrade
    void upgradeHealth();
    // Increment the maximum amount of health of the player
    void increaseHealthLevel(int amount);
};
Player::Player()
{
    m_Speed = START_SPEED;
    m_Health = START_HEALTH;
    m_maxHealth = START_HEALTH;
    // Associated a texture with sprite
    m_Texture.loadFromFile("graphics/player.png");
    m_Sprite.setTexture(m_Texture);
    // Set the origin of the Sprite to the center for smooth rotation
    m_Sprite.setOrigin(25, 25);
}
void Player::spawn(IntRect arena, Vector2f resolution, int tileSize)
{
    // Place the player in the middle of the arena
    m_Position.x = arena.width / 2;
    m_Position.y = arena.height / 2;
    // Copy the details of the arena to the player
    m_Arena.left = arena.left;
    m_Arena.width = arena.width;
    m_Arena.top = arena.top;
    m_Arena.height = arena.height;
    // How big tiles in this arena
    m_TileSize = tileSize;
    // Store resolution for future used
    m_Resolution.x = resolution.x;
    m_Resolution.y = resolution.y;
}
Time Player::getLastHitTime()
{
    return m_LastHit;
}
bool Player::hit(Time timeHit)
{
    if (timeHit.asMicroseconds() - m_LastHit.asMicroseconds() > 200)
    {
        m_LastHit = timeHit;
        m_Health -= 10;
        return true;
    }
    else
    {
        return false;
    }
}
FloatRect Player::getPosition()
{
    return m_Sprite.getGlobalBounds();
}
Vector2f Player::getCenter()
{
    return m_Position;
}
float Player::getRotation()
{
    return m_Sprite.getRotation();
}
Sprite Player::getSprite()
{
    return m_Sprite;
}
int Player::getHealth()
{
    return m_Health;
}
void Player::moveLeft()
{
    m_LeftPressed = true;
}
void Player::moveRight()
{
    m_RightPressed = true;
}
void Player::moveUp()
{
    m_UpPressed = true;
}
void Player::moveDown()
{
    m_DownPressed = true;
}
void Player::stopUp()
{
    m_UpPressed = false;
}
void Player::stopDown()
{
    m_DownPressed = false;
}
void Player::stopLeft()
{
    m_LeftPressed = false;
}
void Player::stopRight()
{
    m_RightPressed = false;
}
void Player::update(float elapsedTime, Vector2f mousePosition)
{
    if (m_UpPressed)
    {
        m_Position.y -= m_Speed * elapsedTime;
    }
    if (m_DownPressed)
    {
        m_Position.y += m_Speed * elapsedTime;
    }
    if (m_LeftPressed)
    {
        m_Position.x -= m_Speed * elapsedTime;
    }
    if (m_RightPressed)
    {
        m_Position.x += m_Speed * elapsedTime;
    }
    m_Sprite.setPosition(m_Position);
    // Keep the player in the arena
    if (m_Position.x > m_Arena.width - m_TileSize)
    {
        m_Position.x = m_Arena.width - m_TileSize;
    }
    if (m_Position.x < m_Arena.width + m_TileSize)
    {
        m_Position.x = m_Arena.width + m_TileSize;
    }
    if (m_Position.y > m_Arena.height - m_TileSize)
    {
        m_Position.y = m_Arena.height - m_TileSize;
    }
    if (m_Position.y < m_Arena.top + m_TileSize)
    {
        m_Position.y = m_Arena.top + m_TileSize;
    }
    // Caculate the angle the player is facing
    double angle = (atan2(mousePosition.y - m_Resolution.y / 2, mousePosition.x / 2) * 180) / 3.141;
    m_Sprite.setRotation(angle);
}
// Upgrade Speed
void Player::upgradeSpeed()
{
    // 20 % Speed Upgrade
    m_Speed += (START_SPEED * .2);
}
// Upgrade Health
void Player::upgradeHealth()
{
    // 20 % maximum Health
    m_Health += (START_HEALTH * .2);
}
void Player::increaseHealthLevel(int amount)
{
    m_Health += amount;
    if (m_Health > m_maxHealth)
    {
        m_Health = m_maxHealth;
    }
}