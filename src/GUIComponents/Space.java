package GUIComponents;

// File name: Space

// Written by: Daniel Faubel
// Description: is the panel that all SpaceObjects are placed on
//              
// Challenges: 
//
// Time Spent: 15 min
// Revision History:
// Date: 11/29/16           15min	By: Daniel Faubel     Action: added paintComponent, Set, and CheckPositions methods
// Date: 12/8/16            60min       By: Daniel Faubel     Action: added Set Method to handle each set for SpaceObjects
// Date: 12/9/16            240min      By: Daniel Faubel     Action :added basic threading to operate the entire program. Made Space 
//                                                            both a KeyListener and a Runnable by implementing. Space will initiate all
//                                                            SpaceObjects and watch while game is going.
// ---------------------------------------------------
import SpaceObjs.EnemySpaceShip;
import SpaceObjs.SpaceFreighter;

import SpaceObjs.Shot;
import SpaceObjs.UserSpaceShip;
import SpaceObjs.SpaceObject;
import SpaceObjs.SpaceExplosion;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.*;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import java.awt.geom.Area;

public class Space extends JPanel implements Runnable, KeyListener {

	public static ArrayList<SpaceObject> spaceList;
	UserSpaceShip userShip;
	Random rand = new Random();
	int f;

	public Space(int level, int difficulty) {
		spaceList = new ArrayList<SpaceObject>();
		spaceList.clear();

		userShip = new UserSpaceShip(960, 800, 90);

		spaceList.add(userShip);
		// the value of difficulty will determine f ore the frequency whhen the game is played
		switch (difficulty + 1) {
		case 1:
			f = 50;
			break;
		case 2:
			f = 40;
			break;
		case 3:
			f = 30;
			break;
		case 4:
			f = 20;
			break;
		case 5:
			f = 12;
			break;
		}
		// the value of level will determine the EnemySpaceShips that will be on the screen
		switch (level + 1) {


		case 1:
			spaceList.add(new SpaceFreighter(960, 100, 270, f));
			break;
		case 2:
			spaceList.add(new SpaceFreighter(720, 200, 270, f));
			spaceList.add(new SpaceFreighter(1200, 200, 270, f));
			break;
		case 3:
			spaceList.add(new SpaceFreighter(320, 200,  270,f));
			spaceList.add(new SpaceFreighter(960, 100, 270, f));
			spaceList.add(new SpaceFreighter(1600, 200, 270, f));
			break;
		case 4:

			spaceList.add(new SpaceFreighter(320, 100,  270, f));
			spaceList.add(new SpaceFreighter(640, 200, 270, f));
			spaceList.add(new SpaceFreighter(1280, 200, 270, f));
			spaceList.add(new SpaceFreighter(1600, 100, 270,  f));
			break;
		case 5:
			spaceList.add(new SpaceFreighter(320, 250, 270, f));
			spaceList.add(new SpaceFreighter(640, 200, 270, f));
			spaceList.add( new SpaceFreighter(960, 100, 270, f));
			spaceList.add(new SpaceFreighter(1280, 200, 270, f));
			spaceList.add(new SpaceFreighter(1600, 250, 270, f));

			break;
		case 6:
			spaceList.add(new EnemySpaceShip(960, 100, 270, f, 10));
			break;
		case 7:
			spaceList.add(new EnemySpaceShip(720, 200, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1200, 200, 270, f, 10));
			break;
		case 8:
			spaceList.add(new EnemySpaceShip(320, 200,  270,f, 10));
			spaceList.add(new EnemySpaceShip(960, 100, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1600, 200, 270, f, 10));
			break;
		case 9:

			spaceList.add(new EnemySpaceShip(320, 100,  270, f, 10));
			spaceList.add(new EnemySpaceShip(640, 200, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1280, 200, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1600, 100, 270,  f, 10));
			break;
		case 10:
			spaceList.add(new EnemySpaceShip(320, 250, 270, f, 10));
			spaceList.add(new EnemySpaceShip(640, 200, 270, f, 10));
			spaceList.add( new EnemySpaceShip(960, 100, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1280, 200, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1600, 250, 270, f, 10));

		case 11:
			spaceList.add(new EnemySpaceShip(320, 250, 270, f, 10));
			spaceList.add(new EnemySpaceShip(640, 200, 270, f, 10));
			spaceList.add( new EnemySpaceShip(960, 100, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1280, 200, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1600, 250, 270, f, 10));
			spaceList.add(new EnemySpaceShip(320, 800, 90, f, 10));
			spaceList.add(new EnemySpaceShip(1600, 800, 90, f, 10));

		case 12:
			spaceList.add(new EnemySpaceShip(320, 250, 270, f, 10));
			spaceList.add(new EnemySpaceShip(640, 200, 270, f, 10));
			spaceList.add( new EnemySpaceShip(960, 100, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1280, 200, 270, f, 10));
			spaceList.add(new EnemySpaceShip(1600, 250, 270, f, 10));
			spaceList.add(new EnemySpaceShip(320, 800, 90, f, 10));
			spaceList.add(new EnemySpaceShip(640, 800, 90, f, 10));
			spaceList.add(new EnemySpaceShip(1280, 800, 90, f, 10));
			spaceList.add(new EnemySpaceShip(1600, 800, 90, f, 10)); 
			break;
		case 13:
			spaceList.add(new EnemySpaceShip(320, 250, 270, f, 8));
			spaceList.add(new EnemySpaceShip(640, 200, 270, f, 8));
			spaceList.add( new EnemySpaceShip(960, 100, 270, f, 8));
			spaceList.add(new EnemySpaceShip(1280, 200, 270, f, 8));
			spaceList.add(new EnemySpaceShip(1600, 250, 270, f, 8));
			spaceList.add(new EnemySpaceShip(320, 800, 90, f, 8));
			spaceList.add(new EnemySpaceShip(640, 800, 90, f, 8));
			spaceList.add(new EnemySpaceShip(1280, 800, 90, f, 8));
			spaceList.add(new EnemySpaceShip(1600, 800, 90, f, 8)); 
			break;
		case 14:
			spaceList.add(new EnemySpaceShip(960, 250, 270, f, 5));
			spaceList.add(new EnemySpaceShip(500, 800, 135, f, 5));
			spaceList.add(new EnemySpaceShip(1420, 800, 225, f, 5));

			break;

		}
		this.start();
	}

	public void start() {
		setFocusable(true);
		this.addKeyListener(this);

		Thread thread = new Thread(this);
		thread.start();
	}

	//paintComponent method paints the Space Background and objects
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Color backgroundcolor = new Color(15, 15, 15);
		this.setBackground(backgroundcolor);
		int xtemp, ytemp, sizetemp;

		//Determines the color and Displays each SpaceObject from spaceList    
		for (int x = 0; x < (spaceList.size()); x++) {
			if (spaceList.get(x) instanceof Shot) {
				g.setColor(Color.RED);
			}
			if (spaceList.get(x) instanceof UserSpaceShip) {
				g.setColor(new Color(160, 160, 160));
			}
			if (spaceList.get(x) instanceof EnemySpaceShip) {
				g.setColor(new Color(0, 100, 0));
			}
			if (spaceList.get(x) instanceof SpaceExplosion) {
				g.setColor(new Color(255, 255, 255));
			}
			spaceList.get(x).turnPolygon();
			spaceList.get(x).setPolygon();
			g2d.fillPolygon(spaceList.get(x).getPolygon());
		}
	}

	//Checks each SpaceObjects position in spaceList to check for collisions between SpaceObjects on the Space class Object when the game is running
	@Override
	public void run() {
		// will keep track of all the different spaceObjects on th Space class Object at one instant
		int uShipCount, eShipCount, shotCount, explosionCount;
		while (true) {
			uShipCount = 0;
			eShipCount = 0;
			shotCount = 0;
			explosionCount = 0;
			for (int x = 0; x < spaceList.size(); x++) {
				if (spaceList.get(x) instanceof Shot) {
					shotCount++;
				}
				if (spaceList.get(x) instanceof UserSpaceShip) {
					uShipCount++;
				}
				if (spaceList.get(x) instanceof SpaceExplosion) {
					explosionCount++;
				}
				if (spaceList.get(x) instanceof EnemySpaceShip) {
					((EnemySpaceShip) spaceList.get(x)).setX(spaceList.get(0).getxPosition());
					((EnemySpaceShip) spaceList.get(x)).setY(spaceList.get(0).getyPosition());
					eShipCount++;
				}
				spaceList.get(x).actions();
			}
			CheckPositions();

			//determines if game is over if user or enemy shipcount is 0
			if ((uShipCount == 0  || eShipCount == 0)) {// && explosionCount == 0) {
				break;
			}
			repaint();
			pause();
		}
		if (uShipCount == 0 ) {//&& explosionCount == 0) {
			JOptionPane.showMessageDialog(null, "You Lose", "Game Results", JOptionPane.INFORMATION_MESSAGE);
			((JFrame) getRootPane().getParent()).dispose();
		} else if (eShipCount == 0) {// && explosionCount == 0) {
			JOptionPane.showMessageDialog(null, "You Win", "Space Battles Game Results", JOptionPane.INFORMATION_MESSAGE);
			((JFrame) getRootPane().getParent()).dispose();
		}
	}
	// does a number of different checks to determine if any spaceObjects should be removed from the Space class Object
	public void CheckPositions() {
		int start = 0;
		boolean[] isSpaceList = new boolean[spaceList.size()+1];
		for(boolean is: isSpaceList){
			is = false;
		}
		double x, y, isize, jsize, size, distance;
		for (int i = start; i < spaceList.size() - 1; i++) {
			for (int j = i + 1; j < spaceList.size(); j++) {
				x = ((spaceList.get(i).getxPosition()) - (spaceList.get(j).getxPosition()));
				y = ((spaceList.get(i).getyPosition()) - (spaceList.get(j).getyPosition()));
				distance = (x*x + y*y);
				isize = spaceList.get(i).getSize();
				jsize = spaceList.get(j).getSize();
				//size = Math.sqrt(Math.pow(isize, 2) + Math.pow(jsize, 2));
				// if(((isize+jsize)*(isize+jsize)) > distance){
				if (testIntersection(spaceList.get(i).getPolygonFinal(), spaceList.get(j).getPolygonFinal())) {
					isSpaceList[i] = true;
					isSpaceList[j] = true;                    
					//}
			}
			}
		}
		for (int i = 0; i < spaceList.size(); i++) {
			if (spaceList.get(i) instanceof Shot && (spaceList.get(i).getxPosition() < 50 || spaceList.get(i).getxPosition() > 1850 || spaceList.get(i).getyPosition() < 50 || spaceList.get(i).getyPosition() > 1000)) {
				isSpaceList[i] = true;
			}
		}
		for(int i = isSpaceList.length-1; i >= 0; i--){
			if(isSpaceList[i] == true){
				spaceList.get(i).hitSpaceObject(spaceList.get(i));
			}
		}
	}
	int keyCode;
	int shotPause = 0;

	//will handle key presses that move the users space ship movemenst during the game
	@Override
	public void keyPressed(KeyEvent e) {
		keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			// handle up                     
			userShip.onForwardForce();
			break;
		case KeyEvent.VK_DOWN:
			// handle down 
			userShip.onBackwardForce();
			break;
		case KeyEvent.VK_LEFT:
			// handle left
			userShip.onLeftTurn();
			break;
		case KeyEvent.VK_RIGHT:
			// handle right
			userShip.onRightTurn();
			break;
		case KeyEvent.VK_SPACE:
			if (shotPause == 0) {
				userShip.fireShot();
				shotPause = 1;
			}
			break;
		}
	}
	//will turn off any actions that resulted of the key pressed method
	@Override
	public void keyReleased(KeyEvent e) {
		keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			// handle up                     
			userShip.offForwardForce();
			break;
		case KeyEvent.VK_DOWN:
			// handle down 
			userShip.offBackwardForce();
			break;
		case KeyEvent.VK_LEFT:
			// handle left
			userShip.offLeftTurn();
			break;
		case KeyEvent.VK_RIGHT:
			// handle right
			userShip.offRightTurn();
			break;
		case KeyEvent.VK_SPACE:
			shotPause = 0;
			break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		//Space class needs to overide this method
	}
	// occurs every instant to time the game right
	public void pause() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException err) {
			err.printStackTrace();
		}
	}
	//Called when the Space class Object is running it's checkPositions method
	public static boolean testIntersection(Shape shapeA, Shape shapeB) {
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
		return !areaA.isEmpty();
	}
	// will take 2 SpaceObjects and determine if their polygon shapes X and Y Positions are touching

	public static void addSpaceObject(SpaceObject spobj) {
		if (spaceList.add(spobj)) {
			System.out.println("foo");
		}
	}
	// method will add a SpaceObject to the Space class Object SpaceObject ArrayList
}
