//Carter Arribas September 10th 2024
//CRCPIII
//Particle Engine Ball class

package com.particle_engine;

import processing.core.*;

public class ball {
    PApplet main;//Provides the functionallity for the code

    ball ball1;

    float x,y; //location of the ball
    float yVel = 1;
    float y_direction = 1; //Direction 1 is down, -1 is up
    float radius; //width of the ball
    int ballColor;

    ball(float x_, float y_, float radius_, PApplet main_, int c){
        x = x_;
        y = y_;
        radius = radius_;
        main = main_;
        ballColor = c;
    }

    void setup(){
      
    }

    public void draw(){

        main.fill(ballColor);
        main.ellipse(x,y,radius,radius);
        move();

    }

    void move(){
        y += yVel*y_direction;
        if(y > main.height){
            y_direction = -1;
        }
        if(y < 0){
            y_direction = 1;
        }
      

    }

    void faster(){
        yVel++;
    }

    public void mousePressed(){
        faster();
    }
}//End Ball class
