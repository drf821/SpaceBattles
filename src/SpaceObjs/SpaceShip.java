package SpaceObjs;

// File name: SpaceShip

// Written by: Daniel Faubel
 
// Description: Has everything a Spaceship needs to run
//
//              
// Challenges: 
//
// Time Spent: 15 min

// Revision History:
// Date: 11/22/16      	15 min	By: Daniel Faubel     Action: Created The GUI Interface for StartMenu
// Date: 12/6/16        30 min  By: Daniel Faubel     Action: Added sets and gets for all SpaceShip variables
// Date: 12/7/16        15 min  By  Daniel Faubel     Action: asded what SpaceShip needed for it's action method
// Date: 12/9/16        60min   By: Daniel Faubel     Action :cleaned up the constructor in order to sync with the rest of the program

// ---------------------------------------------------
import GUIComponents.Space;
import SpaceObjs.SpaceObject;
import java.awt.event.*;
import java.awt.Polygon;
import java.awt.Color;

public class SpaceShip extends SpaceObject{
    private  int ForwardForce, BackwardForce;
    
    //Empty SpaceShip Constructor
    public SpaceShip(){
        super();
        this.ForwardForce = 0;
        this.BackwardForce = 0;
    }
    //Spaceship Constructor
    public SpaceShip(
                     int d, // Direction (degrees clockwise from the 3:00 position)
                     int t, int x, int y, int si, int sp, Polygon p, int f, int b){ 
        super( d, t, x, y, si, sp, p); 
        this.ForwardForce = f;
        this.BackwardForce = b;
    }
    //Set and get methods for Spaceship Variables
    public void setForwardForce(int val){
        this.ForwardForce = val;
    }
    public int getForwardForce(){
        return ForwardForce;
    }
    public void setBackwardForce(int val){
        this.BackwardForce = val;
    }
    public int getBackwardForce(){
        return BackwardForce;
    }   
    //An actions Method for SpaceShip
    
    @Override
    public void actions(){
        super.actions();   
    }
    
    // called in Space class when spacebar is pressed
    public void fireShot(){
        int d, x, y;
        d = this.getDirection();
        x = this.getxPosition();
        y = this.getyPosition();
        
        SpaceObject shot = new Shot(d, x, y);
        shot.setPolygon();
        shot.startProjectile();
        Space.addSpaceObject(shot);
        pause();
    }
    
    public void pause() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}