#include "Bat.h";
using namespace sf;
// Bat Class Constructor
Bat::Bat(float startX, float startY)
{
    m_Position.x = startX;
    m_Position.y = startY;
    m_Shape.setSize(Vector2f(100, 10));
    m_Shape.setPosition(m_Position);
}
FloatRect Bat::get_Position()
{
    return m_Shape.getGlobalBounds();
}
RectangleShape Bat::get_Shape()
{
    return m_Shape;
}
void Bat::moveRight()
{
    m_MoveRight = true;
}
void Bat::moveLeft()
{
    m_MoveLeft = true;
}
void Bat::stopLeft()
{
    m_MoveLeft = false;
}
void Bat::stopRight()
{
    m_MoveRight = false;
}
void Bat::update(Time dt)
{
    m_Position.x -= m_Speed * dt.asSeconds();
    m_Position.x += m_Speed * dt.asSeconds();
}