#include<SFML/Graphics.hpp>
#include<sstream>
#include<SFML/Audio.hpp>

using namespace sf;

void updateBranches(int);

const int NUM_BRANCHES = 6;
enum class side{LEFT, RIGHT, NONE};
side branchPositions[NUM_BRANCHES];
Sprite Branches[NUM_BRANCHES];

int main(){

    //Create Video Mode Object
    //VideoMode vm(1920,1080);
    VideoMode vm=VideoMode::getDesktopMode();
    //Rendering window
    RenderWindow window(vm,"Timber!!!");
    View view(FloatRect(0, 0, 1920, 1080));
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
    beeSprite.setPosition(2000,800);

    bool beeActive=false;
    float beeSpeed=0.0f;
    float beeHeight=0.0f;

    Texture cloudTexture;
    cloudTexture.loadFromFile("graphics/cloud.png");

    Sprite cloudSprite1;
    cloudSprite1.setTexture(cloudTexture);
    cloudSprite1.setPosition(0,0);

    bool cloudSpriteActive1=false;
    float cloudSpriteSpeed1=0.0f;
    float cloudSpriteHeight1=0.0f;


    Sprite cloudSprite2;
    cloudSprite2.setTexture(cloudTexture);
    cloudSprite2.setPosition(0,150);

    bool cloudSpriteActive2=false;
    float cloudSpriteSpeed2=0.0f;
    float cloudSpriteHeight2=0.0f;

    Sprite cloudSprite3;
    cloudSprite3.setTexture(cloudTexture);
    cloudSprite3.setPosition(0,300);

    bool cloudSpriteActive3=false;
    float cloudSpriteSpeed3=0.0f;
    float cloudSpriteHeight3=0.0f;

    Clock clock;
    float timeRemaining = 6.0f;
    bool paused = true;
    
    RectangleShape timeBar;
    float timeBarStartWidth=400.0f;
    float timeBarHeight = 80.0f;

    timeBar.setSize(Vector2f(timeBarStartWidth,timeBarHeight));
    timeBar.setFillColor(Color::Red);
    timeBar.setPosition(1920/2 - timeBarStartWidth/2.0, 980);
    float timeBarWidthPerSecond = timeBarStartWidth/timeRemaining;

    int score=0;
    Text scoreText;
    Font font;
    font.loadFromFile("fonts/KOMIKAP_.ttf");
    scoreText.setFont(font);
    scoreText.setCharacterSize(75);
    scoreText.setFillColor(Color::White);
    scoreText.setString("Score = 0");
    scoreText.setPosition(20,20);

    Text messageText;
    messageText.setFont(font);
    messageText.setFillColor(Color::White);
    messageText.setCharacterSize(100);
    messageText.setString("Press Enter to Start the Game");

    FloatRect textRect = messageText.getLocalBounds();
    messageText.setOrigin(textRect.left + textRect.width/2.0,textRect.top + textRect.height/2.0);
    messageText.setPosition(1920/2.0,1080/2.0);

    //Branches
    Texture branchTexture;
    branchTexture.loadFromFile("graphics/branch.png");

    for(int i=0;i<NUM_BRANCHES;i++){
        
            Branches[i].setTexture(branchTexture);
            Branches[i].setPosition(-2000,-2000);
            Branches[i].setOrigin(220,20);
                    
    }
    
    //***************Player
    Texture texturePlayer;
    texturePlayer.loadFromFile("graphics/player.png");
    Sprite spritePlayer;
    spritePlayer.setTexture(texturePlayer);
    spritePlayer.setPosition(580,720);


    //***************Side of the Player
    side sidePlayer=side::LEFT;


    //***************Grave stone
    Texture textureRIP;
    textureRIP.loadFromFile("graphics/rip.png");
    Sprite spriteRIP;
    spriteRIP.setTexture(textureRIP);
    spriteRIP.setPosition(600,860);


    //***************Axe
    Texture textureAxe;
    textureAxe.loadFromFile("graphics/axe.png");
    Sprite spriteAxe;
    spriteAxe.setTexture(textureAxe);
    spriteAxe.setPosition(700,830);


    //***************Line up the Axe with the Tree
    const int AXE_POSITION_LEFT = 700;
    const int AXE_POSITION_RIGHT = 1075;

    //***************Flying Log
    Texture textureLog;
    textureLog.loadFromFile("graphics/log.png");
    Sprite spriteLog;
    spriteLog.setTexture(textureLog);
    spriteLog.setPosition(810,720);

    //***************Other declarations for flying Log
    bool logActive=false;
    float logSpeedX=1000;
    float logSpeedY=-1500;

    //***************Player Input
    bool acceptInput=false;

    //******* Prepare the sounds
    SoundBuffer chopBuffer;
    chopBuffer.loadFromFile("sound/chop.wav");
	SoundBuffer ootBuffer;
    ootBuffer.loadFromFile("sound/out_of_time.wav");
    SoundBuffer deathBuffer;
    deathBuffer.loadFromFile("sound/death.wav");

    //******* chopping
    Sound chopSound;
    chopSound.setBuffer(chopBuffer);
    
    //******* Out of time
    Sound ootSound;
    ootSound.setBuffer(ootBuffer);

    //******* Sound of death
    Sound deathSound;
    deathSound.setBuffer(deathBuffer);


    while(window.isOpen()){

        //***************Handle user input
        Event event;
        while(window.pollEvent(event)){
            if(event.type==Event::KeyReleased && !paused){
                acceptInput=true;
                spriteAxe.setPosition(2000,spriteAxe.getPosition().y);
            }
        }

        //Handle the Players input
        if(Keyboard::isKeyPressed(Keyboard::Escape)){
            window.close();
        }

        //start the game
        if(Keyboard::isKeyPressed(Keyboard::Return)){

            paused=false;
            //Reset time
            timeRemaining =6;
            //***************Reset score
            score=0;
            
            //***************Make all branches disappear
            for(int i=0;i<NUM_BRANCHES;i++){
                branchPositions[i]=side::NONE;
            }

            //***************Make Grave Stone hidden
            spriteRIP.setPosition(675,2000);

            //***************Move the player into the position
            spritePlayer.setPosition(580,720);            
            
            //***************Make acceptInput true
            acceptInput=true;

        }

        //***************Wrap the player-controls right and left cursor keys
        //***************to make sure Game is accepting input properly
        if(acceptInput){
            //***************Handle Right Cursor Key
            if(Keyboard::isKeyPressed(Keyboard::Right)){
                //***************update score
                score++;

                //***************update time remaining
                timeRemaining+=2/score+.15;

                //***************set the player side to Right
                sidePlayer=side::RIGHT;

                //***************set the player position
                spritePlayer.setPosition(1200,720);

                //***************set the Axe position
                spriteAxe.setPosition(AXE_POSITION_RIGHT,spriteAxe.getPosition().y);

                //***************set the log position, log-Speed on X to fly on the left, logActive enabled
                spriteLog.setPosition(810,720);
                logSpeedX=-5000;
                logActive=true;          
                
                //***************update branches
                updateBranches(score);

                //***************acceptInput to false
                acceptInput=false;

                //***************play a chop sound
                chopSound.play();

            }

            //***************Handle Left Cursor Key
            if(Keyboard::isKeyPressed(Keyboard::Left)){

                //***************update score
                score++;

                //***************update time remaining
                timeRemaining+=2/score+.15;

                //***************set the player side to Left
                sidePlayer=side::LEFT;

                //***************set the player position
                spritePlayer.setPosition(580,720);

                //***************set the Axe position
                spriteAxe.setPosition(AXE_POSITION_LEFT,spriteAxe.getPosition().y);

                //***************set the log position, log-Speed on X to fly on the right, logActive enabled
                spriteLog.setPosition(810,720);
                logSpeedX=5000;
                logActive=true;              

                //***************update branches
                updateBranches(score);

                //***************acceptInput to false
                acceptInput=false;

                //***************play a chop sound
                chopSound.play();

            }

        }

        //Update the Scene

        if(!paused){
            //Update the scene to start

            Time dt=clock.restart();
            timeRemaining -=dt.asSeconds();

            timeBar.setSize(Vector2f(timeBarWidthPerSecond*timeRemaining, timeBarHeight));


            if(timeRemaining<=0.0f){
                paused=true;

                //***************Show "Out of Time!!!" message at the center of the window
                messageText.setString("Out of Time!!!");
                textRect=messageText.getLocalBounds();
                messageText.setOrigin(textRect.left+textRect.width/2.0,textRect.top+textRect.height/2.0);
                messageText.setPosition(window.getSize().x/2.0,window.getSize().y/2.0);               
                
                //***************play "out of time" sound
                ootSound.play();

            }

            //Handling bee

            if(!beeActive){
                //Set the bee's speed, height and position
                srand((int)time(0)*10);
                beeSpeed=(rand()%200)+200;
            
                srand((int)time(0)*20);
                beeHeight=(rand()%500)+500;

                beeSprite.setPosition(2000,beeHeight);
                beeActive=true;

            }
            else{
                //Move the bee
                beeSprite.setPosition(beeSprite.getPosition().x - beeSpeed*dt.asSeconds(), beeSprite.getPosition().y);
                if(beeSprite.getPosition().x < -100){
                    beeActive=false;
                }

            }

            //Handling clouds

            // Cloud 1

            if(!cloudSpriteActive1){
                //Set the cloud's speed, height and position
                srand((int)time(0)*10);
                cloudSpriteSpeed1=rand()%200;
            
                srand((int)time(0)*10);
                cloudSpriteHeight1=rand()%150;

                cloudSprite1.setPosition(-200,cloudSpriteHeight1);
                cloudSpriteActive1=true;

            }
            else{
                //Move the cloud
                cloudSprite1.setPosition(cloudSprite1.getPosition().x + cloudSpriteSpeed1*dt.asSeconds(), cloudSprite1.getPosition().y);
                if(cloudSprite1.getPosition().x > 1920){
                    cloudSpriteActive1=false;
                }
            }


            //Cloud 2
        
        
            if(!cloudSpriteActive2){
                //Set the cloud's speed, height and position
                srand((int)time(0)*20);
                cloudSpriteSpeed2=rand()%200;
            
                srand((int)time(0)*20);
                cloudSpriteHeight2=rand()%300 - 150;

                cloudSprite1.setPosition(-200,cloudSpriteHeight2);
                cloudSpriteActive2=true;

            }
            else{
                //Move the cloud
                cloudSprite2.setPosition(cloudSprite2.getPosition().x + cloudSpriteSpeed2*dt.asSeconds(), cloudSprite2.getPosition().y);
                if(cloudSprite2.getPosition().x > 1920){
                    cloudSpriteActive2=false;
                }
            }    


            //Cloud 3

            if(!cloudSpriteActive3){
                //Set the cloud's speed, height and position
                srand((int)time(0)*30);
                cloudSpriteSpeed3=rand()%200;
            
                srand((int)time(0)*30);
                cloudSpriteHeight3=rand()%450 - 150;

                cloudSprite3.setPosition(-200,cloudSpriteHeight3);
                cloudSpriteActive3=true;

            }
            else{
                //Move the cloud
                cloudSprite3.setPosition(cloudSprite3.getPosition().x + cloudSpriteSpeed3*dt.asSeconds(), cloudSprite3.getPosition().y);
                if(cloudSprite3.getPosition().x > 1920){
                    cloudSpriteActive3=false;
                }    

            }

            std :: stringstream ss;
            ss << "Score = " << score;
            scoreText.setString(ss.str());

            //update branches
            for(int i=0;i<NUM_BRANCHES;i++){
                float heightBranch = i*150;
                if(branchPositions[i]==side::LEFT){
                    Branches[i].setPosition(600,heightBranch);
                    Branches[i].setRotation(180); //flip;

                }
                else if(branchPositions[i]==side::RIGHT){
                    Branches[i].setPosition(1330,heightBranch);
                    Branches[i].setRotation(0); //no flip;
                }
                else{
                    Branches[i].setPosition(3000,heightBranch);
                    //Branches[i].setRotation(0); //no flip;
                }
            }

            //***************Handle a flying log
            if(logActive){
                spriteLog.setPosition(spriteLog.getPosition().x+logSpeedX*dt.asSeconds(),spriteLog.getPosition().y+logSpeedY*dt.asSeconds());
                //check the log if it reaches to the boundary, set it again at initial position and logActive to false.
                if(spriteLog.getPosition().x<-100 || spriteLog.getPosition().x>2000){
                    spriteLog.setPosition(810,720);
                    logActive=false;
                }
            }


            //***************Has the player been squished by a branch? Check and update
            if(branchPositions[5]==sidePlayer){
                //***************pause the game
                paused=true;

                //***************accepting no input
                acceptInput=false;                
                
                //***************hide the player
                spritePlayer.setPosition(2000,2000);

                //***************show the grave stone
                spriteRIP.setPosition(525,760);

                //***************show "Game Over!!!" message
                messageText.setString("Game Over!!!");
                textRect=messageText.getLocalBounds();
                messageText.setOrigin(textRect.left+textRect.width/2.0,textRect.top+textRect.height/2.0);
                messageText.setPosition(1920/2.0,1080/2.0);

                //***************play sound of death
                deathSound.play();

            }

        } //End of if(!paused)
               

        //Clear window
        window.clear();
        window.setView(view);
        //draw 
        window.draw(backgroundSprite);

        window.draw(cloudSprite1);
        window.draw(cloudSprite2);
        window.draw(cloudSprite3);
        for(int i=0;i<NUM_BRANCHES;i++){
            window.draw(Branches[i]);
        }
        window.draw(treeSprite);

        //***************draw player, axe, log and grave stone
        
        window.draw(spritePlayer);
        window.draw(spriteAxe);
        window.draw(spriteLog);
        window.draw(spriteRIP);        
        
        window.draw(beeSprite);

        window.draw(timeBar);

        window.draw(scoreText);
        
        if(paused)
           window.draw(messageText);           

        
           //display
        window.display();
        
    } //End of while loop

    return 0;
} //End of  main()

//definition of updateBranches(int)

void updateBranches(int seed){

    //shift branch position values to one place to vacant the position 0
    for(int i=NUM_BRANCHES-1;i>0;i--){
        branchPositions[i]=branchPositions[i-1];
    }
    //Spawn new branch position to 0th place
    srand(time(0) + seed);
    int r = rand()%5;
    switch(r){
        case 0:branchPositions[0]=side::LEFT;
        break;
        case 1:
        branchPositions[0]=side::RIGHT;
        break;
        default: branchPositions[0]=side::NONE;
    }
}
