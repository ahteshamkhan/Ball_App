//Name: Ash Khan
//Date: 04/12/2016
//Filename: BallLab6.java 
//Assignment: Java Applets
//Description: BallLab6 class handles an array list of balls whom elements are 
//type SimpleBall with set properties. Bouncing of balls and collisions with 
//boundaries or with each other is handled in this code. Basic methods such as 
//adding a new ball or remove ball are also implemented in this file. 
//TimerListener class is implemented to suspend or resume the timer for all the
//balls in the BallLab6 class.

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class BallLab6 extends JPanel {
    private int delay = 10;    
  // Create a timer with delay 1000 ms
    private Timer timer = new Timer(delay, new TimerListener());
    private ArrayList<SimpleBall> ballArray = new ArrayList<SimpleBall>();

    public BallLab6() {
	timer.start();
    }
    
    private class TimerListener implements ActionListener {
	@Override /** Handle the action event */
	    public void actionPerformed(ActionEvent e) {
	    repaint();
	}
    }
   
    @Override

	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	for (int i = 0; i < ballArray.size(); i++) {
	    //Go through array list and repaint every ball
	    SimpleBall ball = ballArray.get(i);
	    g.setColor(ball.getColor());
	    
	    // Check boundaries for all the balls in array list
	    if (ball.getX() < 0 || ball.getX() > getWidth()) 
		ball.multDx(-1);
	    if (ball.getY() < 0 || ball.getY() > getHeight()) 
		ball.multDy(-1);
	    
	    // Adjust ball position for all the balls in array list
	    ball.addtoX(ball.getdX());
	    ball.addtoY(ball.getdY());
	    g.fillOval(ball.getX() - ball.getRadius(), 
		       ball.getY() - ball.getRadius(), 
		       ball.getRadius() * 2, ball.getRadius() * 2);
	    for (int j = 0; j < ballArray.size(); j++) {
		//Check if any different balls collided, change direction if so
	    	SimpleBall otherball = ballArray.get(j);
	    	if (BallIntersect(ball, otherball) && i != j) {
	    	    ball.oppositeDx();
	    	    ball.oppositeDy();
	    	    otherball.oppositeDx();
	    	    otherball.oppositeDy();
	    	}
	    }
	    
	}   
    }

    public boolean BallIntersect(SimpleBall ball1, SimpleBall ball2) {
	//Returns true if two balls intersect each other which indicates 
	//collision. 

	int diffX = ball1.getX() - ball2.getX();
	int diffY = ball1.getY() - ball2.getY();
	double distance = Math.sqrt((diffX * diffX) + (diffY * diffY));
	int RadiusSum = ball1.getRadius() + ball2.getRadius();
	if (distance <= RadiusSum)
	    return true;
	else
	    return false;
    }
    
    //Adds a new ball to the ballArray list
    public void AddBall() {
	ballArray.add(new SimpleBall());
    }
    
    //Removes the last added ball from the ballArray list
    public void RemoveBall() {
	if (ballArray.size() > 0) 
	    ballArray.remove(ballArray.size() - 1);
	else
	    return;
    }

    public void suspend() {
	timer.stop(); // Suspend timer
    }
    
    public void resume() {
	timer.start(); // Resume timer
    }
    
    public void setDelay(int delay) {
	this.delay = delay;
	timer.setDelay(delay);
    }
}



