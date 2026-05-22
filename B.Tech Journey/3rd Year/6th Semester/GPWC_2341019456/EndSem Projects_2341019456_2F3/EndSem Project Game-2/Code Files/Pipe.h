#pragma once
#include <SFML/Graphics.hpp>
#include <cstdlib>
#include <cmath>

// Pipe Class
class Pipe
{
public:
    sf::RectangleShape topRect;
    sf::RectangleShape botRect;
    float x;
    float gapY;
    float gapSize;
    float speed;
    bool scored;
    bool oscillate;
    float oscillateTimer;
    float oscillateAmp;
    float oscillateSpeed;

    static const float PIPE_W;

    // Constructor
    Pipe(sf::Texture &pipeTexture,
         float startX,
         float playAreaH,
         float gap,
         float scrollSpeed,
         bool hardMode = false)
    {
        x = startX;
        gapSize = gap;
        speed = scrollSpeed;
        scored = false;
        oscillate = hardMode;
        oscillateTimer = 0.f;
        oscillateAmp = 55.f;
        oscillateSpeed = 2.0f;

        // Random gap position
        float margin = gapSize / 2.f + 70.f;
        float range = playAreaH - margin * 2.f;

        if (range < 1.f)
            range = 1.f;
        gapY =
            margin +
            (float)(std::rand() % (int)range);
        topRect.setTexture(&pipeTexture);
        botRect.setTexture(&pipeTexture);
        updateRects(playAreaH);
    }

    // Update pipe sizes
    void updateRects(float playAreaH)
    {
        float gapTop = gapY - gapSize / 2.f;
        float gapBottom = gapY + gapSize / 2.f;

        // Top Pipe
        float topH = gapTop;

        if (topH < 0.f)
            topH = 0.f;

        topRect.setSize(sf::Vector2f(PIPE_W, topH));
        topRect.setPosition(x - PIPE_W / 2.f, 0.f);

        // Bottom Pipe
        float botH =
            playAreaH - gapBottom;

        if (botH < 0.f)
            botH = 0.f;

        botRect.setSize(sf::Vector2f(PIPE_W, botH));

        botRect.setPosition(x - PIPE_W / 2.f, gapBottom);
    }

    // Update movement
    void update(float dt, float playAreaH)
    {
        // Move left
        x -= speed * dt;

        // Hard mode oscillation
        if (oscillate)
        {
            oscillateTimer += dt;
            float delta =
                oscillateAmp *
                std::sin(
                    oscillateSpeed *
                    oscillateTimer) *
                dt;
            gapY += delta;
            float margin = gapSize / 2.f + 70.f;

            if (gapY < margin)
                gapY = margin;

            if (gapY > playAreaH - margin)
                gapY = playAreaH - margin;
        }
        updateRects(playAreaH);
    }

    // Remove pipe off screen
    bool isOffScreen() const
    {
        return (x + PIPE_W / 2.f) < 0.f;
    }

    // Score check
    bool checkScore(float birdX)
    {
        if (!scored && birdX > x)
        {
            scored = true;
            return true;
        }
        return false;
    }

    // Collision check
    bool collides(sf::FloatRect birdBounds) const
    {
        return birdBounds.intersects(topRect.getGlobalBounds()) ||
               birdBounds.intersects(botRect.getGlobalBounds());
    }

    // Draw pipes
    void draw(sf::RenderWindow &window)
    {
        window.draw(topRect);
        window.draw(botRect);
    }
};

// Static Width
const float Pipe::PIPE_W = 70.f;
