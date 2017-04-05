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
// Date: 12/6/16      	30 min      By Daniel Faubel        Action: Added a key listenr that will listen for up, down, left, right, and 
//                                                          space key presses.
// Date: 12/9/16            120min      By: Daniel Faubel     Action :Set up methods to be called from the keylistener in the space class

// ---------------------------------------------------
import SpaceObjs.SpaceShip;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import java.awt.Polygon;
import java.awt.Color;

public class UserSpaceShip extends SpaceShip {

    public UserSpaceShip(){
        super();
    }
    //Filled UserSpaceShip constructor
    public UserSpaceShip( int d, int t, int x, int y, int si, int sp, Polygon p, int f, int b){
        super(d, t, x, y, si, sp, p, f, b);
    }
    public void onForwardForce(){
        super.setSpeed(12);
    }
    public void onBackwardForce(){
        super.setSpeed(-12);
    }
    public void onRightTurn(){
        setTurn(1);
    }
    public void onLeftTurn(){
        setTurn(-1);
    }
    public void offForwardForce(){
        super.setSpeed(0);    
    }
    public void offBackwardForce(){
        super.setSpeed(0);   
    }
    public void offRightTurn(){
        setTurn(0);
    }
    public void offLeftTurn(){
        setTurn(0);
    }
    @Override
    public void actions(){
        super.actions();
    }
}    