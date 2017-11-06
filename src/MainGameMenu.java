import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainGameMenu extends JFrame implements ActionListener{

    JMenu gameMenu,playerMenu,fileMenu;
    Person [] players;//Array of users
    int count;//No of users in array

  public MainGameMenu()
  {
      newSys();//Creates user array and set count to 0

      Container pane = new Container();
    pane.setLayout(new FlowLayout());

    setTitle("Tic Tac Toe");
    setSize(500,500);
    setLocation(500,300);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//Default close operation where the app does not close when action performed

    createGameMenu();//Adds menus to the MenuBar
      createPlayerMenu();
      createFileMenu();

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    menuBar.add(gameMenu);
    menuBar.add(playerMenu);
    menuBar.add(fileMenu);

    addWindowListener(new WindowAdapter() {
      @Override
      /*When the window is closing, user given a choice to keep playing the game and keep
      the application opened or quit the game and terminate the app.
       */
      public void windowClosing(WindowEvent e) {

      int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit the game?");
      if(choice == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null,"Thanks for playing Tic Tac Toe! Goodbye","Quit",JOptionPane.CANCEL_OPTION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.exit(0);
      }
      }
    });


  }

  public void newSys(){
     players = new Person[5];
      count = 0;
  }

  //Method to register new player for game
  public void newPlayer()
  {
   Person player = new Person();
  player.setName(JOptionPane.showInputDialog("Please enter a user name for registration"));
      player.setWins(Integer.parseInt(JOptionPane.showInputDialog("Please enter the starting number of wins(0 recommended)")));
              player.setLoss(Integer.parseInt(JOptionPane.showInputDialog("Please enter the starting number of losses(0 recommended)")));
  //player.setWins(0);
 //player.setLoss(0);

 players[count] = player;

 count++; //Increase users by 1 until list reaches 5.
  }


  //Show list of players in JTextArea
  public void showUser()
  {
      JTextArea jta = new JTextArea();
      if(count > 0) {
          jta.setText("Users: \n\n");
          for (int i = 0; i < count; i++)//Loop of users with list of users available for playing
             jta.append("User no: " + i + " " + players[i].toString() + "\n");
             JOptionPane.showMessageDialog(null,jta);
      }
      else{
        JOptionPane.showMessageDialog(null,"There are no users available for play","No users",JOptionPane.ERROR_MESSAGE);
      }
  }



 public void createGameMenu(){
      //Creating the menu
  gameMenu = new JMenu("Game");

 JMenuItem item = new JMenuItem("Play");
 item.addActionListener(this);
  gameMenu.add(item);

     item = new JMenuItem("Info");
     item.addActionListener(this);
     gameMenu.add(item);


 }

    public void createPlayerMenu(){
        //Creating the menu
        playerMenu = new JMenu("User");

        JMenuItem item = new JMenuItem("Register User");
        item.addActionListener(this);
        playerMenu.add(item);

        item = new JMenuItem("Load User");
        item.addActionListener(this);
        playerMenu.add(item);

        playerMenu.addSeparator();//Separates Line between loading user and displaying users.
        item = new JMenuItem("Display");
        item.addActionListener(this);
        playerMenu.add(item);


    }

    public void createFileMenu(){
        //Creating the menu
        fileMenu = new JMenu("File");

        JMenuItem item = new JMenuItem("Save");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Exit");
        item.addActionListener(this);
        fileMenu.add(item);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getActionCommand().equals("Info")){ //If Info button pressed,Message shows up of how to play game
         JOptionPane.showMessageDialog(null,"How to play Tic Tac Toe?\n\n" +
         "The aim of the game is to get 3 consecutive Xs or 3 Os in a horizontal,vertical or a " +
                 "diagonal direction in a row to win the game.\nIf no one gets the 3 in one direction and all " +
                 "nine boxes are filled, the game ends in a draw.","Instructions",JOptionPane.INFORMATION_MESSAGE);
     }
     else if(e.getActionCommand().equals("Exit"))
     {
        JOptionPane.showMessageDialog(null,"Quitting the game now. Thank you come again!","Quit",JOptionPane.WARNING_MESSAGE);
         System.exit(0);
     }
   else if(e.getActionCommand().equals("Register User"))
      {
       newPlayer();//Link to method
      }
      else if(e.getActionCommand().equals("Display"))
     {
         showUser();
     }
      else if(e.getActionCommand().equals("Load User"))
     {


     }

    }




    public static void main(String[] args)
    {
    MainGameMenu jfw = new MainGameMenu(); //Sets up the JFrame Window
    jfw.setVisible(true);//Displays the JFrame Window to be seen without it being invisible
    }


}
