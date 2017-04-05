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
 //   private AudioPlayer backgroundmusic;
    static private MusicPlayer music = new MusicPlayer();
    public static void main(String[] args) {
        music.play();
//        backgroundmusic = new AudioPlayer();
        //Initializes Startmenu
        StartMenu menu = new StartMenu();
        menu.setSize(800, 600);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}