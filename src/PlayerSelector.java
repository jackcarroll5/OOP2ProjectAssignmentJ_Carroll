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
   JButton ok;

 public PlayerSelector()
 {
     setSize(400,200);
     setTitle("Select Player");
     setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
     setLayout(new FlowLayout());

     players = MainGameMenu.players;

     userbox = new JComboBox();

     for (Person p : players)
     {
         userbox.addItem(p);
     }


     userbox.setVisible(true);
     {
         userbox.setSelectedIndex(1);
     }
     userbox.addActionListener(this);
     add(userbox);


     ok = new JButton("Select");
     ok.setPreferredSize(new Dimension(300,100));
     add(ok);
     ok.addActionListener(this);

 }

    public static void main(String[] args) {
        PlayerSelector app = new PlayerSelector();
        app.setVisible(true);
    }





    /*Intended to select player and save its details while the game is played
    * Player 2 should then be selected*/
    @Override
    public void actionPerformed(ActionEvent e) {
       userbox.getSelectedItem();

    };

}

