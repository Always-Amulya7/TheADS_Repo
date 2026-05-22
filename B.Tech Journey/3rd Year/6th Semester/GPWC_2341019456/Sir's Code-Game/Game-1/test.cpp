#include<SFML/Graphics.hpp>
using namespace sf;
int main()
{
RenderWindow window(VideoMode(800, 600), "GPWC++");
RectangleShape rectencle;//create
rectencle.setSize(Vector2f(200, 100));//size
rectencle.setFillColor(Color::Green);
rectencle.setPosition(300,250);
while (window.isOpen())
{
    Event event;
    while (window.pollEvent(event))
    {
        if(event.type==Event::Closed)
        window.close();
    }
    
    window.clear();
    window.display();
}
return 0;
    
}