import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * @author Jack Carroll
 * version 1.0*/

//JB - removed all references to the interfaces PercentWinsAndLosses and PercentWins as their functionality is
//contained within Person class
//Removed all methods that were being overridden in these interfaces
//added getters and setters to deal with keeping track of the indices of the first and second players in the combo-box
//so they can be accessed elsewhere in the app and means you can update wins/losses/draws for a player and have that
//render in the "new" combo-box (I'm really only hiding it and making it visible again)

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
    //Person user;
    private int repeat = 100;
    //float winsPercentage;
    private PlayerSelector ps;
   static ArrayList <Person> people;
   private static int switchTurn = 0;//Represents the player's turns
    //Represents cases for the numerous symbols of nothing,X and O.

    //ButtonPresserXO[] buttons = new ButtonPresserXO[9];
    private Person firstPlayer, secondPlayer;

    public ButtonPresserXO()
    {

        /*Make sure that image is in right folder and file pathname is correct. If image can't show up
        * type in correct file that image is found for O Image Paint.PNG and X Image Paint.PNG */
        //Getting images for my original X and O Drawings
        OIcon = new ImageIcon("src\\images\\O Image Paint.PNG");
        XIcon = new ImageIcon("src\\images\\X Image Paint.PNG");


        this.addActionListener(this);
    }//End of constructor



    @Override
    public void actionPerformed(ActionEvent e) {

        /*Add X and O symbol when button is pressed.
        * Cases apply for the different symbols*/
        switchTurn++;


        /*Switching turns between players 1 and 2
        * Works as well but modulus method is easier in the game*/
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
          else if (switchTurn % 2 == 0) {
                setIcon(OIcon);
                JOptionPane.showMessageDialog(null, "Player 1's Turn", "P1 Turn",
                        JOptionPane.INFORMATION_MESSAGE);

            }


      /*If clause for winning the game if player 1 gets three xs in a diagonal,vertical or horizontal
       * row
       * The first player can end the game as early as five moves*/
        if(TicTacToeGame.isWin(true))
       {
       repeat = JOptionPane.showConfirmDialog(null,"Well Done! You have won this round. Pat on the back! "+
               "\nDo you want to play again","You Win!",JOptionPane.YES_NO_OPTION);

                if(repeat == JOptionPane.YES_OPTION) {

                    /*Re-introduce the array so the selected players from the array
                    can be shown at the very end of the game*/
                    people = PlayerSelector.players;
                    ps = MainGameMenu.getCurrentPlayerSelector();

                    //ps = new PlayerSelector();

                    //player1 = new PlayerSelector();

                    firstPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexFirstPlayer());
                    secondPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexSecondPlayer());

                    //ps.getUserbox().setSelectedItem(people);//Based on the getUserbox() method introduced in PlayerSelector class
                    //ps.updateVictories();

                    /**Should update the victory for the player on its own rather than the entire
                     * array in the combo box*/

                    firstPlayer.updateWins();
                    secondPlayer.updateLosses();

                    JOptionPane.showMessageDialog(null,"Winner:\n" + firstPlayer,"Winner",
                            JOptionPane.INFORMATION_MESSAGE);//Gets selected player for Player 1 from the PlayerSelector class.


                    //ps = new PlayerSelector();

                    //ps.getUserbox().insertItemAt(firstPlayer,ps.getIndexOfFirstPlayer());
                    //ps.getUserbox().insertItemAt(secondPlayer,ps.getIndexOfSecondPlayer());

                    //MainGameMenu.setCurrentPlayerSelector(ps);
                    //ps.getUserbox2().setSelectedItem(people);

                    //ps.updateLosses();


                    /**Update the victory for the
                     * loss for the other player on its own*/
                    JOptionPane.showMessageDialog(null,"Runner-Up:\n" + secondPlayer,"Runner-Up",
                            JOptionPane.INFORMATION_MESSAGE);//Gets selected player for Player 2 from the PlayerSelector class.


                    /*JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                            "\nTotal Games Played: " + user.totalGames());*/

                    /**Should display the winning players's victory percentage and the total number of games played.*/
                    JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)firstPlayer.getWins() / firstPlayer.totalGames() * 100 /*ps.winsPercent(winsPercentage)*/ + "%" +
                            "\nTotal Games Played: " + firstPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                    JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)secondPlayer.getWins() / secondPlayer.totalGames() * 100 + "%" + /*ps.winsPercent(winsPercentage)*/
                            "\nTotal Games Played: " + secondPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


        //TicTacToeGame tttg = new TicTacToeGame();

        /*The game should reset with the clearance of the images from the nine buttons
        and the resetting of the Tic Tac toe layout by restarting the game again and allow a different player selection
                  tttg.setVisible(false);
                   tttg.dispose();
                    removeAll();
                    tttg.removeAll();
                    tttg.panel.removeAll();*/


                    //Try to form a new game with a brand new frame along with the buttons and images
                  MainGameMenu.getCurrentGame().dispose();
                  MainGameMenu.getCurrentGame().setVisible(false);

                  TicTacToeGame ticTacToeGame = new TicTacToeGame();
                  ticTacToeGame.setVisible(true);
                 MainGameMenu.setCurrentGame(ticTacToeGame);

                 ps.setVisible(true);
                 ps.setIndexOfFirstPlayer(-1);
                 ps.setIndexSecondPlayer(-1);

                      /*Once the game ends, the turns will reset at zero
                    * so the selected new players for the next game
                    * can go ahead with playing the new game.*/
                    switchTurn = 0;


                    /*Attempt to remove the buttons along with the images once the game restarts
                    * Reload the buttons with no images shown on the buttons
                    for (int i = 0; i <= 8; i++)
                    {
                        buttons = TicTacToeGame.getXOButton();
                        buttons[i].setVisible(false);
                        buttons[i] = null;
                    }*/

                    /*Restart the player selection frame to pick new players or choose the same players again*/
                  //PlayerSelector reset1 = new PlayerSelector();
                  //reset1.setVisible(true);

      }
      else {
                   people = PlayerSelector.players;
                    ps = MainGameMenu.getCurrentPlayerSelector();
                   /* ps = ps;
                    ps = new PlayerSelector();
                    ps.getUserbox().setSelectedItem(people);//Based on the getUserbox() method introduced in PlayerSelector class
                    ps.updateWins();*/


                      firstPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexFirstPlayer());
                    secondPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexSecondPlayer());

                     firstPlayer.updateWins();
                    secondPlayer.updateLosses();


                    JOptionPane.showMessageDialog(null,"Winner:\n" + firstPlayer,"Winner",
                            JOptionPane.INFORMATION_MESSAGE);

                    JOptionPane.showMessageDialog(null,"Runner-Up:\n" + secondPlayer,"Runner-Up",
                            JOptionPane.INFORMATION_MESSAGE);


                    JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)firstPlayer.getWins()/firstPlayer.totalGames()*100 + "%" +
                            "\nTotal Games Played: " + firstPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                    JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)secondPlayer.getWins()/secondPlayer.totalGames()*100 + "%" +
                            "\nTotal Games Played: " + secondPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);



          JOptionPane.showMessageDialog(null,"Returning to the main menu","Main Menu Return",JOptionPane.INFORMATION_MESSAGE);


                    /*Should enable the game board to close and return to the main menu class where the TicTacToeGame class is disposed
                    * and cleared of all its images and buttons as well as the frame to allow the player to restartt a new game if possible and
                    * add new users or save/load them.*/
                    MainGameMenu.getCurrentGame().dispose();
                    MainGameMenu.getCurrentGame().setVisible(false);

                    MainGameMenu mnu = new MainGameMenu();
                    mnu.setVisible(true);

                    TicTacToeGame tacToeGame = new TicTacToeGame();
                    tacToeGame.setVisible(false);
                    MainGameMenu.setCurrentGame(tacToeGame);

                    switchTurn = 0;

                }
       }


       /*If clause for winning the game if player 1 gets three xs in a diagonal,vertical or horizontal
       * row
       * The second player can end the game as early as five moves*/
        else if(TicTacToeGame.isWin1(TicTacToeGame.win))
        {

        //user.updateLosses();
        repeat = JOptionPane.showConfirmDialog(null,"Hard Luck! You have lost this round. Try again!" +
                "\nDo you want to play again","You lose!",JOptionPane.YES_NO_OPTION);
                 if(repeat == JOptionPane.YES_OPTION) {

                     people = PlayerSelector.players;
                      ps = MainGameMenu.getCurrentPlayerSelector();

                     firstPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexFirstPlayer());
                     secondPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexSecondPlayer());

                     firstPlayer.updateLosses();
                     secondPlayer.updateWins();


                     JOptionPane.showMessageDialog(null,"Winner:\n" + secondPlayer,"Winner",
                             JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Runner-Up:\n" + firstPlayer,"Runner-Up",
                             JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)firstPlayer.getWins()/firstPlayer.totalGames()*100 + "%" +
                             "\nTotal Games Played: " + firstPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)secondPlayer.getWins()/secondPlayer.totalGames()*100 + "%" +
                             "\nTotal Games Played: " + secondPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                     MainGameMenu.getCurrentGame().dispose();
                     MainGameMenu.getCurrentGame().setVisible(false);

                     TicTacToeGame tacToeGame = new TicTacToeGame();
                     tacToeGame.setVisible(true);
                     MainGameMenu.setCurrentGame(tacToeGame);

                     ps.setVisible(true);
                     ps.setIndexOfFirstPlayer(-1);
                     ps.setIndexSecondPlayer(-1);


                     switchTurn = 0;

                    /* ps = new PlayerSelector();
                     ps.getUserbox().setSelectedItem(people);//Based on the getUserbox() method introduced in PlayerSelector class
                     ps.updateLosses();
                     JOptionPane.showMessageDialog(null,"Winner:\n" + ps.getUserbox2().getSelectedItem().toString(),"Winner",
                             JOptionPane.INFORMATION_MESSAGE);//Gets selected player for Player 1 from the PlayerSelector class.

                     ps = new PlayerSelector();
                     ps.getUserbox2().setSelectedItem(people);
                     ps.updateVictories();
                     JOptionPane.showMessageDialog(null,"Runner-Up:\n" + ps.getUserbox().getSelectedItem().toString(),"Runner-Up",
                             JOptionPane.INFORMATION_MESSAGE);

                     //Displays the percentage of wins during a series of games

                     /*JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                             "\nTotal Games Played: " + user.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);*/

        /*             JOptionPane.showMessageDialog(null,"Wins percentage: " +  ps.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + ps.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  ps.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + ps.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);*/



        /*TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.setVisible(false);
        ticTacToeGame.dispose();

                     TicTacToeGame tacToeGame = new TicTacToeGame();
                     tacToeGame.setVisible(true);*/


                     //PlayerSelector reset3 = new PlayerSelector();
                    // reset3.setVisible(true);
                 }
      else {
                     people = PlayerSelector.players;
                     ps = MainGameMenu.getCurrentPlayerSelector();

                     firstPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexFirstPlayer());
                     secondPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexSecondPlayer());

                     firstPlayer.updateLosses();
                     secondPlayer.updateWins();


                     JOptionPane.showMessageDialog(null,"Winner:\n" + secondPlayer,"Winner",
                             JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Runner-Up:\n" + firstPlayer,"Runner-Up",
                             JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)firstPlayer.getWins() / firstPlayer.totalGames() * 100 /*ps.winsPercent(winsPercentage)*/ + "%" +
                             "\nTotal Games Played: " + firstPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)secondPlayer.getWins() / secondPlayer.totalGames() * 100 + "%" + /*ps.winsPercent(winsPercentage)*/
                             "\nTotal Games Played: " + secondPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                     JOptionPane.showMessageDialog(null,"Returning to the main menu","Main Menu Return",JOptionPane.INFORMATION_MESSAGE);

                     MainGameMenu.getCurrentGame().dispose();
                     MainGameMenu.getCurrentGame().setVisible(false);

                     MainGameMenu mnu = new MainGameMenu();
                     mnu.setVisible(true);

                     TicTacToeGame tacToeGame = new TicTacToeGame();
                     tacToeGame.setVisible(false);
                     MainGameMenu.setCurrentGame(tacToeGame);

                     switchTurn = 0;

    /* people = PlayerSelector.players;

                     ps = new PlayerSelector();
                     ps.getUserbox().setSelectedItem(people);//Based on the getUserbox() method introduced in PlayerSelector class
                     ps.updateLosses();
                     JOptionPane.showMessageDialog(null,"Winner:\n" + ps.getUserbox2().getSelectedItem().toString(),"Winner",
                             JOptionPane.INFORMATION_MESSAGE);//Gets selected player for Player 1 from the PlayerSelector class.

                     ps = new PlayerSelector();
                     ps.getUserbox2().setSelectedItem(people);
                     ps.updateVictories();
                     JOptionPane.showMessageDialog(null,"Runner-Up:\n" + ps.getUserbox().getSelectedItem().toString(),"Runner-Up",
                             JOptionPane.INFORMATION_MESSAGE);

                     /*JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                             "\nTotal Games Played: " + user.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);*/

            /*         JOptionPane.showMessageDialog(null,"Wins percentage: " +  ps.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + ps.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  ps.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + ps.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);
*/
                     //JOptionPane.showMessageDialog(null,"Player 1's score: " + ps.toString());

                     // JOptionPane.showMessageDialog(null,"Player 2's score: " + ps.toString());


          /*TicTacToeGame ticTacToeGame = new TicTacToeGame();
          ticTacToeGame.setVisible(false);
          ticTacToeGame.dispose();

          MainGameMenu mgm = new MainGameMenu();
          mgm.setVisible(true);*/

                 }
        }


       /*If clause for a draw if no player gets three xs or os in a diagonal,vertical or horizontal
       * row and ends up filling all of the 9 squares*/
     else if(!TicTacToeGame.win && switchTurn == 9) {
           repeat = JOptionPane.showConfirmDialog(null,"It's a draw! Great job to both players." +
                "\nDo you want to play again","Draw",JOptionPane.YES_NO_OPTION);
                 if(repeat == JOptionPane.YES_OPTION)  {

                     people = PlayerSelector.players;
                     ps = MainGameMenu.getCurrentPlayerSelector();

                     firstPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexFirstPlayer());
                     secondPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexSecondPlayer());

                     firstPlayer.updateDraws();
                     secondPlayer.updateDraws();


                     JOptionPane.showMessageDialog(null,"It's a tie! Fair play to both players! " + firstPlayer + "\n" + secondPlayer,"Tie",JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)firstPlayer.getWins() / firstPlayer.totalGames() * 100 /*ps.winsPercent(winsPercentage)*/ + "%" +
                             "\nTotal Games Played: " + firstPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)secondPlayer.getWins() / secondPlayer.totalGames() * 100 + "%" + /*ps.winsPercent(winsPercentage)*/
                             "\nTotal Games Played: " + secondPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);

                     MainGameMenu.getCurrentGame().dispose();
                     MainGameMenu.getCurrentGame().setVisible(false);

                     TicTacToeGame tacToeGame = new TicTacToeGame();
                     tacToeGame.setVisible(true);
                     MainGameMenu.setCurrentGame(tacToeGame);

                     ps.setVisible(true);
                     ps.setIndexOfFirstPlayer(-1);
                     ps.setIndexSecondPlayer(-1);

                     switchTurn = 0;
                    /* people = PlayerSelector.players;

                     ps = new PlayerSelector();
                     ps.getUserbox().setSelectedItem(people);//Based on the getUserbox() method introduced in PlayerSelector class
                     ps.updateDraws();
                     JOptionPane.showMessageDialog(null,ps.getUserbox().getSelectedItem().toString());//Gets selected player for Player 1 from the PlayerSelector class.

                     ps = new PlayerSelector();
                     ps.getUserbox2().setSelectedItem(people);
                     ps.updateDraws();
                     JOptionPane.showMessageDialog(null,ps.getUserbox2().getSelectedItem().toString(),"Runner-Up",
                             JOptionPane.INFORMATION_MESSAGE);



                     // ps.userbox.getSelectedItem();
                     //ps.userbox2.getSelectedItem();
                    /* JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                     "\nTotal Games Played: " + user.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);*/

             /*        JOptionPane.showMessageDialog(null,"Wins percentage: " +  ps.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + ps.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  ps.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + ps.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


*/




        /*TicTacToeGame ttt = new TicTacToeGame();
        ttt.setVisible(false);
        ttt.dispose();



                     TicTacToeGame tacToeGame = new TicTacToeGame();
                     tacToeGame.setVisible(true);*/

                     //PlayerSelector reset5 = new PlayerSelector();
                     //reset5.setVisible(true);

                 }
      else {

                     people = PlayerSelector.players;
                     ps = MainGameMenu.getCurrentPlayerSelector();

                     firstPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexFirstPlayer());
                     secondPlayer = (Person)ps.getUserbox().getItemAt(ps.getIndexSecondPlayer());

                     firstPlayer.updateDraws();
                     secondPlayer.updateDraws();

                     JOptionPane.showMessageDialog(null,"It's a tie! Fair play to both players! " + firstPlayer + "\n" + secondPlayer,"Tie",JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)firstPlayer.getWins() / firstPlayer.totalGames() * 100 /*ps.winsPercent(winsPercentage)*/ + "%" +
                             "\nTotal Games Played: " + firstPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  (double)secondPlayer.getWins() / secondPlayer.totalGames() * 100 + "%" + /*ps.winsPercent(winsPercentage)*/
                             "\nTotal Games Played: " + secondPlayer.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);


                     MainGameMenu.getCurrentGame().dispose();
                     MainGameMenu.getCurrentGame().setVisible(false);

                     MainGameMenu mnu = new MainGameMenu();
                     mnu.setVisible(true);

                     TicTacToeGame tacToeGame = new TicTacToeGame();
                     tacToeGame.setVisible(false);
                     MainGameMenu.setCurrentGame(tacToeGame);

                     switchTurn = 0;

                   /*  people = PlayerSelector.players;

                     ps = new PlayerSelector();
                     ps.getUserbox().setSelectedItem(people);//Based on the getUserbox() method introduced in PlayerSelector class
                     ps.updateDraws();
                     JOptionPane.showMessageDialog(null,ps.getUserbox().getSelectedItem().toString());//Gets selected player for Player 1 from the PlayerSelector class.


                     ps = new PlayerSelector();
                     ps.getUserbox2().setSelectedItem(people);
                     ps.updateDraws();
                     JOptionPane.showMessageDialog(null,ps.getUserbox2().getSelectedItem().toString());

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  ps.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + ps.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);

                     JOptionPane.showMessageDialog(null,"Wins percentage: " +  ps.winsPercent(winsPercentage) + "%" +
                             "\nTotal Games Played: " + ps.totalGames(),"Result",JOptionPane.INFORMATION_MESSAGE);

                     /*JOptionPane.showMessageDialog(null,"Wins percentage: " +  user.winsPercentage(percentWins) +
                         "\nTotal Games Played: " + user.totalGames(),"Wins Percentage",JOptionPane.INFORMATION_MESSAGE);*/


                     //     JOptionPane.showMessageDialog(null,"Returning to the main menu","Main Menu Return",JOptionPane.INFORMATION_MESSAGE);

         /* TicTacToeGame ttt = new TicTacToeGame();
          ttt.setVisible(false);
          ttt.dispose();

          MainGameMenu TicTT = new MainGameMenu();
          TicTT.setVisible(true);*/

                 }

          }
    }

}

