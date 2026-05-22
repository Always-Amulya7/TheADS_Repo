#pragma once
#include "Car.h"
#include <vector>

// Player Car Class
class PlayerCar : public Car
{

private:
    std::vector<float> lanes;
    int currentLane;
    float y;

public:
    // Constructor
    PlayerCar(Texture &texture)
    {
        sprite.setTexture(texture);

        // Resize player car
        sprite.setScale(0.35f, 0.35f);

        // Set origin to center
        FloatRect bounds = sprite.getLocalBounds();

        sprite.setOrigin(bounds.width / 2, bounds.height / 2);

        // UPDATED ROAD LANES
        lanes = {250, 400, 550};
        currentLane = 2;
        y = 500;

        // Initial Position
        sprite.setPosition(lanes[currentLane], y);
    }

    // RESET PLAYER AFTER RESTART
    void reset()
    {
        currentLane = 2;
        sprite.setPosition(lanes[currentLane], y);
    }

    // Move to left lane
    void moveLeft()
    {
        if (currentLane > 0)
        {
            currentLane--;
            sprite.setPosition(lanes[currentLane], y);
        }
    }

    // Move to right lane
    void moveRight()
    {
        if (currentLane < 2)
        {
            currentLane++;
            sprite.setPosition(lanes[currentLane], y);
        }
    }
    void move(float dt) override
    {
    }
};