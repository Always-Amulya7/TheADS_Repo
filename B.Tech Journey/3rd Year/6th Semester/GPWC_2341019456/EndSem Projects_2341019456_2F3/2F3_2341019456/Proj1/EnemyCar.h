#pragma once
#include "Car.h"

// Enemy Car Class
class EnemyCar : public Car
{
private:
    float speed;
    int laneIndex;

public:
    // Constructor
    EnemyCar(Texture &texture, float x, int lane)
    {
        sprite.setTexture(texture);

        // Resize enemy car
        sprite.setScale(0.35f, 0.35f);

        // Set origin to center
        FloatRect bounds = sprite.getLocalBounds();

        sprite.setOrigin(bounds.width / 2, bounds.height / 2);

        // Spawn above screen
        sprite.setPosition(x, -100);

        speed = 200.0f;
        laneIndex = lane;
    }

    // Move enemy downward
    void move(float dt) override
    {
        sprite.move(0, speed * dt);
    }

    // Return lane index
    int getLane() const
    {
        return laneIndex;
    }
};
