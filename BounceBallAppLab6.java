import java.awt.*;
import javax.swing.*;

public class BounceBallAppLab6 extends JApplet {
    public BounceBallAppLab6() {
	add(new BallControlLab6());
    }

    public static void main(String[] args) {
	BounceBallAppLab6 applet = new BounceBallAppLab6();
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("BounceBallAppLab9");
	frame.add(applet, BorderLayout.CENTER);
	frame.setSize(400, 320);
	frame.setVisible(true);
  }
}

