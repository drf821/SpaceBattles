package SpaceObjs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
import SpaceObjs.SpaceObject;
import java.awt.Polygon;
import java.awt.Color;

public class SpaceProjectile extends SpaceObject {
	
    public SpaceProjectile(int x, int y, int d, int sp, int si) {
    	super(x, y, d, sp, si);
    	
    }
    
    //A method when a SpaceProjectile leaves the screen
    public void startProjectile(){
    
    }
    public void leaveScreen(){
        //When SpaceProjectile has left the screen
    }
}