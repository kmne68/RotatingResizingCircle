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
    
    
    private int time;                           // time in seconds
    
    private int period;                         // time to complete one rotation
    private int teeth;                          // number of teeth on the gear
    private double angularFrequency;         // rotations per unit time
    private double module;                      // a rational number, indicates the tooth size and is the number of mm of pitch circle diameter (p.c.d.) per tooth
    private boolean isWheel;                    // the larger of two interacting gears
    private boolean isPinion;                   // the smaller of two interacting gears
    private double pitchDiameter;               // Value is based on the number of teeth, the normal module (or normal diametral pitch), and the helix angle.
    private Point axis;                         // Center of gear.
    private double angleOfAction;               // Angle with vertex at the gear center, one leg on the point where mating teeth first make contact, the other leg on the point where they disengage.
    private double outsideDiameter;             // Diameter at tips of teeth
    private double rootDiameter;                // Diameter at the base of the teeth
    private double addendum;                    // Radial distance from the pitch surface to the outermost point of the tooth. {\displaystyle a=(D_{o}-D)/2} a=(D_o-D)/2
    private double dedendum;                    // Radial distance from the depth of the tooth trough to the pitch surface. {\displaystyle b=(D-{\text{root diameter}})/2} b=(D-\text{root diameter})/2
    private double wholeDepth;                  // Addendum plus dedendum   
    private double diametralPitch;              // Ratio of the number of teeth to the pitch diameter

    /**
     * @return the period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    /**
     * @return the teeth
     */
    public int getTeeth() {
        return teeth;
    }

    /**
     * @param teeth the teeth to set
     */
    public void setTeeth(int teeth) {
        this.teeth = teeth;
    }

    /**
     * @return the angularFrequency
     */
    public double getAngularFrequency() {
        return angularFrequency;
    }

    /**
     * @param angularFrequency the angularFrequency to set
     */
    public void setAngularlFrequency(double radians, int seconds) {
        // 1 RPM = pi /30 rad/second
        this.angularFrequency = radians / seconds;
    }

    /**
     * @return the module
     */
    public double getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(double module) {
        this.module = module;
    }

    /**
     * @return the isWheel
     */
    public boolean isIsWheel() {
        return isWheel;
    }

    /**
     * @param isWheel the isWheel to set
     */
    public void setIsWheel(boolean isWheel) {
        this.isWheel = isWheel;
    }

    /**
     * @return the isPinion
     */
    public boolean isIsPinion() {
        return isPinion;
    }

    /**
     * @param isPinion the isPinion to set
     */
    public void setIsPinion(boolean isPinion) {
        this.isPinion = isPinion;
    }

    /**
     * @return the pitchDiameter
     */
    public double getPitchDiameter() {
        return pitchDiameter;
    }

    /**
     * @param pitchDiameter the pitchDiameter to set
     */
    public void setPitchDiameter(double pitchDiameter) {
        this.pitchDiameter = pitchDiameter;
    }

    /**
     * @return the axis
     */
    public Point getAxis() {
        return axis;
    }

    /**
     * @param axis the axis to set
     */
    public void setAxis(Point axis) {
        this.axis = axis;
    }

    /**
     * @return the angleOfAction
     */
    public double getAngleOfAction() {
        return angleOfAction;
    }

    /**
     * @param angleOfAction the angleOfAction to set
     */
    public void setAngleOfAction(double angleOfAction) {
        this.angleOfAction = angleOfAction;
    }

    /**
     * @return the outsideDiameter
     */
    public double getOutsideDiameter() {
        return outsideDiameter;
    }

    /**
     * @param outsideDiameter the outsideDiameter to set
     */
    public void setOutsideDiameter(double outsideDiameter) {
        this.outsideDiameter = outsideDiameter;
    }

    /**
     * @return the rootDiameter
     */
    public double getRootDiameter() {
        return rootDiameter;
    }

    /**
     * @param rootDiameter the rootDiameter to set
     */
    public void setRootDiameter(double rootDiameter) {
        this.rootDiameter = rootDiameter;
    }

    /**
     * @return the addendum
     */
    public double getAddendum() {
        return addendum;
    }

    /**
     * @param addendum the addendum to set
     */
    public void setAddendum(double addendum) {
        this.addendum = addendum;
    }

    /**
     * @return the dedendum
     */
    public double getDedendum() {
        return dedendum;
    }

    /**
     * @param dedendum the dedendum to set
     */
    public void setDedendum(double dedendum) {
        this.dedendum = dedendum;
    }

    /**
     * @return the wholeDepth
     */
    public double getWholeDepth() {
        return wholeDepth;
    }

    /**
     * @param wholeDepth the wholeDepth to set
     */
    public void setWholeDepth(double wholeDepth) {
        this.wholeDepth = wholeDepth;
    }

    /**
     * @return the diametralPitch
     */
    public double getDiametralPitch() {
        return diametralPitch;
    }

    /**
     * @param diametralPitch the diametralPitch to set
     */
    public void setDiametralPitch(double diametralPitch) {
        this.diametralPitch = diametralPitch;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }
    
    
    
}
