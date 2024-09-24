// Carter Arribas September 10th 2024
// CRCPIII
// Particle Engine main class

package com.particle_engine;

import processing.core.*;
import java.util.ArrayList;

//Main fuction used to execute everything
public class Main extends PApplet {

    Balls balls;

    public static void main(String[] args) {
        PApplet.main("com.particle_engine.Main");
    }

    // Setting canvas size
    public void settings() {
        size(500, 500);
    }

    // Initializing particles
    public void setup() {
        balls = new Balls(this);
        balls.setup();
    }

    // Drawing the canvas
    public void draw() {
        balls.draw();
    }

    // Mouse interaction for various behaviors
    public void mousePressed() {
        balls.mousePressed();
    }

    public void mouseMoved() {
        balls.mouseMoved();
    }

    public void mouseDragged() {
        balls.mouseDragged();
    }

    // Keyboard interaction
    public void keyPressed() {
        balls.keyPressed(key);
    }
}
