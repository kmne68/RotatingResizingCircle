/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rotatingresizingcircle;

import java.awt.Point;

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
    double pitchDiameter;               // Value is based on the number of teeth, the normal module (or normal diametral pitch), and the helix angle.
    Point axis;                         // Center of gear.
    double angleOfAction;               // Angle with vertex at the gear center, one leg on the point where mating teeth first make contact, the other leg on the point where they disengage.
    double outsideDiameter;             // Diameter at tips of teeth
    double rootDiameter;                // Diameter at the base of the teet
    double addendum;                    // Radial distance from the pitch surface to the outermost point of the tooth. {\displaystyle a=(D_{o}-D)/2} a=(D_o-D)/2
    double dedendum;                    // Radial distance from the depth of the tooth trough to the pitch surface. {\displaystyle b=(D-{\text{root diameter}})/2} b=(D-\text{root diameter})/2
    double wholeDepth;                  // Addendum plus dedendum   
    double diametralPitch;              // Ratio of the number of teeth to the pitch diameter
    
    
    
}
