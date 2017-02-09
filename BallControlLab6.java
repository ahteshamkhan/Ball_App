//Name: Ash Khan
//Date: 04/12/2016
//Filename: BallControlLab6.java
//Assignment: Java Applet
//Description: An array containing SimpleBall are added to panel. A new ball is
//added to screen when +1 button is hit and the last added ball is removed when
//-1 button is hit. Start button is added which turns to stop button when 
//clicked to stop or start the motion of balls on the panel. 

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BallControlLab6 extends JPanel {
    private JButton jbtStart = new JButton("Start");
    private JButton jbt1 = new JButton("+1");
    private JButton jbt0 = new JButton("-1");
    private JScrollBar jsbDelay = new JScrollBar(); 
    private BallLab6 balls = new BallLab6();

    public BallControlLab6() {
	// Group buttons in a panel
	JPanel panel = new JPanel();
	panel.add(jbtStart);
	panel.add(jbt1);
	panel.add(jbt0);
	    	
    // Add ball and buttons to the panel
	jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
	setLayout(new BorderLayout());
	add(jsbDelay, BorderLayout.NORTH);
	add(panel, BorderLayout.SOUTH);
	balls.setBorder(new javax.swing.border.LineBorder(Color.red));
	balls.setDelay(jsbDelay.getMaximum());
	add(balls, BorderLayout.CENTER);
	
	jbtStart.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (jbtStart.getText() == "Stop") {
			balls.suspend();
			jbtStart.setText("Start");
		    }
		    else {
			balls.resume();
			jbtStart.setText("Stop");
		    }	    
		}
	    });
	
	//Add a new ball when +1 button is hit
	jbt1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    balls.AddBall();
		}		
	    });
	
	//Remove the last added ball when -1 button is hit
	jbt0.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    balls.RemoveBall();
		}
	    });
	
	//change the speeds of all the balls when scrolling using the bar 
	jsbDelay.addAdjustmentListener(new AdjustmentListener() {
		public void adjustmentValueChanged(AdjustmentEvent e) {
		    balls.setDelay(jsbDelay.getMaximum() - e.getValue());	
		}
	    });
    }
}

