//Carter Arribas
//CRCP III
//Square class designed to coordinate squares
package com.particle_engine;

import processing.core.PApplet;


//Square Public class
public class Square extends Particle {
    float size; // Size of the square

    //Assigning Square Constructors
    public Square(float x, float y, float size, PApplet main, int color) {
        super(x, y, main.random(-3, 3), main.random(-3, 3), main, color);
        this.size = size;
    }

    @Override
    public void draw() {
        main.fill(color);
        main.rect(x, y, size, size);
    }

    @Override
    float getSize() {
        return size;
    }

    // Custom behavior when mouse is clicked: reverse velocity
    public void onClick() {
        xVel *= -1.5;
        yVel *= -1.5;
    }

    // When S key is pressed the square color changes
    public void onKeyPress(char key) {
        if (key == 's') {
            color = main.color(main.random(255), main.random(255), main.random(255));
        }
    }
}
