import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TicTacToeGame extends JFrame implements ActionListener {
    JMenu options;
    JPanel panel = new JPanel();//Panel for Tic Tac Toe Grid
      //Buttons for pressing Xs and Os

   public TicTacToeGame(){

       Container cPane = new Container();
       cPane.setLayout(new FlowLayout());


    setSize(700,700);
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
         dispose();
      MainGameMenu mnu = new MainGameMenu();
      mnu.setVisible(true);

       }
       else if(e.getActionCommand().equals("Quit"))
       {
           JOptionPane.showMessageDialog(null,"Shutting the game down. End of Game! Goodbye!","Quit",JOptionPane.WARNING_MESSAGE);
           System.exit(0);
       }

    }
}
