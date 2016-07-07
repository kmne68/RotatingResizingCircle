package rotatingresizingcircle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Keith
 */
public class RotatingResizingCircle {

    int x = 50;             // upper left corner x-coordinate
    int y = 50;             // upper left corner y-coordinate
    int emptyCircleX = 75;    // upper left X of a rectangle defining an empty circle
    int emptyCircleY = 75;    // upper left Y of a rectangle defining an empty circle
    int filledCircleX = 400;    // upper left X of a rectangle defining a filled circle
    int filledCircleY = 400;    // upper left Y of a rectangle defining a filled circle
    int width = 100;            // width of rectangle defining the circles
    int height = 100;           // height of rectangle defining the circles
    
    int cornerX = 250;      // upper left X of rectangle defining a circle, used to keep center in same spot as circle changes size
    int cornerY = 250;      // upper left Y of rectangle defining a circle, used to keep center in same spot as circle changes size
    
    int XDiameter = 2; // was 20
    int YDiameter = 2; // was 20    
        
    boolean grow = true;
    
    Rectangle r = new Rectangle(x, y, 15, 15);
    Ellipse2D circleEmpty = new Ellipse2D.Double(0, 0, 0, 0); 
    Ellipse2D circleFilled = new Ellipse2D.Double(0, 0, 0, 0);
    Point center = new Point(125, 125);
    
    
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
    
    
    private class ImageRotationComponent extends JComponent {

        double angle = 0.0;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D) g.create();
            angle += 100;       // Changing angle turns the objects
            
            // Draws a filled, rotating, expanding circle in the center of the screen
            AffineTransform ellipseTransFilled = AffineTransform.getRotateInstance(-angle, filledCircleX + circleFilled.getWidth()/2, filledCircleY + circleFilled.getHeight()/2); // original rotating circle
            Shape transformedFilled = ellipseTransFilled.createTransformedShape(circleFilled);    // circle rotate  
//          g2.setColor(Color.blue);   // sets fill color to blue
            g2.fill(transformedFilled);  // fill the rotating, expanding circle
            
            // Draws a rotating square
            AffineTransform trans = AffineTransform.getRotateInstance(angle, x + r.getWidth()/2, y + r.getHeight()/2); // rotates square around its own center         
//          trans = AffineTransform.getRotateInstance(angle, 50, 50);  // If enabled, squar rotates around the specified point
                  
            // draws line that extends as w and h increase 
            g2.draw(new Line2D.Double( emptyCircleX, emptyCircleY, width, height ) );  
            
            // Draws unfilled, rotating, growing circle
            AffineTransform ellipseTrans = AffineTransform.getRotateInstance(angle, emptyCircleX + (circleEmpty.getWidth()/2), emptyCircleY + (circleEmpty.getHeight()/2));      
            Shape newTransformed = ellipseTrans.createTransformedShape(circleEmpty);    // rotate circle  
            g2.draw(newTransformed);            // draw the circle
            
            // Rotating square
            Shape transformedSquare = trans.createTransformedShape(r); // square to rotate
            g2.fill(transformedSquare);     // draw the square
                  
        }

        
        // Call the circle enlargement and image rotation pieces and set them in motion
        public ImageRotationComponent() {
            int delay = 100; //milliseconds
            
            ActionListener taskPerformer = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    SuperSizeCircle();      // rotate circle
                    ImageRotationComponent.this.repaint();
                }
            };
            new Timer(delay, taskPerformer).start();
            
        }
        
        
        // Enlarge or shrink the cirlces.
        public void SuperSizeCircle() {

            if (width >= 800) {
                grow = false;
            }
            if (width <= 2) // was 20 
            {
                grow = true;
            }

            if (grow) {
                width += 2; 
                height += 2; 
      //          cornerX -= 1; 
        //        cornerY -= 1; 
            } else {
                width -= 2; 
                height -= 2; 
          //      cornerX += 1; // * XDiameter;
            //    cornerY += 1; // * YDiameter;
            }

            circleEmpty.setFrame(emptyCircleX, emptyCircleY, width, height);       // Unfilled circle
            circleFilled.setFrame(filledCircleX, filledCircleY, width, height);      // Black filled circle
        }
        
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