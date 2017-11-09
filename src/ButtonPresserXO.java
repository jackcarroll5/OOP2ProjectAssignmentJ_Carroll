import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.awt.Event.*;

/**
 * @author Jack Carroll
 * version 1.0*/

/**
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
 private int symbol = 0; //Represents cases for the numerous symbols of nothing,X and O.
    //Person user = new Person();

    public ButtonPresserXO()
    {
        //Getting images for my original X and O Drawings
       OIcon = new ImageIcon("I:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\O Image Paint.PNG");
       XIcon = new ImageIcon("I:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\X Image Paint.PNG");
        //OIcon = new ImageIcon("C:\\Users\\T00194823\\Desktop\\OOP2ProjectFolder\\O Image Paint.PNG");
        //XIcon = new ImageIcon("C:\\Users\\T00194823\\Desktop\\OOP2ProjectFolder\\X Image Paint.PNG");
       // XIcon = new ImageIcon("C:\\Users\\Jack\\Pictures\\X Image Paint.PNG");
        //OIcon = new ImageIcon("C:\\Users\\Jack\\Pictures\\O Image Paint.PNG");
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        /*Add X and O symbol when button is pressed.
        * Cases apply for the different symbols*/
        symbol++;
        //symbol %= 3;

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


        /**Set turns for players 1 and 2 in the game by switching turns
         * on every second go.*/

      if(symbol % 2 == 0)
      {
          setIcon(XIcon);
      }
     else
          setIcon(OIcon);


        /*if()
       {
       JOptionPane.showMessageDialog(null,"Well Done! You have won this round. Pat on the back!","Victory",JOptionPane.INFORMATION_MESSAGE);
       user.updateVictories();
       }
        else if()
        {
        JOptionPane.showMessageDialog(null,"Hard Luck! You have lost this round. Try again!","Lose",JOptionPane.ERROR_MESSAGE);
        user.updateLosses();
    }
        else if()
        JOptionPane.showMessageDialog(null,"It's a draw! Great job to both players","Draw",JOptionPane.PLAIN_MESSAGE);*/





    }
}
