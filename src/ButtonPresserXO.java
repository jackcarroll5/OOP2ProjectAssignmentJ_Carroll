import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.awt.Event.*;

/**
 * @author Jack Carroll
 * version 1.0*/

/**An important class for determining the winner of the game and to display the percentage of games won and total games played at
 * the end of the game. Also updates the wins and losses for both players.*/

/**Reference
 * Title: Java Swing #2 "Grid Layout & Action Listener" Tutorial
 * Author: Arend Peter C(Arend Peter Teaches = Channel)
 * Site Owner/sponsor: youtube.com
 * Date: 2013
 * Code Version: Edited Nov 08 '17 at 13.30
 * Availability: https://www.youtube.com/watch?v=Db3cC5iPrOM
 * (Accessed 08 November 2017)
 * Modified: Modifying code based on video to form 9 square button layout
 * for Tic Tac Toe using my own drawing of X and O from Microsoft Paint.
 * Using the symbols for the game as an int. Making the images and the symbol int private
 */

public class ButtonPresserXO extends JButton implements ActionListener{

 private ImageIcon OIcon,XIcon;
    Person user;
    int repeat = 100;
    float winsPercentage;
    PlayerSelector player1,player2;
   static ArrayList <Person> people;
   private static int switchTurn = 0;//Represents the player's turns
    //Represents cases for the numerous symbols of nothing,X and O.

    public ButtonPresserXO()
    {

        /*Make sure that image is in right folder and file pathname is correct. If image can't show up
        * type in correct file that image is found for O Image Paint.PNG and X Image Paint.PNG */
        //Getting images for my original X and O Drawings

        //OIcon = new ImageIcon("OOP2ProjectFolder\\O Image Paint.PNG");
        // XIcon = new ImageIcon("OOP2ProjectFolder\\X Image Paint.PNG");
      // OIcon = new ImageIcon("G:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\O Image Paint.PNG");
      // XIcon = new ImageIcon("G:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\X Image Paint.PNG");
        //OIcon = new ImageIcon("I:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\O Image Paint.PNG");
        //XIcon = new ImageIcon("I:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\X Image Paint.PNG");
        //OIcon = new ImageIcon("C:\\Users\\ \\Desktop\\OOP2ProjectFolder\\O Image Paint.PNG");
        //XIcon = new ImageIcon("C:\\Users\\ \\Desktop\\OOP2ProjectFolder\\X Image Paint.PNG");
       // XIcon = new ImageIcon("C:\\Users\\ \\Pictures\\X Image Paint.PNG");
        //OIcon = new ImageIcon("C:\\Users\\ \\Pictures\\O Image Paint.PNG");

        OIcon = new ImageIcon("src\\images\\O Image Paint.PNG");
        XIcon = new ImageIcon("src\\images\\X Image Paint.PNG");


        this.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        /*Add X and O symbol when button is pressed.
        * Cases apply for the different symbols*/
        switchTurn++;
        //symbol %= 3;




        //Doesn't work as cases are set for three symbols including a
        //null symbol
        /*switch (symbol)
        {
            case 0:
              setIcon(null);
                break;
            case 1:
                setIcon(XIcon);
                break;
            case 2:
               setIcon(OIcon);
        }//End of switch statement*/





        /*Switching turns between players 1 and 2*/
        /*if (symbol == 1 || symbol == 3 || symbol == 5 || symbol == 7 || symbol == 9) {
            setIcon(XIcon);
        } else if (symbol == 2 || symbol == 4 || symbol == 6 || symbol == 8) {
            setIcon(OIcon);
        }*/

        /*Easier code to switch turns between Players 1 and 2 to alter the shapes on every click*/
        /*if (symbol == 1 || symbol == 3 || symbol == 5 || symbol == 7 || symbol == 9) {
            setIcon(XIcon);
        } else
            setIcon(OIcon);*/



        /**Set turns for players 1 and 2 in the game by switching turns
         * on every second go.
         *Setting X and O Icons on every click to change the two symbols that are
         * required for the game.
         * The symbols vary when one player presses a button on one of the nine squares.
         * After that, the other player can choose one of the eight remaining squares.*/


            if (switchTurn % 2 == 1) {
                setIcon(XIcon);
                JOptionPane.showMessageDialog(null, "Player 2's Turn", "P2 Turn",
                        JOptionPane.INFORMATION_MESSAGE);

            }
            if (switchTurn % 2 == 0) {
                setIcon(OIcon);
                JOptionPane.showMessageDialog(null, "Player 1's Turn", "P1 Turn",
                        JOptionPane.INFORMATION_MESSAGE);

            }


      /*If clause for winning the game if the player gets three xs or os in a diagonal,vertical or horizontal
       * row
       * The first player can end the game as early as five moves*/
          if(switchTurn == 5)
       {
       repeat = JOptionPane.showConfirmDialog(null,"Well Done! You have won this round. Pat on the back! "+
               "\nDo you want to play again","You Win!",JOptionPane.YES_NO_OPTION);

                if(repeat == JOptionPane.YES_OPTION) {


                    /*Re-introduce the array so the selected players from the array
                    can be shown at the very end of the game*/
                    people = PlayerSelector.players;

                    player1 = new PlayerSelector();
                    player1.getUserbox().setSelectedItem(people);//Based on the getUserbox() method introduced in PlayerSelector class
                    player1.getUserbox().getSelectedItem();//Gets selected player for Player 1 from the PlayerSelector class.

                    player2 = new PlayerSelector();
                    player2.getUserbox2().setSelectedItem(people);
                    player2.getUserbox2().getSelectedItem();


                    /*JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                            "\nTotal Games Played: " + user.totalGames());*/

                    /**Should display the winning players's victory percentage and the total number of games played.*/
                    JOptionPane.showMessageDialog(null,"Wins percentage: " +  player1.winsPercent(winsPercentage) + "%" +
                            "\nTotal Games Played: " + player1.totalGames() + " games");

                    player1.updateVictories();
                    player2.updateLosses();

        TicTacToeGame tttg = new TicTacToeGame(); /*The game should reset with the clearance of the images from the nine buttons
        and the resetting of the Tic Tac toe layout by restarting the game again and allow a different player selection*/
        tttg.dispose();
        //user.updateVictories();

                    /**Update the victory for the player and the
                     * loss for the other player*/

      }
      else {
                    people = PlayerSelector.players;

                    player1 = new PlayerSelector();
                    player1.getUserbox().setSelectedItem(people);
                    player1.getUserbox().getSelectedItem();

                    // player1.userbox.setSelectedItem(user);
                   // player2.userbox2.setSelectedItem(user);

                    //player1.setPlayers(people);
                    //player1.getPlayers();

                    player2 = new PlayerSelector();
                    player2.getUserbox2().setSelectedItem(people);
                    player2.getUserbox2().getSelectedItem();
                    

                   // player1.userbox.setSelectedItem(people);
                    //player2.userbox2.setSelectedItem(people);


                    //player1.winsPercentage(winsPercentage);



                    JOptionPane.showMessageDialog(null,"Wins percentage: " + player1.winsPercent(winsPercentage) + "%" +
                    "\nTotal Games Played: " + player1.totalGames() + " games");



          JOptionPane.showMessageDialog(null,"Returning to the main menu","Main Menu Return",JOptionPane.INFORMATION_MESSAGE);
                   /* JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                            "\nTotal Games Played: " + user.totalGames());*/

                    player1.updateVictories();
                    player2.updateLosses();

                    /*Should enable the game board to close and return to the main menu class where the TicTacToeGame class is disposed
                    * and cleared of all its images and buttons as well as the frame to allow the player to restartt a new game if possible and
                    * add new users or save/load them.*/
          TicTacToeGame tttg = new TicTacToeGame();
            tttg.dispose();
            MainGameMenu mnu = new MainGameMenu();
            mnu.setVisible(true);

         }
       }





       /*If clause for losing the game if the player does not get three xs or os in a diagonal,vertical or horizontal
       * row
       * The other player can win the game as erly as six moves*/
        else if(switchTurn == 6)
        {

        //user.updateLosses();
        repeat = JOptionPane.showConfirmDialog(null,"Hard Luck! You have lost this round. Try again!" +
                "\nDo you want to play again","You lose!",JOptionPane.YES_NO_OPTION);
                 if(repeat == JOptionPane.YES_OPTION) {

                     people = PlayerSelector.players;

                     player1 = new PlayerSelector();
                     player1.getUserbox().setSelectedItem(people);
                     player1.getUserbox().getSelectedItem();

                     player2 = new PlayerSelector();
                     player2.getUserbox2().setSelectedItem(people);
                     player2.getUserbox2().getSelectedItem();

                     //Displays the percentage of wins during a series of games

                     /*JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                             "\nTotal Games Played: " + user.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);*/

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  player1.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + player1.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);

                     player2.updateVictories();
                     player1.updateLosses();

        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.dispose();
      }
      else {
                     people = PlayerSelector.players;

                     player1 = new PlayerSelector();
                     player1.getUserbox().setSelectedItem(people);
                     player1.getUserbox().getSelectedItem();

                     player2 = new PlayerSelector();
                     player2.getUserbox2().setSelectedItem(people);
                     player2.getUserbox2().getSelectedItem();

                     /*JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                             "\nTotal Games Played: " + user.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);*/

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  player1.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + player1.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);

                     player2.updateVictories();
                     player1.updateLosses();


          JOptionPane.showMessageDialog(null,"Returning to the main menu","Main Menu Return",JOptionPane.INFORMATION_MESSAGE);
          TicTacToeGame ticTacToeGame = new TicTacToeGame();
          ticTacToeGame.dispose();
          MainGameMenu mgm = new MainGameMenu();
          mgm.setVisible(true);
      }

    }



       /*If clause for a draw if no player gets three xs or os in a diagonal,vertical or horizontal
       * row and ends up filling all of the squares*/
     else if(switchTurn == 9) {
           repeat = JOptionPane.showConfirmDialog(null,"It's a draw! Great job to both players." +
                "\nDo you want to play again","Draw",JOptionPane.YES_NO_OPTION);
                 if(repeat == JOptionPane.YES_OPTION) {

                     people = PlayerSelector.players;

                     player1 = new PlayerSelector();
                     player1.getUserbox().setSelectedItem(people);
                     player1.getUserbox().getSelectedItem();

                     player2 = new PlayerSelector();
                     player2.getUserbox2().setSelectedItem(people);
                     player2.getUserbox2().getSelectedItem();


                    // player1.userbox.getSelectedItem();
                     //player2.userbox2.getSelectedItem();
                    /* JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                     "\nTotal Games Played: " + user.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);*/

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  player1.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + player1.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);

        TicTacToeGame ttt = new TicTacToeGame();
        ttt.dispose();

      }
      else {

                     people = PlayerSelector.players;

                     player1 = new PlayerSelector();
                     player1.getUserbox().setSelectedItem(people);
                     player1.getUserbox().getSelectedItem();

                     player2 = new PlayerSelector();
                     player2.getUserbox2().setSelectedItem(people);
                     player2.getUserbox2().getSelectedItem();

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  player1.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + player1.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);

                     /*JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                         "\nTotal Games Played: " + user.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);*/

          JOptionPane.showMessageDialog(null,"Returning to the main menu","Main Menu Return",JOptionPane.INFORMATION_MESSAGE);

          TicTacToeGame ttt = new TicTacToeGame();
          ttt.dispose();
          MainGameMenu TicTT = new MainGameMenu();
          TicTT.setVisible(true);

      }

    }
    }

}

