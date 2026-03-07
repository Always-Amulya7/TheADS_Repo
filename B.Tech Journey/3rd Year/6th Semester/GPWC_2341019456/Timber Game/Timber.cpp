#include<SFML/Graphics.hpp>
#include<iostream>
using namespace sf;
int main(){
    VideoMode vm(1920,1080);
    RenderWindow window(vm,"Timber!!!");
    View view(FloatRect(0,0,1920,1000));
    window.setView(view);
    Texture backgroundTexture;
    backgroundTexture.loadFromFile("graphics/background.png");
    Sprite backgroundSprite;
    backgroundSprite.setTexture(backgroundTexture);
    backgroundSprite.setPosition(0,0);
    Texture treeTexture;
    treeTexture.loadFromFile("graphics/tree.png");
    Sprite treeSprite;
    treeSprite.setTexture(treeTexture);
    treeSprite.setPosition(810,0);
    Texture beeTexture;
    beeTexture.loadFromFile("graphics/bee.png");
    Sprite beeSprite;
    beeSprite.setTexture(beeTexture);
    beeSprite.setPosition(200,800);
    bool beeActive=false;
    float beeSpeed=0.0f;
    float beeHeight=0.0f;
    Texture cloudTexture;
    cloudTexture.loadFromFile("graphics/cloud.png");
    Sprite cloudSprite1,cloudSprite2,cloudSprite3;
    cloudSprite1.setTexture(cloudTexture);
    cloudSprite1.setPosition(0,0);
    cloudSprite2.setTexture(cloudTexture);
    cloudSprite2.setPosition(0,150);
    cloudSprite3.setTexture(cloudTexture);
    cloudSprite3.setPosition(0,300);
    Clock clock;
    while(window.isOpen()){
        // VS code stops freezing
        Event event;
        while(window.pollEvent(event)){
            if(event.type==Event::Closed){
                window.close();
            }
        }
        if(Keyboard::isKeyPressed(Keyboard::Escape)){
            window.close();
        }
        Time dt=clock.restart();
        if(!beeActive){
            srand((int)time(0)*10);
            beeSpeed=(rand()%200)+200;
            srand((int)time(0)*20);
            beeHeight=(rand()%500)+500;
            beeSprite.setPosition(2000,beeHeight);
            beeActive=true;
        }
        window.setView(view);
        window.clear();
        window.draw(backgroundSprite);
        window.draw(cloudSprite1);
        window.draw(cloudSprite2);
        window.draw(cloudSprite3);
        window.draw(treeSprite);
        window.draw(beeSprite);
        window.display();
    }
    return 0;
}