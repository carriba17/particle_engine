package com.particle_engine;

import processing.core.PApplet;

public class Square {
    PApplet main;
    float x, y; // Location of the ball
    float xVel = 1, yVel = 1; // Velocity of the ball
    float xDirection = 1;//X direction of ball
    float yDirection = 1; // Y Direction of the ball 
    float squareSize = 10;// Size of the square
    int sqaureColor = 0; // Color of the ball

    Square(float x_, float y_, float squareSize_, PApplet main_, int squareColor_){
        x = x_;
        y= y_;
        squareSize = squareSize_;
        main = main_;
        sqaureColor = squareColor_;
    }

    public void draw(){
        main.fill(sqaureColor);
        main.rect(x, y, squareSize, squareSize);
    }


}

    
