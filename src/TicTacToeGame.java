import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Jack Carroll
 * version 1.0*/

public class TicTacToeGame extends JFrame implements ActionListener {
    JMenu options;
    JPanel panel = new JPanel();//Panel for Tic Tac Toe Grid
    private static ButtonPresserXO XOButton[] = new ButtonPresserXO[9];//Buttons for pressing Xs and Os

    public TicTacToeGame() {

        Container cPane = new Container();
        cPane.setLayout(new FlowLayout());

        setIconImage(new ImageIcon("src\\images\\XO Icon.PNG").getImage());


        setSize(700, 700);
        setTitle("Tic Tac Toe");
        setLocation(600, 100);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 3));//Setting up Grid Layout for Tic Tac Toe with the 9 squares in layout.

       /*Adding button array for Tic Tac Toe. Panel adds
       * X and O buttons to the panel for the game, Lined up in the layout
       * of 9 square buttons.*/
        for (int i = 0; i <= 8; i++) {
            XOButton[i] = new ButtonPresserXO();
            panel.add(XOButton[i]); //Adds the array of buttons to the panel using a for loop.
        }
        super.add(panel);//Super class = JFrame. Adding panel for X and O Buttons to frame

        optMenu();//Method for options menu in effect

        /*Adds the menu var to the top of the JFrame in this class*/
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        jmb.add(options);

        addWindowListener(new WindowAdapter() {
            @Override
      /*When the window is closing, user given a choice to keep playing the game and keep
      the application opened or quit the game and terminate the app.
       */
            public void windowClosing(WindowEvent e) {

                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game?");
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Thank you for playing Tic Tac Toe! Bye!", "Quitting Game", JOptionPane.WARNING_MESSAGE);
                    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    System.exit(0);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Resuming Game","Continue Game",JOptionPane.INFORMATION_MESSAGE);
                }
            }//End of windowClosing() void class
        });//End of Window Listener class for closing window of game.

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
    }//End of TicTacToeGame() class

    public void optMenu() {
        options = new JMenu("Options");

        JMenuItem item = new JMenuItem("Back");
        item.addActionListener(this);
        options.add(item);

        item = new JMenuItem("Quit");
        item.addActionListener(this);
        options.add(item);

    }//End of optMenu() method

    public static void setXOButton(ButtonPresserXO[] XOButton) {
        TicTacToeGame.XOButton = XOButton;
    }

    public static ButtonPresserXO[] getXOButton() {
        return XOButton;
    }

    public static void main (String[] args){
            TicTacToeGame jfw = new TicTacToeGame();
            jfw.setVisible(true);
        }//End of main method.

        @Override
        public void actionPerformed (ActionEvent e){
            if (e.getActionCommand().equals("Back")) {
                dispose();//Switching to main menu when you press back by closing down game window and opening main menu window.
                PlayerSelector playerSelector = new PlayerSelector();
                playerSelector.setVisible(false);
                MainGameMenu mnu = new MainGameMenu();
                mnu.setVisible(true);

            } else if (e.getActionCommand().equals("Quit")) {
                JOptionPane.showMessageDialog(null, "Shutting the game down. End of Game! Goodbye!", "Quit", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }

        }//End of method for actionPerformed when pressing menu options.



}//End of TicTacToeGame Class
