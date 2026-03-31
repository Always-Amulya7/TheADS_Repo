// To run-g++ Pong.cpp Bat.cpp Ball.cpp -lsfml-graphics -lsfml-window -lsfml-system 

#include "Bat.h"
#include "Ball.h" 
#include <SFML/Graphics.hpp>
#include <sstream>
#include <cstdlib>
using namespace sf;

int main(){
    // Create Video Mode
    VideoMode vm(1366, 768);
    
    // Create the Window
    RenderWindow window(vm, "Pong", Style::Fullscreen);

    View view(FloatRect(0, 0, 1366, 768));
    window.setView(view);
    
    // Create Bat 
    Bat bat(1366/2, 768-20);

    // Create Ball
    Ball ball(1366/2, 0);

    // HUD
    Text hud;
    Font font;
    font.loadFromFile("font/DS-DIGI.TTF");
    hud.setFont(font);
    hud.setFillColor(Color::White);
    hud.setCharacterSize(50);
    hud.setPosition(20, 20);
    hud.setString("Score: 0   Lives: 3");
    
    // Initialize Score and Lives
    int score = 0;
    int lives = 3;

    // Manage Time
    Clock clock;

    while(window.isOpen()){

        // Handle Player Input
        Event event;
        while(window.pollEvent(event)){
            if(event.type == Event::Closed){
                window.close();
            }
        }

        // Handle Quitting Game
        if (Keyboard::isKeyPressed(Keyboard::Escape)){
            window.close();
        }

        // Handle the Playing Input
        if(Keyboard::isKeyPressed(Keyboard::Right)){
            if(bat.get_Position().left + bat.get_Position().width > 1366){
                bat.stopRight();
            } 
            else{
                bat.moveRight();
            }
        }
        else{
            bat.stopRight();
        }

        if(Keyboard::isKeyPressed(Keyboard::Left)){
            if(bat.get_Position().left < 0){
                bat.stopLeft();
            } 
            else{
                bat.moveLeft();
            }
        }
        else{
            bat.stopLeft();
        }

        // Manage the Time
        Time dt = clock.restart();

        // Update Bat
        bat.update(dt);

        // Update Ball
        ball.update(dt);

        // Update Score Message
        std::stringstream ss;
        ss << "Score: " << score << "  Lives: " << lives;
        hud.setString(ss.str());

        // Handle the ball hitting the bottom
        if(ball.get_Position().top > window.getSize().y){
            
            // Reverse the Ball Direction
            ball.reboundBottom();

            // Remove a live
            lives--;
            
            // Check for Zero Live
            if(lives<1){
                
                // Reset the Score
                score = 0;

                // Reset Lives
                lives = 3;
            }
        }

        // Ball Hitting the Top
        if(ball.get_Position().top < 0){
            
            ball.reboundBatOrTop();

            // Score Increase
            score++;

        }

        // Ball Hitting the Sides
        if(ball.get_Position().left < 0 || ball.get_Position().left + 10 > window.getSize().x){
            
            ball.reboundSide();

        }

        // Ball is hitting the Bat
        if(ball.get_Position().intersects(bat.get_Position())){

            ball.reboundBatOrTop();

            // Score Increase
            score++;

        }

        // Draw the Window
        window.clear();
        window.draw(hud);
        window.draw(bat.get_Shape());
        window.draw(ball.get_Shape());
        window.display();
    }
    return 0;
}