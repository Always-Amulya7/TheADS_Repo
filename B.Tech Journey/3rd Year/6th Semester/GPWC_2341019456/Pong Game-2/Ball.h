# pragma once
# include <SFML/Graphics.hpp>
using namespace sf;

class Ball{
    private:
        Vector2f m_Position;
        CircleShape m_Shape;
        float m_Speed = 1000.0f;
        float m_DirectionX = .2f;
        float m_DirectionY = .2f;

    public:
        Ball(float StartX, float StartY);
        FloatRect get_Position();
        CircleShape get_Shape();
        float getXVelocity();
        void reboundSide();
        void reboundBatOrTop();
        void reboundBottom();
        void update(Time dt);
};