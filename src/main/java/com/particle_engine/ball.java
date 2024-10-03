package com.particle_engine;

import processing.core.*;

public class Ball extends Particle {
    PApplet main;
    float x, y; // Location of the ball
    float xVel, yVel; // Velocity of the ball
    float xDirection = 1, yDirection = 1; // Direction of the ball
    float radius; // Size of the ball
    int ballColor; // Color of the ball

    Ball(float x_, float y_, float xVel_, float yVel_, float radius_, PApplet main_, int c) {
        super(x_, y_, xVel_, yVel_, main_, c);
        main = main_; // Assign the passed PApplet instance to the local main
        x= x_;
        y = y_;
        xVel = xVel_;
        yVel = yVel_;
        radius = radius_;
        ballColor = c;

        // this.main = main_; // Assign the passed PApplet instance to the local main
        // this.x = x_;
        // this.y = y_;
        // this.xVel = xVel_;
        // this.yVel = yVel_;
        // this.radius = radius_;
        // this.ballColor = c;
    }

    // Drawing the ball and updating its movement
    public void draw() {
        main.fill(ballColor);
        main.ellipse(x, y, radius, radius);
        move();
    }

    // Method to update ball position based on velocity and direction
    public void move() {
        x += xVel * xDirection;
        y += yVel * yDirection;
    }

    // Increase speed when mouse is pressed
    void faster() {
        xVel += 0.5;
        yVel += 0.5;
    }

    // Change direction when mouse is moved
    void changeDirection() {
        xDirection *= -1;
        yDirection *= -1;
    }

    // Change color when mouse is dragged
    void changeColor() {
        ballColor = main.color(main.random(255), main.random(255), main.random(255));
    }

    // Reset position when 'r' is pressed on the keyboard
    void resetPosition() {
        x = main.random(main.width);
        y = main.random(main.height);
    }

    @Override
    float getSize() {
        return radius * radius; // Assuming you want the area of the circle
    }
}
