// Carter Arribas September 10th 2024
// CRCPIII
// Particle Engine main class
//This is the main class used to function everything
//This project Design is based on a particle engine where many random shapes and objects are bouncing off the walls of the screen
//As the project gets mjore developed it will look more and more like a game

package com.particle_engine;

import processing.core.*;
import java.util.ArrayList;
import javax.swing.*;

//Main fuction used to execute everything
public class Main extends PApplet {

    //Establishing variables and Screens
    int gameState = 0; //Start Screen 0, Running game 1, Win Screen 2, Lose Screen 3
    ArrayList<Particle> particles;
    StartScreen startScreen;
    EndScreen endScreen;
    WinScreen winScreen;
    String currentShape;  // Shape to guess
    int correctCount;
    float randomShapeCount = random(7,20);  // Correct number of shapes
    boolean guessedCorrectly = false;  // Track if guess was correct
    boolean isGuessing = false;  // Track whether we're in the guessing phase
    boolean started = false;

    
    public static void main(String[] args) {
        PApplet.main("com.particle_engine.Main");
    }

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        particles = new ArrayList<>();
        startScreen = new StartScreen(this);
        endScreen = new EndScreen(this);
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

        if (!started && frameCount > 180) {  // Delay using frameCount
            isGuessing = true;
            promptGuess();  // Prompt the user for the guess
            started = true;  // Prevent further prompting
        }

        //Drawing Win Screen
        else if(gameState == 2){
            winScreen.draw();
        }
        //Draw Lose Screen
        else if(gameState == 3){
            endScreen.draw();
        }
        else if(gameState == 1){
            background(0);
            for (Particle p : particles) {
                p.move();
                p.draw();
            }//End for loop
        }//End Else
        println(gameState);
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
        if (key == 'n') {
            if (gameState == 2 || gameState == 3) {
                // Reset the game after win or lose screen
                started = false;
                gameState = 0;
            } 
            else if (gameState == 0) {
                // Start the guessing game
                started = false;
                gameState = 1;

    }
        }//End if Statement
    }//End key Pressed

       // Function to prompt the user for their guess
       public void promptGuess() {
        if (!isGuessing) return;

        String[] shapes = {"triangle", "square", "ball"};
        currentShape = shapes[(int) random(3)];  // Randomly choose a shape to guess
        correctCount = countShapes(currentShape);  // Count the number of that shape

        String input = JOptionPane.showInputDialog("How many " + currentShape + "s are on screen?");
        int guess = Integer.parseInt(input);

        if (guess == correctCount) {
            guessedCorrectly = true;
            gameState = 2;  // Win screen
        } 
        else {
            guessedCorrectly = false;
            gameState = 3;  // Lose screen
        }
        isGuessing = false;  // Stop further guessing after one prompt
    } //End Prompt Guess
    
    public int countShapes(String shapeType) {
        int count = 0;
        for (Particle p : particles) {
            if ((shapeType.equals("triangle") && p instanceof Triangle) ||
                (shapeType.equals("square") && p instanceof Square) ||
                (shapeType.equals("ball") && p instanceof Ball)) {
                count++;
            }
        }
        return count;
    }//End Count Shape
}//End Main Class

