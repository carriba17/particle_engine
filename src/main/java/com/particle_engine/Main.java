// Carter Arribas September 10th 2024
// CRCPIII
// Particle Engine main class
//This is the main class used to function everything

package com.particle_engine;

import processing.core.*;
import java.util.ArrayList;
import javax.swing.*;

//Main fuction used to execute everything
public class Main extends PApplet {

    ArrayList<Particle> particles;
    int gameState = 0; //Start Screen 0, Running game 1, Win Screen 2, Lose Screen 3
    StartScreen startScreen;

    public static void main(String[] args) {
        PApplet.main("com.particle_engine.Main");
    }

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        particles = new ArrayList<>();
        startScreen = new StartScreen(this);
        // Adding different types of particles
        for (int i = 0; i < 7; i++) {
            particles.add(new Ball(random(width), random(height), random(1, 3), random(1,3), random(20, 40), this, color(random(255), random(255), random(255))));
            particles.add(new Square(random(width), random(height), random(20, 40), this, color(random(255), random(255), random(255))));
            particles.add(new Triangle(random(width), random(height), random(30, 50), this, color(random(255), random(255), random(255))));
        }
    }
    public void draw() {
        //Draw Start Screen
        if(gameState == 0){
            startScreen.draw();
        }
        //Drawing Win Screen
        else if(gameState == 2){
            startScreen.draw();
        }
        //Draw Lose Screen
        else if(gameState == 3){
            startScreen.draw();
        }
        else{
            background(0);
            for (Particle p : particles) {
                p.move();
                p.draw();
            }//End for loop
        }//End Else
    }//End Draw Loop

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
            gameState = 1;
        }
        for (Particle p : particles) {
            p.onKeyPress(key);
        }
    }
}

