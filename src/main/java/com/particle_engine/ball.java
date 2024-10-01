package com.particle_engine;

import processing.core.*;

public class Ball extends Particle {
    PApplet main;
    float x, y; // Location of the ball
    float xVel = 1, yVel = 1; // Velocity of the ball
    float xDirection = 1, yDirection = 1; // Direction of the ball
    float radius; // Size of the ball
    int ballColor; // Color of the ball

    Ball(float x_, float y_, float xVel_, float yVel_, PApplet main_, int c) {
        super(x_, y_, xVel_, yVel_, main_, c);
    }

    // Drawing the ball and updating its movement
    public void draw() {
        main.fill(ballColor);
        main.ellipse(x, y, radius, radius);
        move();
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
        return x* y;
    }
}
