/*This class will establish the basis for picking a particular player signed up to the game.
It is useful for picking two players for a multiplayer game.*/


import javax.swing.*;
import java.awt.Event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PlayerSelector extends JFrame implements ActionListener,PercentWinsAndLosses,PercentWins {
   JComboBox userbox,userbox2;
  static ArrayList <Person> players;

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
     userbox2.setSelectedIndex(1);

     userbox.addActionListener(this);
     userbox2.addActionListener(this);

     add(userbox);
     add(userbox2); //Adding both combo boxes to the JFrame

     userbox2.setLocation(300,300);

 }

    public static void main(String[] args) {
        PlayerSelector app = new PlayerSelector();
        app.setVisible(true);
    }


    /*Instances to set a combo box from another class to allow the
    * userboxes to reach the ButtonPresserXO Class for the implementation
    * of updating victories*/
    /**Reference
     * Title: Setting combobox from another class
     * Author: Anonymous
     * Site Owner/sponsor: stackoverflow.com
     * Date: 2015
     * Code Version: Edited Nov 19 '17 at 15:27
     * Availability: https://stackoverflow.com/questions/34802809/setting-combobox-from-another-class
     * (Accessed 19 November 2017)
     * Modified: Change the userbox JComboBox class to a suitable name for my
     * combo box class so the ButtonPresserXO class can gain access to the selected player
     * from the combo box and display its details at the end of the game to
     * show the updating of wins and losses in action
     */
    public JComboBox getUserbox() {
        return userbox;
    }

    public JComboBox getUserbox2() {
        return userbox2;
    }

    /*Intended to select player and save its details while the game is played
            * Player 2 should then be selected
            * Allows the selection box to disappear once the user is selected
            * Outputs the names of the players participating in the game*/
    @Override
    public void actionPerformed(ActionEvent e) {
        /*Select the chosen item from the combo box and display the player's name and wins and losses using an output.*/
       userbox.setSelectedItem(players);
      JOptionPane.showMessageDialog(null, "You have selected \n" +  userbox.getSelectedItem().toString() + " as Player 1","Player 1 Selection",
              JOptionPane.INFORMATION_MESSAGE);

        /**Reference
         * Title: Preferred way of getting the selected item of a JComboBox
         * Author: Anonymous
         * Site Owner/sponsor: stackoverflow.com
         * Date: 2011
         * Code Version: Edited Nov 17 '17 at 18:25
         * Availability: https://stackoverflow.com/questions/4962416/preferred-way-of-getting-the-selected-item-of-a-jcombobox
         * (Accessed 17 November 2017)
         * Modified: Modifying code based on the selected item for the JComboBox
         * where its text is got from the combo box. Planning to output the names
         * of Players 1 and 2 separately using Message Dialogs
         */

       userbox2.setSelectedItem(players);
        JOptionPane.showMessageDialog(null, "You have selected \n" +  userbox2.getSelectedItem().toString() + " as Player 2","Player 2 Selection",
                JOptionPane.INFORMATION_MESSAGE);
       dispose(); //The combo box disappears when the user presses OK after seeing the name of Player 2.
    }

    @Override
    public void winsPercentage(float percent) {
        Person.setWins(Person.getWins() + Person.getLoss()/ totalGames() * 100);
    }

    @Override
    public int winsPercentage(int percentWins) {
        Person.setWins(Person.getWins() / totalGames() * 100);
        return percentWins;
    }

    @Override
    public int updateVictories() {
        return Person.getWins() + 1;
    }

    @Override
    public int updateLosses() {
        return Person.getLoss() + 1;
    }

    @Override
    public int totalGames() {
        return Person.getWins() + Person.getLoss();
    }
}

