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
import java.awt.Image;
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
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Keith
 */
public class RotatingResizingCircle {

    int x = 50; // upper left corner x
    int y = 50; // upper left corner y
    int x1 = 75;
    int y1 = 75;
    int x2 = 400;
    int y2 = 400;
    int x3 = 110;
    int y3 = 110;
    int w = 100;
    int h = 100;
    
    int cornerX = 250;      // upper left X
    int cornerY = 250;      // upper left Y
    
    int XDiameter = 2; // was 20
    int YDiameter = 2; // was 20    
        
    boolean grow = true;
    
    
    Rectangle r = new Rectangle(x, y, 15, 15);
    Ellipse2D c = new Ellipse2D.Double(0, 0, 0, 0); 
    Ellipse2D c2 = new Ellipse2D.Double(0, 0, 0, 0);
    Polygon p = new Polygon();
    double polyAngle = 0.0;

 //   Point[] points1;    // Polygon points
    Point center = new Point(125, 125);
    Polygon poly1;
    
    
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
    
        public void SuperSizeCircle() {
        
        if (w >= 800) {
            grow = false;
        }
        if (w <= 2) // was 20 
        {
            grow = true;
        }

        if (grow) {
            w += 2; 
            h += 2; 
            cornerX -= 1; 
            cornerY -= 1; 
        } else {
            w -= 2; 
            h -= 2; 
            cornerX += 1; // * XDiameter;
            cornerY += 1; // * YDiameter;
        }
        
        System.out.println("x = " + x1 + "     y = " + y1 + "     w = " + w + "     h = " + h );
        
        c.setFrame(x1, y1, w, h);
        c2.setFrame(x2, y2, w, h);
    }
    
    private class ImageRotationComponent extends JComponent {

        double angle = 0.0;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // Points for first gear
            p.addPoint(7, 1);
            p.addPoint(9, 1);
            p.addPoint(9, 3);
            p.addPoint(10, 3);
            p.addPoint(12, 4);
            p.addPoint(13, 5);
            p.addPoint(13, 6);
            p.addPoint(15, 6);
            p.addPoint(15, 8);
            p.addPoint(13, 8);
            p.addPoint(13, 9);
            p.addPoint(12, 10);
            p.addPoint(10, 11);
            p.addPoint(9, 11);
            p.addPoint(9, 13);
            p.addPoint(7, 13);
            p.addPoint(7, 11);
            p.addPoint(6, 11);
            p.addPoint(4, 10);
            p.addPoint(3, 9);
            p.addPoint(3, 8);
            p.addPoint(1, 8);
            p.addPoint(1, 6);
            p.addPoint(3, 6);
            p.addPoint(3, 5);
            p.addPoint(4, 4);
            p.addPoint(6, 3);
            p.addPoint(7, 3); 
            
  //          points1 = getOriginalPoints(1);
            
  //          poly1 = polygonize(points1);
            
            Graphics2D g2 = (Graphics2D) g.create();
            polyAngle++;
            if(polyAngle >= 360)
            {
                polyAngle = 0;
            }
            
            angle += 100;
            
            // Draws a filled rotatin, expanding circle in the center of the screen
            AffineTransform ellipseTransFilled = AffineTransform.getRotateInstance(-angle, x2 + c2.getWidth()/2, y2 + c2.getHeight()/2); // original rotating circle
            Shape transformedFilled = ellipseTransFilled.createTransformedShape(c2);    // circle rotate  
//            g2.setColor(Color.blue);   // sets color to blue
            g2.fill(transformedFilled);  // fill the rotating, expanding circle
            
            // Draws a rotating square
            AffineTransform trans = AffineTransform.getRotateInstance(angle, x + r.getWidth()/2, y + r.getHeight()/2); // rotates square around its own center         
//            trans = AffineTransform.getRotateInstance(angle, 50, 50);  // rotates square around the specified point
                  
            // draws line that extends as w and h increase 
            g2.draw( new Line2D.Double( x1, y1, w, h ) );  
            
            // Draws unfilled rotating, growing circle
            AffineTransform ellipseTrans = AffineTransform.getRotateInstance(angle, x1 + (c.getWidth()/2), y1 + (c.getHeight()/2));      
            Shape newTransformed = ellipseTrans.createTransformedShape(c);    // rotate circle  
            g2.draw(newTransformed);
            
            // Rotating square
            Shape transformed = trans.createTransformedShape(r); // square to rotate
            g2.fill(transformed);     // square to rotate
       
            // Draw gear polygon
            g2.draw(p);
            
        }

        public ImageRotationComponent() {
            int delay = 100; //milliseconds
    //        rotatePointMatrix(getOriginalPoints(1), polyAngle, points1);
            
            ActionListener taskPerformer = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    
    //            angle += 0.1;           // rotate circle
                SuperSizeCircle();      // rotate circle
                
                    ImageRotationComponent.this.repaint();
                }
            };
            new Timer(delay, taskPerformer).start();
            
        }
        
 /*       public Point[] getOriginalPoints(int type)
        {
            Point[] op = new Point[28];
            if(type == 1)
            {
            op[0] = new Point(247 , 241 );
            op[1] = new Point(249, 241);
            op[2] = new Point(249, 243);
            op[3] = new Point(260, 243);
            op[4] = new Point(262, 244);
            op[5] = new Point(263, 245);
            op[6] = new Point(263, 246);
            op[7] = new Point(265, 246);
            op[8] = new Point(265, 248);
            op[9] = new Point(263, 248);
            op[10] = new Point(263, 249);
            op[11] = new Point(262, 260);
            op[12] = new Point(260, 261);
            op[13] = new Point(249, 261);
            op[14] = new Point(249, 263);
            op[15] = new Point(247, 263);
            op[16] = new Point(247, 261);
            op[17] = new Point(246, 261);
            op[18] = new Point(244, 260);
            op[19] = new Point(243, 249);
            op[20] = new Point(243, 248);
            op[21] = new Point(241, 248);
            op[22] = new Point(241, 246);
            op[23] = new Point(243, 246);
            op[24] = new Point(243, 245);
            op[25] = new Point(244, 244);
            op[26] = new Point(246, 243);
            op[27] = new Point(247, 243);
            }
            return op;
        }  */
        
        public void rotatePointMatrix(Point[] origPoints, double angle, Point[] storeTo)
        {
            AffineTransform.getRotateInstance(Math.toRadians(polyAngle), center.x, center.y).transform(origPoints, 0, storeTo, 0, 28);
            
        }
        
        public Polygon polygonize(Point[] polyPoints)
        {
            Polygon tempPoly = new Polygon();
            for(int i = 0; i < polyPoints.length; i++)
            {
                tempPoly.addPoint(polyPoints[i].x, polyPoints[i].y);
            }
            return tempPoly;
        }
        
    }
}
