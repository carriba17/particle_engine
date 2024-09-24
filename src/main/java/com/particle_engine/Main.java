//Carter Arribas September 10th 2024
//CRCPIII
//Particle Engine

//Importing processing
package com.particle_engine;

import processing.core.*;


public class Main extends PApplet{

    Balls balls;

    public static void main(String[] args) {
        PApplet.main("com.particle_engine.Main");
    }

    //Setting sizes of canvas
    public void settings()
    {

        size(500,500);
        balls = new Balls(this);
    }

    //Setting size of canvas
    public void setup()
    {
        balls.setup();
        
    }

    //Drawing my canvas 
    //Decided to draw olympic rings
    public void draw()
    {
        balls.draw();
    }

    public void mousePressed(){
        balls.mousePressed();
    }

   
}