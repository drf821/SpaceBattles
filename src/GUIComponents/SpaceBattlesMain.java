package GUIComponents;

// File name: SpaceBattlesMain

// Written by: Daniel Faubel
 
// Description: Guides the entire program while it runs
//
//              
// Challenges: 
//
// Time Spent: 

// Revision History:
// Date: 11/17/16      		By: Daniel Faubel     Action: Created The GUI Interface for StartMenu
// ---------------------------------------------------
import javax.swing.JFrame;
import Audio.MusicPlayer;
public class SpaceBattlesMain {        

	static private MusicPlayer music = new MusicPlayer();
    public static void main(String[] args) {
        music.play();
        //Initializes Startmenu
        StartMenu menu = new StartMenu();
        menu.setSize(960, 540);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}