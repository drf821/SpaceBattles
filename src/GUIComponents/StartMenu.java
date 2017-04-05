package GUIComponents;

// File name: StartMenu

// Written by: Daniel Faubel
 
// Description: Will show a StartMenu where the user can select the level and difficulty then start the game. Will also have an exit button
//              to close the page, and a Rules button to create a messagebox with the games rules and instructions.                
//              
// Challenges: 
//
// Time Spent: 3 

// Revision History:
// Date: 11/17/16           30min	By: Daniel Faubel     Action: Created The GUI Interface for StartMenu
// Date: 12/1/16            30min       By: Daniel Faubel     Action: Setup The ButtonHandler to perform action events for each of the 3
//                                                            buttons, and added 3 different methods to be used if the connected button
//                                                            is selected. I used methods because they may be called at multiple locations 
// Date 12/5/16             60min       By: Daniel Faubel     Action: add a listener to handle each button click and call its mehod
// Date 12/6/16                         By: Daniel Faubel     Action: 
// ---------------------------------------------------

import GUIComponents.SpaceBackground;
import GUIComponents.Space;
import com.sun.prism.paint.Color;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class StartMenu extends JFrame {
    private  String[] levels = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
    private  String[]  difficulties = {"Easy", "Medium", "Hard", "Very Hard", "Suicidal"};
    
    public static final int SCREENX = 1920;
    public static final int SCREENY = 1080;
    private Scanner input;
   
    private Space Screen;
   
    private final GridBagLayout layout;
    private final GridBagConstraints constraints;

    private JLabel              levellbl, difficultylbl;
    private JButton             instructionbtn, startbtn, exitbtn;
    private JComboBox<String>   levelcmbx;
    private       JComboBox<String>   difficultycmbx;
    private final JPanel        p1, p2, p3;
    private       Color               c ;
    private final ButtonHandler btnhandler;
   
    public StartMenu(){
        super("Space Battles Start Menu");
        
        layout = new GridBagLayout();
//        setLayout(layout);
        constraints = new GridBagConstraints();
        
        c              = new Color(212, 212, 212, 212);
        levellbl       = new JLabel("Level: ");
        difficultylbl  = new JLabel("Difficulty");
        instructionbtn = new JButton("Instructions");
        startbtn       = new JButton("Start");
        exitbtn        = new JButton("Exit");
        btnhandler     = new ButtonHandler();
        
        startbtn.addActionListener(btnhandler);
        exitbtn.addActionListener(btnhandler);
        instructionbtn.addActionListener(btnhandler);
        
        
        levelcmbx = new JComboBox<String> (levels);
        difficultycmbx = new JComboBox<String> (difficulties);
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        setLayout(new BorderLayout(150, 150));
        p2.setLayout(new GridLayout(1, 4));
        p3.setLayout(new BorderLayout(50,50));
        
        p2.add(levellbl);
        p2.add(levelcmbx);
        p2.add(difficultylbl);
        p2.add(difficultycmbx);
        
        //p3.add(instructionbtn, BorderLayout.WEST);
        p3.add(startbtn, BorderLayout.WEST);
        p3.add(exitbtn, BorderLayout.EAST);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        playMusic();
    }   
    public void addComponent(Component component,
        int row, int column, int width, int height)
        {
            constraints.fill = GridBagConstraints.BOTH;
            constraints.gridx = column;
            constraints.gridy = column;
            constraints.gridwidth = column;
            constraints.gridheight = column;
            layout.setConstraints(component, constraints);
            add(component);

        }
        public static void playMusic(){
            //Will play background music
        }
   //ButtonHandler is going to be used by StartMenu to manage  it's three buttons
    private class ButtonHandler implements ActionListener
    {
        //Will respond to an event of the button being clicked
        @Override            
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == startbtn)
                startGame();
                // will create a spacebackground and a space object where the game can be played
            else if(event.getSource() == exitbtn )
                 exitStartMenu();
                 // will exit the GUI and end the game
            else if(event.getSource() == instructionbtn)
                showInstructions();
                //Will create a popup GUI with instructions for how to play Space Battles
        }
    } 
   
    // called in StartMenu constructor
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("Courier", Font.BOLD+Font.ITALIC, 100));
        g.drawString("Space Battles", 75, 150);
    }
    // paints Space Battles on the middle of a JComponent of the StartMenu
    
    // called in ButtonHandler class  when start button is pressed
    public void startGame(){
        int difficulty = difficultycmbx.getSelectedIndex();
        int level = levelcmbx.getSelectedIndex();
        SpaceBackground spaceMap = new SpaceBackground();
        Screen = new Space(level, difficulty);
        spaceMap.setSize(SCREENX, SCREENY);
        spaceMap.setLocationRelativeTo(null);
        spaceMap.setVisible(true);
        spaceMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        spaceMap.add(Screen);
    }
    // creates a SpaceBackground with a Space class Object with the paremeters difficulty, and level
    
    //called in ButtonHandler class when instructionsbtn is pressed
    public  void showInstructions()
    {
        Path myPath = Paths.get("SpaceBattlesInstructions.txt");
    }
    //
    
    // called in ButtonHandler when the exitbtn is pressed
    public void exitStartMenu()
    {
        System.exit(0);
    }
    // exits the game
}