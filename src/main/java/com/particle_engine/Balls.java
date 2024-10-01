// //Carter Arribas
// //CRCP III
// //Particle Engine Balls class, used to operate the multitude of balls

// //Getting packages and importing useful tools
// package com.particle_engine;
// import processing.core.*;
// import java.util.ArrayList;


// public class Balls {
//     PApplet main;
//     ArrayList<Ball> balls;

//     Balls(PApplet main_) {
//         main = main_;
//         balls = new ArrayList<Ball>();
//     }

//     // Initialize 500+ particles
//     public void setup() {
//         for (int i = 0; i < 500; i++) {
//             balls.add(new Ball(main.random(main.width), main.random(main.height), main.random(10, 30), main,
//                     main.color(main.random(255), main.random(255), main.random(255))));
//         }
//     }

//     public void draw() {
//         main.background(0);
//         for (Ball b : balls) {
//             b.draw();
//         }
//     }

//     // Mouse click interaction - Increase speed
//     public void mousePressed() {
//         for (Ball b : balls) {
//             b.faster();
//         }
//     }

//     // Mouse moved interaction - change direction
//     public void mouseMoved() {
//         for (Ball b : balls) {
//             b.changeDirection();
//         }
//     }

//     // Mouse dragged interaction - change color
//     public void mouseDragged() {
//         for (Ball b : balls) {
//             b.changeColor();
//         }
//     }

//     // Keyboard interaction - reset positions when p is clicked
//     public void keyPressed(char key) {
//         if (key == 'p') {
//             for (Ball b : balls) {
//                 b.resetPosition();
//             }
//         }
//     }
// }
