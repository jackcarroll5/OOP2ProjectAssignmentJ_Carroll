import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TicTacToeGame extends JFrame implements ActionListener {
    JMenu options;

   public TicTacToeGame(){

       Container cPane = new Container();
       cPane.setLayout(new FlowLayout());


    setSize(500,500);
    setTitle("Tic Tac Toe");
    setLocation(300,200);
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

     optMenu();

     JMenuBar jmb = new JMenuBar();
     setJMenuBar(jmb);
     jmb.add(options);

       addWindowListener(new WindowAdapter() {
           @Override
      /*When the window is closing, user given a choice to keep playing the game and keep
      the application opened or quit the game and terminate the app.
       */
           public void windowClosing(WindowEvent e) {

               int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit the game?");
               if(choice == JOptionPane.YES_OPTION) {
                   JOptionPane.showMessageDialog(null,"Thank you for playing Tic Tac Toe! Bye!","Quitting Game",JOptionPane.CANCEL_OPTION);
                   setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                   System.exit(0);
               }
           }
       });
   }

   public void optMenu()
   {
     options = new JMenu("Options");

       JMenuItem item = new JMenuItem("Back");
       item.addActionListener(this);
       options.add(item);

       item = new JMenuItem("Quit");
       item.addActionListener(this);
       options.add(item);

   }




    public static void main(String[] args) {
        TicTacToeGame jfw = new TicTacToeGame();
        jfw.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getActionCommand().equals("Back"))
       {


       }
       else if(e.getActionCommand().equals("Quit"))
       {
           JOptionPane.showMessageDialog(null,"Quitting the game now. Thank you come again!","Quit",JOptionPane.WARNING_MESSAGE);
           System.exit(0);
       }

    }
}
