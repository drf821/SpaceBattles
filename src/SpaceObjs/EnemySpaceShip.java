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
import SpaceObjs.SpaceShip;
import java.awt.Polygon;
import java.util.Random;
import java.awt.Color;

public class EnemySpaceShip extends SpaceShip {
    
    Random rand = new Random();
    private int action, userX, userY;
        
      public EnemySpaceShip(){
        super();
        this.action = 80;
        this.userX = 0;
        this.userY = 0;
    }
    //Filled UserSpaceShip constructor
    public EnemySpaceShip(int d, int t, int x, int y, int si, int sp, Polygon p, int f, int b, int a){ //Polygon p,
        super( d, t, x, y, si, sp, p, f, b );//p,
        this.action = a;
        this.userX = 0;
        this.userY = 0;
    }
    public void onRightTurn(){
        setTurn(1);
    }
    public void onLeftTurn(){
        setTurn(-1);
    }
    public void offRightTurn(){
        setTurn(0);
    }
    public void offLeftTurn(){
        setTurn(0);
    }
    public void takeAction(){        
        aim();                
    }
    public void setX(int x){
        this.userX = x;
    }
    public void setY(int y){
        this.userY = y;
    }
    public void aim(){
        //Calculates The direction to face the user's ship and se't itself to turn itself to face to user or shoot if already facing the user.
        int xFinal, yFinal;
        
        double directionToUser, changeDirection ,shipDirection;
        
        xFinal = userX - this.getxPosition();
        yFinal =  userY - this.getyPosition();
        directionToUser = (Math.toDegrees(Math.atan2(yFinal, xFinal)));
        
        if(directionToUser < 0)
            directionToUser += 360;
        shipDirection = super.getDirection();
        if(shipDirection < 0)
            shipDirection += 360;
        changeDirection =  directionToUser - shipDirection ;
  
        if(changeDirection < 360 && changeDirection >= 183){
            this.onRightTurn();
        }
        else if(changeDirection < 183 && changeDirection >= 177){
            this.offLeftTurn();
            this.offRightTurn();
            if(rand.nextInt(action) == 1)
               shootUser();
                System.out.println("ChangeDirection in range");
                System.out.println("ChangeDirection is "+ changeDirection);
        }
        else if(changeDirection < 183 && changeDirection >= 0){
            this.onLeftTurn();
        }
        
        else if(changeDirection < 0 && changeDirection >= -177){
            this.onRightTurn();
        }
        else if(changeDirection < -177 && changeDirection > -183){
            this.offLeftTurn();
            this.offRightTurn();
            if(rand.nextInt(action) == 1)
               shootUser();
                System.out.println("ChangeDirection in range");
                System.out.println("ChangeDirection is "+ changeDirection);
        }
        else if(changeDirection <= -183 && changeDirection > -360){
            this.onLeftTurn();
        }   
    }
    public void shootUser(){
        this.fireShot();
    }
   @Override
    public void actions() {
        super.actions();
        takeAction();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException err) {
        }
    }
}