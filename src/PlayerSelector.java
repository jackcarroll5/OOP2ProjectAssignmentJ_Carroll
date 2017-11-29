/*This class will establish the basis for picking a particular player signed up to the game.
It is useful for picking two players for a multiplayer game.*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


//JB - removed all references to the interfaces PercentWinsAndLosses and PercentWins as their functionality is
//contained within Person class
//Removed all methods that were being overridden in these interfaces
//added getters and setters to deal with keeping track of the indices of the first and second players in the combo-box
//so they can be accessed elsewhere in the app and means you can update wins/losses/draws for a player and have that
//render in the "new" combo-box (I'm really only hiding it and making it visible again)

public class PlayerSelector extends JFrame implements ActionListener /*,PercentWinsAndLosses,PercentWins*/ {
   JComboBox userbox,userbox2;
  static ArrayList <Person> players;
  private int numPlayerSelected = 0;
  private int indexFirstPlayer, indexSecondPlayer;

 public PlayerSelector()
 {
     setIconImage(new ImageIcon("src\\images\\XO Icon.PNG").getImage());

     setSize(400,150);
     setTitle("Select Player");
     setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
     setLayout(new FlowLayout());

     players = MainGameMenu.players; //Array for the users to be shown in the drop down menu

     userbox = new JComboBox(); //Create combo box to display the players in the drop down menu. Represents Player 1 Selection
     //userbox2 = new JComboBox();//Represents Player 2 Selection

     /*User Items are added to the combo box using the enhanced for loop*/


     //Adding dummy players to show off the instance of players
     Person p1 = new Person("John",0,0,0);
     Person p2 = new Person("Anna",0,0,0);
     Person p3 = new Person("Amy",0,0,0);
     Person p4 = new Person("Max",0,0,0);

     players.add(p1);
     players.add(p2);
     players.add(p3);
     players.add(p4);


     //Enhanced for loop to add the user array to the combobox
     for (Person p : players)
     {
         userbox.addItem(p);
     }

     /*for (Person p : players)
     {
         userbox2.addItem(p);
     }*/

     userbox.setVisible(true);//Allowcombo box to appear.
     //userbox2.setVisible(true);

     userbox.setSelectedIndex(0); //Presets first item of the first user added to the program
     //userbox2.setSelectedIndex(1);

     userbox.getSelectedIndex();//Gets first item of the first user added to the program
     //userbox2.getSelectedIndex();

     userbox.addActionListener(this);//Adds action listener to userbox when a player is selected
     //userbox2.addActionListener(this);

     add(userbox);//Add both combobox to the JFrame
     //add(userbox2);

     //userbox2.setLocation(300,300);

     addWindowListener(new WindowAdapter() {
         @Override
         public void windowIconified (WindowEvent e){
             JOptionPane.showMessageDialog(null, "Minimizing the window", "Minimizing", JOptionPane.INFORMATION_MESSAGE);
             setExtendedState(Frame.ICONIFIED);
         }
     });

     addWindowListener(new WindowAdapter() {
         @Override
         public void windowDeiconified(WindowEvent e) {
             JOptionPane.showMessageDialog(null, "Restoring the window", "Restoration", JOptionPane.INFORMATION_MESSAGE);
             setExtendedState(Frame.NORMAL);
         }
     });
 }//End of constructor



    public static void main(String[] args) {
        PlayerSelector app = new PlayerSelector();
        app.setVisible(true);
    }//End of main method


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




    /*Allows the user to retrieve the selected player from the combo box to be used in the ButtonPresserXO Class*/
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
       //userbox.setSelectedItem(players);
       //userbox.getSelectedItem();

       //userbox.getSelectedIndex();


        /*To select player 1 and add the number of players selected for a 2 player game.*/
        if(numPlayerSelected == 0)
        {
           indexFirstPlayer = userbox.getSelectedIndex();
            JOptionPane.showMessageDialog(null, "You have selected \n" +  userbox.getSelectedItem().toString() + " as Player 1","Player 1 Selection",
                    JOptionPane.INFORMATION_MESSAGE);
            numPlayerSelected++;
        }

        /*Validate player 1 already selected if same name chosen again*/
         else
             if (userbox.getSelectedIndex() == indexFirstPlayer){
                 JOptionPane.showMessageDialog(null, "You have already selected \n" +  userbox.getSelectedItem().toString() + " as Player 1","Same Player Selection",
                         JOptionPane.INFORMATION_MESSAGE);
        }

        /*To select player 2 for a 2 player game.*/
        else{
                 JOptionPane.showMessageDialog(null, "You have selected \n" +  userbox.getSelectedItem().toString() + " as Player 2","Player 2 Selection",
                         JOptionPane.INFORMATION_MESSAGE);
                 numPlayerSelected++;
                indexSecondPlayer = userbox.getSelectedIndex();
             }

             /*To vanish the combobox and frame when all two players are selected and the number of players reset to zero
             * for another game.*/
             if(numPlayerSelected == 2)
             {
                 dispose();
                 numPlayerSelected = 0;
             }



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

      // userbox2.setSelectedItem(players);
       //userbox2.getSelectedItem();
       //userbox2.getSelectedIndex();


       // JOptionPane.showMessageDialog(null, "You have selected \n" +  userbox2.getSelectedItem().toString() + " as Player 2","Player 2 Selection",
                //JOptionPane.INFORMATION_MESSAGE);
       //dispose(); //The combo box disappears when the user presses OK after seeing the name of Player 2.
    }

  /*  @Override
    public void winsPercentage(float percent) {
        Person.setWins(Person.getWins() / totalGames() * 100);
    }


    @Override
    public float winsPercent(float percent) {
        try {
            Person.setWins((Person.getWins() / (Person.getWins() + Person.getLoss() + Person.getDraws())) * 100);
        }
        catch (ArithmeticException e)
        {
           JOptionPane.showMessageDialog(null,"Could not calculate wins percentage","No Calculation",
                   JOptionPane.ERROR_MESSAGE);
        }
        return percent;
    }

    @Override
    public void updateVictories() {
        Person.setWins( Person.getWins() + 1);
    }

    @Override
    public void updateLosses() {
        Person.setLoss(Person.getLoss() + 1);
    }

    @Override
    public void updateDraws() {
        Person.setDraws(Person.getDraws() + 1);
    }

    @Override
    public int totalGames() {
        return Person.getWins() + Person.getLoss() + Person.getDraws();
    }
*/


  //Sets up the first player listed as an example before a game
  public void setIndexOfFirstPlayer(int index)
  {
     indexFirstPlayer = index;
  }

    //Gets the first player listed as an example before a game
    public int getIndexFirstPlayer()
    {
        return indexFirstPlayer;
    }

    //Sets the second player listed as an example before a game
    public void setIndexSecondPlayer(int index)
    {
        indexSecondPlayer = index;
    }

    //Gets the second player listed as an example before a game
    public int getIndexSecondPlayer()
    {
        return indexSecondPlayer;
    }
}

