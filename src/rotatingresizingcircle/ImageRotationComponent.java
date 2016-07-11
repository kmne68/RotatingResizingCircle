/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotatingresizingcircle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author kemery
 */
    class ImageRotationComponent extends JComponent {

    int x = 50;                 // upper left corner x-coordinate
    int y = 50;                 // upper left corner y-coordinate
    int emptyCircleX = 75;      // upper left X of a rectangle defining an empty circle
    int emptyCircleY = 75;      // upper left Y of a rectangle defining an empty circle
    int filledCircleX = 400;    // upper left X of a rectangle defining a filled circle
    int filledCircleY = 400;    // upper left Y of a rectangle defining a filled circle
    int width = 100;            // width of rectangle defining the circles
    int height = 100;           // height of rectangle defining the circles
    
    int cornerX = 250;          // upper left X of rectangle defining a circle, used to keep center in same spot as circle changes size
    int cornerY = 250;          // upper left Y of rectangle defining a circle, used to keep center in same spot as circle changes size
    
    int XDiameter = 2; 
    int YDiameter = 2;     
        
    boolean grow = true;
    
    Rectangle r = new Rectangle(x, y, 15, 15);
    Ellipse2D circleEmpty = new Ellipse2D.Double(0, 0, 0, 0); 
    Ellipse2D circleFilled = new Ellipse2D.Double(0, 0, 0, 0);
    Point center = new Point(125, 125);
    double angle = 0.0;
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            angle += 100;       // Changing angle rotates shapes            
            Graphics2D g2 = (Graphics2D) g.create();
            
            // Draws a filled, rotating, expanding circle in the center of the screen
            AffineTransform ellipseTransFilled = AffineTransform.getRotateInstance(-angle, filledCircleX + circleFilled.getWidth()/2, filledCircleY + circleFilled.getHeight()/2); // original rotating circle
            Shape transformedFilled = ellipseTransFilled.createTransformedShape(circleFilled);    // circle rotate  
            g2.setColor(Color.blue);   // sets fill color to blue
            g2.draw(transformedFilled);  // fill the rotating, expanding circle
            g2.setColor(Color.yellow);
            g2.fill(transformedFilled);
            
            // Draws unfilled, rotating, growing circle
            AffineTransform ellipseTrans = AffineTransform.getRotateInstance(angle, emptyCircleX + (circleEmpty.getWidth()/2), emptyCircleY + (circleEmpty.getHeight()/2));      
            Shape transformedUnfilled = ellipseTrans.createTransformedShape(circleEmpty);    // rotate circle 
            g2.setColor(Color.green);
            g2.draw(transformedUnfilled);            // draw the circle            
                       
            // Draws a rotating square
            AffineTransform trans = AffineTransform.getRotateInstance(angle, x + r.getWidth()/2, y + r.getHeight()/2); // rotates square around its own center         
         // trans = AffineTransform.getRotateInstance(angle, 50, 50);  // If enabled, square rotates around the specified point
                  
            // draws line that extends as w and h increase 
            g2.draw(new Line2D.Double( emptyCircleX, emptyCircleY, width, height ) );  
                        
            // Rotating square
            Shape transformedSquare = trans.createTransformedShape(r); // square to rotate
            g2.fill(transformedSquare);     // draw the square
            
            SuperSizeCircle();      // grow/shrink circles
            circleEmpty.setFrame(emptyCircleX, emptyCircleY, width, height);        // Unfilled circle
            circleFilled.setFrame(filledCircleX, filledCircleY, width, height);     // Black filled circle
        } // end paintComponent()

        
        // Call the image rotation pieces and set them in motion
        public ImageRotationComponent() {
            int delay = 100; //milliseconds
            
            ActionListener taskPerformer = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ImageRotationComponent.this.repaint();
                }
            };
            new Timer(delay, taskPerformer).start();
        } // end ImageRotationComponent
        
        
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
        } // end SuperSizeCircle()
    } // end ImageRotationComponent
