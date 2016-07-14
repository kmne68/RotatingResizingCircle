/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rotatingresizingcircle;

/**
 *
 * @author Keith
 * 
 * For gears to mesh, their modules must be equal.
 * 
 */
public class Gear {
    
    int period;                         // time to complete one rotation
    int teeth;                          // number of teeth on the gear
    double rotationalFrequency;         // rotations per unit time
    double module;                      // a rational number, indicates the tooth size and is the number of mm of pitch circle diameter (p.c.d.) per tooth
    boolean isWheel;                    // the larger of two interacting gears
    boolean isPinion;                   // the smaller of two interacting gears
    
    
    
    
}
