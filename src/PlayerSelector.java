/*This class will establish the basis for picking a particular player signed up to the game.
It is useful for picking two players for a multiplayer game.*/


import javax.swing.*;
import java.awt.Event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PlayerSelector extends JFrame implements ActionListener {
   JComboBox userbox;
   ArrayList <Person> players;

 public PlayerSelector()
 {
     setSize(400,200);
     setTitle("Select Player ");
     setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
     setLayout(new FlowLayout());

     players = MainGameMenu.players; //Array for the users to be shown in the drop down menu

     userbox = new JComboBox(); //Create combo box to display the players in the drop down menu.

     /*User Items are added to the combo box using the enhanced for loop*/
     for (Person p : players)
     {
         userbox.addItem(p);
     }


     userbox.setVisible(true);
     {
         userbox.setSelectedIndex(1); //Presets first item of the first user added to the program
     }
     userbox.addActionListener(this);
     add(userbox);

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
       setVisible(false);
    }

}

