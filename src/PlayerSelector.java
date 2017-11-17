/*This class will establish the basis for picking a particular player signed up to the game.
It is useful for picking two players for a multiplayer game.*/


import javax.swing.*;
import java.awt.Event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PlayerSelector extends JFrame implements ActionListener {
   JComboBox userbox,userbox2;
   ArrayList <Person> players;

 public PlayerSelector()
 {
     setIconImage(new ImageIcon("G:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\XO Icon.PNG").getImage());
     //setIconImage(new ImageIcon("I:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\XO Icon.PNG").getImage());
     setSize(400,150);
     setTitle("Select Player ");
     setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
     setLayout(new FlowLayout());

     players = MainGameMenu.players; //Array for the users to be shown in the drop down menu

     userbox = new JComboBox(); //Create combo box to display the players in the drop down menu. Represents Player 1 Selection
     userbox2 = new JComboBox();//Represents Player 2 Selection

     /*User Items are added to the combo box using the enhanced for loop*/
     for (Person p : players)
     {
         userbox.addItem(p);
     }

     for (Person p : players)
     {
         userbox2.addItem(p);
     }

     userbox.setVisible(true);
     userbox2.setVisible(true);

     userbox.setSelectedIndex(1); //Presets first item of the first user added to the program
     userbox2.setSelectedIndex(2);

     userbox.addActionListener(this);
     userbox2.addActionListener(this);

     add(userbox);
     add(userbox2);

     userbox2.setLocation(300,300);

 }

    public static void main(String[] args) {
        PlayerSelector app = new PlayerSelector();
        app.setVisible(true);
    }




    /*Intended to select player and save its details while the game is played
    * Player 2 should then be selected
    * Allows the selection box to disappear once the user is selected*/
    @Override
    public void actionPerformed(ActionEvent e) {
       userbox.setSelectedItem(players);
       userbox.setSelectedItem(players);

    }

}

