package com.particle_engine;

import processing.core.PApplet;

public class StartScreen {
PApplet parent;
    StartScreen(PApplet parent){
        this.parent = parent;
    }


    public void draw(){
        parent.background(0);
        parent.textSize(35);
        parent.text("Start Screen", 300, 250);
        parent.textSize(25);
        parent.text("Press n to start Particle Engine", 200, 350);
    }



}
