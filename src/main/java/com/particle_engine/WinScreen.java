package com.particle_engine;

import processing.core.PApplet;

public class WinScreen {
PApplet parent;

WinScreen(PApplet parent){
    this.parent= parent; 
}

public void draw(){
    parent.background(0, 255, 0);  // Green background for win
    parent.textSize(35);
    parent.fill(255);
    parent.text("You Win!", 300, 250);
    parent.textSize(25);
    parent.text("Press 'n' to play again", 250, 350);
}//End Draw class

}//End Class EndScreen