#include "Bat.h"
#include "Ball.h"
#include<SFML/Graphics.hpp>
#include <sstream>
#include <cstdlib>

using namespace sf;
int main()
{
    //Create Video Mode
    VideoMode vm(1920, 1080);
    //Create the Window
    RenderWindow window(vm, "Pong", Style::Fullscreen);
    View view(FloatRect(0,0, 1920,1080));
    window.setView(view);

    //Create Bat
    Bat bat(1920/2, 1080-20);
    //Create Ball
    Ball ball(1920/2, 0);
    //Create HUD
    Text hud;
    Font font;
    font.loadFromFile("font/DS-DIGI.TTF");
    hud.setFont(font);
    hud.setFillColor(Color::White);
    hud.setCharacterSize(75);
    hud.setPosition(20,20);
    hud.setString("Score: 0 Lives: 3");
    //Initialize score and Lives
    int score=0;
    int lives=3;
    //Manage Time
    Clock clock;
    while(window.isOpen())
    {
        //Handle Player Input
        Event event;
        while(window.pollEvent(event))
        {
            if(event.type==Event::Closed)
            {
                window.close();
            }
        }
        //Handle quitting game
        if(Keyboard::isKeyPressed(Keyboard::Escape))
        {
            window.close();
        }
        //Handle the Playing Input
        if(Keyboard::isKeyPressed(Keyboard::Right))
        {
            if(bat.get_Position().left+bat.get_Position().width>1920)
            {
                bat.stopRight();
            }
            else
            {
                bat.moveRight();
            }
        }
        else{
            bat.stopRight();
        }
        if(Keyboard::isKeyPressed(Keyboard::Left))
        {
            if(bat.get_Position().left<0)
            {
                bat.stopLeft();
            }
            else
            {
                bat.moveLeft();
            }
        }
        else{
            bat.stopLeft();
        }
        //Manage the time
        Time dt=clock.restart();
        //Update Bat
        bat.update(dt);
        //Ball Update
        ball.update(dt);
        //Update score message
        std::stringstream ss;
        ss<< "Score:" <<score <<"Lives:"<<lives;
        hud.setString(ss.str());
        //Handle the ball hiting the bottom
        if(ball.getPosition().top>window.getSize().y)
        {
            //Reverse the ball direction
            ball.reboundBottom();
            //Remove a life
            lives--;
            //check for zero live
            if(lives<1)
            {
                //reset the score
                score=0;
                //reset lives
                lives=3;
            }
        }
    //Ball hiting the top
    if(ball.getPosition().top<0)
    {
        ball.reboundBatOrTop();
        //Score increse
        score++;
    }    
    //Ball hiting side
    if(ball.getPosition().left<0 || ball.getPosition().left+10 >window.getSize().x)
    {
        ball.reboundSide();
    }
   //Ball are hiting the bat
   if(ball.getPosition().intersects(bat.get_Position()))
   {
    ball.reboundBatOrTop();
    score++;
   } 
//draw the window
window.clear();
window.draw(hud);
window.draw(bat.get_Shape());
window.draw(ball.getShape());
window.display();

    }
    return 0;
}