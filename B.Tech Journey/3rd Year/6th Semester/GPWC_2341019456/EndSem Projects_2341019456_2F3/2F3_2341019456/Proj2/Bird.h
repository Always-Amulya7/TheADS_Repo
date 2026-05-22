#pragma once
#include <SFML/Graphics.hpp>

class Bird
{
public:
    sf::Sprite sprite;
    float velocityY;
    float gravity;
    float flapStrength;

    static const float RENDER_W;
    static const float RENDER_H;

    Bird(sf::Texture &texture,
         float startX,
         float startY)
    {
        velocityY = 0.f;

        // FIXED VALUES
        gravity = 700.f;
        flapStrength = -320.f;
        sprite.setTexture(texture);
        sf::Vector2u texSize = texture.getSize();
        float scaleX = RENDER_W / texSize.x;
        float scaleY = RENDER_H / texSize.y;
        sprite.setScale(scaleX, scaleY);
        sprite.setOrigin(texSize.x / 2.f, texSize.y / 2.f);
        sprite.setPosition(startX, startY);
    }

    // Bird Jump
    void flap()
    {
        velocityY = flapStrength;
    }

    // Update Bird
    void update(float dt)
    {
        velocityY += gravity * dt;
        sprite.move(
            0.f,
            velocityY * dt);

        // Rotation Animation
        float angle = velocityY * 0.05f;
        if (angle > 75.f)
            angle = 75.f;
        if (angle < -25.f)
            angle = -25.f;
        sprite.setRotation(angle);
    }

    // Collision Bounds
    sf::FloatRect getBounds() const
    {
        return sprite.getGlobalBounds();
    }

    // Draw Bird
    void draw(sf::RenderWindow &window)
    {
        window.draw(sprite);
    }

    // Reset Bird
    void reset(float x, float y)
    {
        sprite.setPosition(x, y);
        velocityY = 0.f;
        sprite.setRotation(0.f);
    }
};

const float Bird::RENDER_W = 50.f;
const float Bird::RENDER_H = 40.f;