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
import GUIComponents.Space;
import SpaceObjs.SpaceProjectile;
import java.awt.Polygon;
import java.awt.Color;

public class Shot extends SpaceProjectile {

    private int[] xarr = {4, 0, -4, -4, 4};
    private int[] yarr = {4, 6, 4, -4, -4};
    private int[] xarrTurn1 = new int[5];
    private int[] yarrTurn1 = new int[5];

    private Polygon polygon1;

    public Shot( int d, int t, int x, int y, int si, int sp, Polygon p) {
        super( d, t, x, y, si, sp, p);
    }
    public Shot(int d, int x, int y) {
        super( d, 0, x, y, 5, 20, new Polygon());
    }
    public Shot() {
        super( 0, 0, 0, 0, 5, 20, new Polygon());
    }
    public Polygon polygonShot() {
        return this.polygonShot();
    }
     @Override
    public void startProjectile() {
        super.setxPosition((int) (super.getxPosition() - (Math.cos(Math.toRadians(super.getDirection())) * (15 * super.getSize()))));
        super.setyPosition((int) (super.getyPosition() - (Math.sin(Math.toRadians(super.getDirection())) * (15 * super.getSize()))));
        super.setDirection(super.getDirection());
    }
    public void leaveScreen() {
        //When SpaceProjectile has left the screen
    }
//    @Override
//    public void hitSpaceObject(SpaceObject spaceobj) {
//        //SpaceObject explosion = new SpaceExplosion(spaceobj.getxPosition(), spaceobj.getyPosition(), spaceobj.getSize());
//         Space.spaceList.remove(spaceobj);
//         //Space.addSpaceObject(explosion);
//       
//    }
    @Override
    public void turnPolygon() {
        double xtemp, ytemp, length, angle;
        for (int i = 0; i < xarr.length; i++) {
            xtemp = this.xarr[i];
            ytemp = this.yarr[i];
            angle = (Math.atan2(ytemp, xtemp));
            angle = Math.toDegrees(angle);
            length = Math.sqrt(Math.pow(xtemp, 2) + Math.pow(ytemp, 2));
            xtemp = length * Math.cos(Math.toRadians(angle + super.getDirection() - 90));
            ytemp = length * Math.sin(Math.toRadians(angle + super.getDirection() - 90));
            xarrTurn1[i] = (int) (xtemp);
            yarrTurn1[i] = (int) (ytemp);
        }
    }
    @Override
    // Create a square shaped polygon
    public void setPolygon() {
        Polygon currentShotImage = new Polygon();
        double xtemp, ytemp;
        int x, y;
        for (int i = 0; i < 5; i++) {
            xtemp = getxPosition();
            ytemp = getyPosition();
            x = (int) (xtemp - (this.xarrTurn1[i]));
            y = (int) (ytemp - (this.yarrTurn1[i]));
            currentShotImage.addPoint(x, y);
        }
        this.polygon1 = currentShotImage;
    }
    @Override
    public Polygon getPolygon() {
        return this.polygon1;
    }
}