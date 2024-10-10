package com.particle_engine;

import processing.core.PApplet;

public class EndScreen {
PApplet parent;

EndScreen(PApplet parent){
    this.parent= parent; 
}

public void draw(){
    parent.background(255, 0, 0);  // Red background for lose
    parent.textSize(35);
    parent.fill(255);
    parent.text("You Lose!", 300, 250);
    parent.textSize(25);
    parent.text("Your guess was incorrect", 150, 300);
    parent.text("Press 'n' to try again", 250, 350);
}//End Draw class

}//End Class EndScreen
