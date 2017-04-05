/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceObjs;
import GUIComponents.Space;

import java.awt.Polygon;

/**
 *
 * @author danie
 */
public class SpaceExplosion extends SpaceObject {
    
    
    private int[] xarr = {0, 10,  0, -10, 0};
    private int[] yarr = { 10, 0, -10, 0, 10};
    private int[] xarrTurn1 = new int[xarr.length];
    private int[] yarrTurn1 = new int[yarr.length];
    private double sizerate;
    private  int timer;
    private Polygon polygon1;

    private int[] xarr2, yarr2;
    public SpaceExplosion(int x, int y, int si){
        super(0, 0, x, y, si, 0, new Polygon() );
        sizerate = 1.00;
        //for(int i = 0; i < xarr.length; i++){
       xarr2 = xarr;
       yarr2= yarr;
       timer = 0;
       

    }
    
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
    public void actions(){
        timer += 1;
        if(timer >= 10){
            Space.spaceList.remove(this);
            System.out.println("timer greater than or equal to 20");
        }
        if(timer <= 5){
        for(int i = 0; i < xarr.length; i++){
            xarr[i] = (int)(this.xarr[i] * this.getSize()/(this.getSize()*.75));// * this.sizerate);
            yarr[i] = (int)(this.yarr[i] * this.getSize()/(this.getSize()*.75));// * this.sizerate);
        }
        }
        super.actions();
        
    }

    @Override
    public Polygon getPolygon() {
        return this.polygon1;
    }
    public int getTimer(){
        return this.timer;
    }
//@Override
//public void hitSpaceObject(SpaceObject spaceobj) {
//       
//
//    }
}