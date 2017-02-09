//Name: Ash Khan
//Date: 04/12/2016
//Filename: SimpleBall.java
//Assignment: Java Applet
//Description: This code creates a simple ball with the extenstion of JPanel.
//Basic properties of ball are set in this SimpleBall class including radius,
//speed, color and initial position.

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SimpleBall extends JPanel {
    private int x;
    private int y;
    private int radius;
    private int dx;
    private int dy;
    private Color color;


    public SimpleBall() {
	//Creates a ball with random color, radius, and position on screen
	Random generator = new Random();
	x = generator.nextInt(500); 
	y = generator.nextInt(5); // Current ball position 
	radius = generator.nextInt(15) + 5; //Ball radius
	dx = generator.nextInt(5) + 1; // Increment on ball's x-coordinate
	dy = generator.nextInt(5) + 1; // Increment on ball's y-coordinate
	color = new Color(generator.nextInt(256),
			  generator.nextInt(256),
			  generator.nextInt(256));
    }

    public int getX() {
	//Returns x coordinate of Ball
	return x;
    }
    
    public int getY() {
	//Return y coordinate of Ball
	return y;
    }
    
    public int getRadius() {
	//Returns radius of the ball
	return radius;
    }
    
    public void addtoX(int dx) {
	//Move the ball by adding dx to ball's x coordinate
	x += dx;
    }
    
    public void addtoY(int dy) {
	//Move the ball by adding dy to ball's y coordinate
	y += dy;
    }

    public void oppositeDx() {
	//Move the ball in opposite x direction
	dx *= -1;
    }
    
    public void oppositeDy() {
	//Move the ball in opposite y direction
	dy *= -1;
    }
    
    public int getdX() {
	//Returns the horizontal speed of ball
	return dx;
    }

    public int getdY() {
	//Returns the verticle speed of ball
	return dy;
    }

    public Color getColor() {
	//Returns the color of the ball
	return color;
    }

    public void multDx(int var) {
	//Multiply the horizontal speed of ball by var
	dx *= var;
    }

    public void multDy(int var) {
	//Multiply the vertical speed of ball by var
	dy *= var;
    }
    
    
}
	