package com.particle_engine;

import processing.core.*;

public class Triangle extends Particle {
    float size; // Side length of the triangle

    public Triangle(float x, float y, float size, PApplet main, int color) {
        super(x, y, main.random(-4, 4), main.random(-4, 4), main, color);
        this.size = size;
    }

    @Override
    public void draw() {
        main.fill(color);
        main.triangle(x, y - size / 2, x - size / 2, y + size / 2, x + size / 2, y + size / 2);
    }

    //Using similar height to get close to detection of triangles
    @Override
    float getSize() {
        return size / 2;
    }

    // Custom behavior when mouse is dragged: increase size
    public void onDrag() {
        size *= 1.1;
    }

    // Custom behavior when a specific key is pressed (e.g., 't' for triangle)
    public void onKeyPress(char key) {
        if (key == 't') {
            xVel += 1; // Increase speed along x-axis
            yVel += 1; // Increase speed along y-axis
        }
    }
}
