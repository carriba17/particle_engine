package com.particle_engine;

import processing.core.PApplet;

// Particle superclass
public abstract class Particle {
    PApplet main;
    float x, y; // Position
    float xVel, yVel; // Velocity
    int color; // Color

    public Particle(float x, float y, float xVel, float yVel, PApplet main, int color) {
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        this.main = main;
        this.color = color;
    }

    public void move() {
        x += xVel;
        y += yVel;

        // Bounce off edges
        if (x > main.width || x < 0) {
            xVel *= -1;
        }
        if (y > main.height || y < 0) {
            yVel *= -1;
        }
    }

    public abstract void draw(); // Abstract method for drawing

    // Particle Collsion
    public void checkCollision(Particle other) {
        // Simple circle collision detection
        if (PApplet.dist(x, y, other.x, other.y) < (this.getSize() + other.getSize())) {
            xVel *= -1;
            yVel *= -1;
        }
    }

    // Method to return size for collision detection
    abstract float getSize();
    
    public void onKeyPress(char key) {
        if (key == 't') {
            xVel += 1; // Increase speed along x-axis
            yVel += 1; // Increase speed along y-axis
        }
    }
}

