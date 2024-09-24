package com.particle_engine;

import processing.core.*;

public class ball {
    PApplet main;
    float x, y; // Location of the ball
    float xVel = 1, yVel = 1; // Velocity of the ball
    float xDirection = 1, yDirection = 1; // Direction of the ball
    float radius; // Size of the ball
    int ballColor; // Color of the ball

    ball(float x_, float y_, float radius_, PApplet main_, int c) {
        x = x_;
        y = y_;
        radius = radius_;
        main = main_;
        ballColor = c;
    }

    // Drawing the ball and updating its movement
    public void draw() {
        main.fill(ballColor);
        main.ellipse(x, y, radius, radius);
        move();
    }

    // Movement with edge detection (bounce)
    void move() {
        x += xVel * xDirection;
        y += yVel * yDirection;

        // Bounce off edges
        if (x > main.width || x < 0) {
            xDirection *= -1;
        }
        if (y > main.height || y < 0) {
            yDirection *= -1;
        }
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
}
