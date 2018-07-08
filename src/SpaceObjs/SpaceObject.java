package SpaceObjs;

// File name: SpaceObject

// Written by: Daniel Faubel
// Description: SpaceObject has variables and methods that other SpaceObjects are extended from
//              
// Challenges:  hi
//
// Time Spent: 30 min
// Revision History:
// Date: 11/22/16           30min	By: Daniel Faubel     Action: Created The GUI Interface for StartMenu
// Date: 12/5/16            30min       By Daniel Faubel      Action: Gave SpaceObject a polygon variable and I added 2 get methods 
//                                                                    for the X and Y. Also added a getPolygon method
// Date 12/6/16             60min       By Daniel Faubel      Action: added Sets and Gets for each variable
// Date 12/7/16             15min       By Daniel Faubel      Action: gave SpaceObject the action position method to calculate change in position
// Date 12/8/16             15min       By Daniel Faubel      Action: Cleaned up SpaceObject so other Objects like SpaceShip could extend from it
// Date: 12/9/16            60min      By: Daniel Faubel     Action :Set up polygon so each spaceobject could have a shape polygon
// ---------------------------------------------------
import GUIComponents.Space;
import java.util.ArrayList;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.lang.Math;
import java.util.concurrent.TimeUnit;
import java.awt.Polygon;
import java.awt.Color;

public class SpaceObject {

    //Declares SpaceObject int values
    private                             int                         direction, xPosition, yPosition, size, speed, turn;
    private                             Color                       c;
    private                             Polygon                     polygon;

    private                             int[]                       xarr             =              {0, 20, 0, -20, 0};
    private                             int[]                       yarr             =              {50, -30, -10, -30, 50};
    
    private                             int[]                       xarrTurn         =              new         int[xarr.length];
    private                             int[]                       yarrTurn         =              new         int[yarr.length];

    //Empty SpaceObject constructor
    public SpaceObject() {
        
        
        this.direction                   =                          90;
        this.turn                        =                          0;
        this.xPosition                   =                          600;
        this.yPosition                   =                          450;
        this.size                        =                          25;
        this.speed                       =                          0;
        
        this.polygon                     =              new         Polygon(xarr, yarr, 5);
    }

    //Filled SpaceObject Constructor
    public SpaceObject( int d, int t, int x, int y, int si, int sp, Polygon p) {//, Polygon p){
        this.direction                   =              d;
        this.turn                        =              t;
        this.yPosition                   =              y;
        this.xPosition                   =              x;
        this.size                        =              si;
        this.speed                       =              sp;
        
        this.polygon                     =      new     Polygon(xarr, yarr, 5);
    }
    public SpaceObject( int d, int x, int y, int sp, Polygon p) {//, Polygon p){
        this.direction                   =              d; // Direction (degrees clockwise from the 3:00 position)
        this.turn                        =              0;
        this.yPosition                   =              y;
        this.xPosition                   =              x;
        this.size                        =              50; // consider removing
        this.speed                       =              0; //consider removing
        
        this.polygon                     =      new     Polygon(xarr, yarr, 5);
    }

    //get and set methods for all SpaceObject Variables
    public int getTurn() {
        return turn;
    }

    public void setTurn(int t) {
        this.turn = t;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int val) {
        this.size = val;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int val) {
        this.direction = val;
    }

    public int getxPosition()// Used to aquire the Space Objects current X Position
    {
        return xPosition;
    }

    public void setxPosition(int val) {
        this.xPosition = val;
    }

    public int getyPosition() // Used to aquire the Space Objects current Y Position
    {
        return yPosition;
    }

    public void setyPosition(int val) {
        this.yPosition = val;
    }

    public void setSpeed(int val) {
        this.speed = val;
    }

    public int getSpeed() {
        return speed;
    }

    
    //the setPosition method is called every itteration of the while loop and will make any changes to the X and Y Positions based off of the ibjects direction and speed
    public void setPosition() {
        yPosition -= Math.sin(Math.toRadians(direction)) * speed;
        xPosition -= Math.cos(Math.toRadians(direction)) * speed;
    }
    // turnPolygon takes  xarr and yarr, and then calculates new X and Y cordinates of the SpaceObject at it's current direction
    public void turnPolygon() {
        double xtemp, ytemp, length, angle;

        for (int i = 0; i < xarr.length; i++) {
            xtemp = xarr[i];
            ytemp = yarr[i];
            angle = (Math.atan2(ytemp, xtemp));
            angle = Math.toDegrees(angle);
            length = Math.sqrt(Math.pow(xtemp, 2) + Math.pow(ytemp, 2));
            xtemp = length * Math.cos(Math.toRadians(angle + direction - 90));
            ytemp = length * Math.sin(Math.toRadians(angle + direction - 90));
            this.xarrTurn[i] = (int) (xtemp);
            this.yarrTurn[i] = (int) (ytemp);
        }
    }
    // The setPolygon method takes the xarrTurn and yarrTurn arrays and makes a polygon assigning it to polygon
    public void setPolygon() {
        Polygon Ship = new Polygon();
        double xtemp, ytemp;
        int x, y;
        for (int i = 0; i < xarrTurn.length; i++) {
            xtemp = getxPosition();
            ytemp = getyPosition();
            x = (int) (xtemp - (this.xarrTurn[i]));
            y = (int) (ytemp - (this.yarrTurn[i]));
            Ship.addPoint(x, y);
        }
        this.polygon = Ship;
    }
    // returns the spaceObjects polygon variable
    public Polygon getPolygon() {
        return this.polygon;
    }
    //The getPolygonFinal method calls the methods turnPolygon, setPolygon, and getPolygon annd returns the Polygon retrieved by getPolygon
    public Polygon getPolygonFinal(){
        this.turnPolygon();
        this.setPolygon();
        return this.getPolygon();
    }
    // In order to create a shot the startProjectile method takes the SpaceObjects Position, direction and size and calculates a position that a shot can start at in order
    // to prevent a collision between the SpaceObject and the shot.
    public void startProjectile() {
        xPosition = ((int) (xPosition - (Math.sin(Math.toRadians(direction)) * (8 * (size+speed)))));
        yPosition = ((int) (yPosition - (Math.sin(Math.toRadians(direction)) * (8 * (size+speed)))));
    }

    //the hitSpaceObject method responds to a collision with another SpaceObject from an object of the Space Class
    public void hitSpaceObject(SpaceObject spaceobj) {
        if(!(spaceobj instanceof SpaceExplosion)){
        SpaceObject explosion = new SpaceExplosion(spaceobj.getxPosition(), spaceobj.getyPosition(), spaceobj.getSize());
        
        Space.spaceList.remove(spaceobj);       
        Space.addSpaceObject(explosion);
        }
    }

    //The actions method preforms calculations  that affect the SpaceObjects position and Direction every iteration of the While loop in the Space Class
    public void actions() {
        int xtemp, ytemp, angle;
        angle = this.getDirection();
        xtemp = (int) (speed * Math.cos(Math.toRadians(direction)));
        ytemp = (int) (speed * Math.sin(Math.toRadians(direction)));
        if (yPosition - ytemp <= 1030 && yPosition - ytemp >= 30 && xPosition - xtemp <= 1880 && xPosition - xtemp >= 30) {
            this.setyPosition(yPosition - ytemp);
            this.setxPosition(xPosition - xtemp);
        }
        direction += turn * 5;
        if (direction < 0) {
            direction += 360;
        } else if (direction > 360) {
            direction -= 360;
        }
    }
}
