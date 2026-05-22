#pragma once
#include <SFML/Graphics.hpp>
using namespace sf;

// Abstract Base Class for all cars
class Car
{
protected:
    Sprite sprite;

public:
    // Pure virtual function
    // Must be implemented in child classes
    virtual void move(float dt) = 0;

    // Return sprite reference
    Sprite &getSprite()
    {
        return sprite;
    }
};
