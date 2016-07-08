package rotatingresizingcircle;

/*
 * This program combines applies two types of animation (resizing and rotation) 
 * to a circle and was conceived to enable the animation of a "machine" that
 * represents the economy's reaction to changes if inputs.
 * 
 */

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Keith
 */
public class RotatingResizingCircle {

 
    public static void main(String[] args) {
        new RotatingResizingCircle();
    }
    

    public RotatingResizingCircle() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Testing");
                frame.setSize(1000, 1000);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ImageRotationComponent());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);       
            }
        });
    }
    
}


/**
 *             // Points for a crude, stationary gear drawn in upper left corner. Hasn't been animated
            gear.addPoint(7, 1);
            gear.addPoint(9, 1);
            gear.addPoint(9, 3);
            gear.addPoint(10, 3);
            gear.addPoint(12, 4);
            gear.addPoint(13, 5);
            gear.addPoint(13, 6);
            gear.addPoint(15, 6);
            gear.addPoint(15, 8);
            gear.addPoint(13, 8);
            gear.addPoint(13, 9);
            gear.addPoint(12, 10);
            gear.addPoint(10, 11);
            gear.addPoint(9, 11);
            gear.addPoint(9, 13);
            gear.addPoint(7, 13);
            gear.addPoint(7, 11);
            gear.addPoint(6, 11);
            gear.addPoint(4, 10);
            gear.addPoint(3, 9);
            gear.addPoint(3, 8);
            gear.addPoint(1, 8);
            gear.addPoint(1, 6);
            gear.addPoint(3, 6);
            gear.addPoint(3, 5);
            gear.addPoint(4, 4);
            gear.addPoint(6, 3);
            gear.addPoint(7, 3);  
 */