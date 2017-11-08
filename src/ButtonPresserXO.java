import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.awt.Event.*;

/**
 * @author Jack Carroll
 * version 1.0*/

public class ButtonPresserXO extends JButton implements ActionListener{

 private ImageIcon OIcon,XIcon;
 private byte symbol = 0; //Represents cases for the numerous symbols of nothing,X and O.

    public ButtonPresserXO()
    {
       OIcon = new ImageIcon("I:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\O Image Paint.PNG");
       XIcon = new ImageIcon("I:\\Yr 2 Semester 1\\OOP2\\OOP2ProjectFolder\\X Image Paint.PNG");
        //OIcon = new ImageIcon("C:\\Users\\T00194823\\Desktop\\OOP2ProjectFolder\\O Image Paint.PNG");
        //XIcon = new ImageIcon("C:\\Users\\T00194823\\Desktop\\OOP2ProjectFolder\\X Image Paint.PNG");
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        /*Add X and O symbol when button is pressed.
        * Cases apply for the different symbols*/
        symbol++;
        symbol %= 3;

        switch (symbol)
        {
            case 0:
              setIcon(null);
                break;
            case 1:
                setIcon(OIcon);
                break;
            case 2:
               setIcon(XIcon);
        }//End of switch statement
    }
}
