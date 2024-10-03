// Carter Arribas September 10th 2024
// CRCPIII
// Particle Engine main class
//This is the main class used to function everything

package com.particle_engine;

import processing.core.*;
import java.util.ArrayList;

//Main fuction used to execute everything
public class Main extends PApplet {

    ArrayList<Particle> particles;
    boolean started = false;

    public static void main(String[] args) {
        PApplet.main("com.particle_engine.Main");
    }

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        particles = new ArrayList<>();
        // Adding different types of particles
        for (int i = 0; i < 7; i++) {
            particles.add(new Ball(random(width), random(height), random(1, 3), random(1,3), random(20, 40), this, color(random(255), random(255), random(255))));
            particles.add(new Square(random(width), random(height), random(20, 40), this, color(random(255), random(255), random(255))));
            particles.add(new Triangle(random(width), random(height), random(30, 50), this, color(random(255), random(255), random(255))));
        }
    }
    public void draw() {
        if(started == false){
            background(0);
            textSize(35);
            text("Start Screen", 300, 250);
            textSize(35);
            text("Start Screen", 300, 250);
        }
        else{
            background(0);
            for (Particle p : particles) {
                p.move();
                p.draw();
            }//End for loop
        }//End Else
       
    }

    public void mousePressed() {
        for (Particle p : particles) {
            if (p instanceof Square) {
                ((Square) p).onClick();
            }
        }
    }

    public void mouseDragged() {
        for (Particle p : particles) {
            if (p instanceof Triangle) {
                ((Triangle) p).onDrag();
            }
        }
    }

    public void keyPressed() {
        if(key == 'n' ){
            started = true;
        }
        for (Particle p : particles) {
            p.onKeyPress(key);
        }
    }
}
