package com.particle_engine;

import java.util.ArrayList;
import processing.core.*;

public class Balls {


    PApplet main;
    ArrayList<Balls> balls;
    ball ball1;//Test case ball

    Balls(PApplet main_){
        main = main_;
        balls = new ArrayList<Balls>();

    }

    public void setup(){
        main.background(0);
        ball1 = new ball(main.width/2.0f,main.height*.10f,50.0f, main, main.color(main.random(255),main.random(255),main.random(255)));
    }

    public void draw(){
        main.background(0);
        ball1.draw();
    }

    public void mousePressed(){
        ball1.mousePressed();
    }
}
