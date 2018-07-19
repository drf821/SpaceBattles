package GUIComponents;

// File name: SpaceBackground

// Written by: Daniel Faubel
 
// Description: is the frame all SpaceObjects are placed on
//              
// Challenges: 
//
// Time Spent: 15 min

// Revision History:
// Date: 11/22/16           15min	By: Daniel Faubel     Action: Created The GUI Interface for StartMenu
// Date: 12/1/16            10min       By: Daniel Faubel     Action: added SpaceBackground constructor with a title bar "Space Battles"
// ---------------------------------------------------
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.util.concurrent.TimeUnit;
public class SpaceBackground extends JFrame {
    
    // Creates a SpaceBackground and adds a Space variable to it
    public SpaceBackground(){
        super("Space Battles");
    }
}