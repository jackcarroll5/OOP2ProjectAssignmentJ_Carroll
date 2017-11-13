import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
/**
* @author Jack Carroll
        * version 1.0*/


public class MainGameMenu extends JFrame implements ActionListener{

    JMenu gameMenu,playerMenu,fileMenu;
    Person [] players;//Array of users
    int count;//No of users in array
    JLabel welcome;
    JButton userAdd,play,display;

  public MainGameMenu()
  {
      newSys();//Creates user array and set count to 0

      Container pane = getContentPane();
    pane.setLayout(new FlowLayout());
    setLayout(new BorderLayout());//Set up button layout for the shortcut buttons by using border

    welcome = new JLabel();
    //welcome.setLocation(300,100);
      welcome.setVerticalAlignment(SwingConstants.TOP);//Moved JLabel to the top of the JFrame
    welcome.setText("Welcome to Tic Tac Toe! \nPlease choose from the Menu Bar or the shortcuts below and above:");
    welcome.setFont(new Font("monospaced",Font.PLAIN,14));//Setting up the font for the JLabel in the menu.
    welcome.setForeground(Color.BLUE);
    add(welcome);

    setTitle("Tic Tac Toe");
    setSize(750,500);
    setLocation(300,300);
    pane.setBackground(Color.GREEN);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//Default close operation where the app does not close when action performed

    createGameMenu();//Adds menus to the MenuBar
      createPlayerMenu();
      createFileMenu();

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    menuBar.add(gameMenu);
    menuBar.add(playerMenu);
    menuBar.add(fileMenu);

      play = new JButton("Play Game");
      play.setPreferredSize(new Dimension(8,40));
      add(play,BorderLayout.PAGE_START);

  userAdd = new JButton("Add User");
   userAdd.setPreferredSize(new Dimension(10,40));
    add(userAdd,BorderLayout.SOUTH);

      /*display = new JButton("Add User");
      display.setPreferredSize(new Dimension(10,40));
      add(display);*/



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
      else {
          JOptionPane.showMessageDialog(null,"Resuming Application","Continue",JOptionPane.INFORMATION_MESSAGE);
      }
      }
    });//End of Window Listener Action to close window in main menu


      userAdd.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              newPlayer();
          }
      });

      play.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              dispose();
              TicTacToeGame w = new TicTacToeGame();
              w.setVisible(true);
          }
      });



  }

  /*Initiate process to save the user file for future use of the game
  * by placing the user players array into Users.dat*/
  public void saveUser() throws IOException
  {
      File userFile = new File("Users.dat");
      FileOutputStream fos = new FileOutputStream(userFile);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(players);
      oos.close();
  }

  /*Loads array of users from Users.dat file*/
  public void load()
  {
      count = 1;
     try {
      ObjectInputStream ois;
      ois = new ObjectInputStream(new FileInputStream("Users.dat"));
        players = (Person []) ois.readObject();
        ois.close();
     }
       catch (Exception e)
       {
         JOptionPane.showMessageDialog(null,"File did not load. Sorry! See if the file name is correctly written",
                 "Load Failed",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }

     /*Marks valid user accounts*/
     while(players[count] != null)
         count++;
  }

  public void newSys(){
     players = new Person[5];
      count = 1;
  }

  //Method to register new player for game
  public void newPlayer()
  {
   Person player = new Person();
  player.setName(JOptionPane.showInputDialog("Please enter a user name for registration"));
  player.setWins(0);
  player.setLoss(0);
     // player.setWins(Integer.parseInt(JOptionPane.showInputDialog("Please enter the starting number of wins(0 recommended)")));
              //player.setLoss(Integer.parseInt(JOptionPane.showInputDialog("Please enter the starting number of losses(0 recommended)")));
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
          for (int i = 1; i < count; i++)//Loop of users with list of users available for playing
             jta.append("User no: " + i + "\n" + players[i].toString() + "\n");
             JOptionPane.showMessageDialog(null,jta,"User List",JOptionPane.INFORMATION_MESSAGE);
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

        fileMenu.addSeparator();
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
                 "nine boxes are filled, the game ends in a draw.\n" +
                 "This game is only a 2 player game. No AI is used in this game","Instructions",JOptionPane.INFORMATION_MESSAGE);
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


     else if(e.getActionCommand().equals("Save"))
     {
         /*Handling errors for saving with the try-catch block*/
         try {
             saveUser();
             JOptionPane.showMessageDialog(null,"Save Successful! File has been saved","Saved File",JOptionPane.INFORMATION_MESSAGE);
         }//End of try
          catch (IOException e1) {
             JOptionPane.showMessageDialog(null,"File could not be saved! Please" +
                     "check out console printout for further action","Save Failed!",JOptionPane.ERROR_MESSAGE);
             e1.printStackTrace();
         }//End of catch

     }//End of else if for saving array of users.

     else if(e.getActionCommand().equals("Play"))
     {
           dispose();/*Title: How do I close a JFrame while opening another one?
           Author: Anon
           Site Owner: stackoverflow.com
           Date: 2011
           Code version edited Nov 8'17 at 14:30
           Availability: https://stackoverflow.com/questions/7256606/jdialog-setvisiblefalse-vs-dispose
           (Accessed 7 November 2017)
           Modified: Use dispose() based on JFrame extension
                      Close down 1 JFrame when opening another JFrame*/
           TicTacToeGame w = new TicTacToeGame();
           w.setVisible(true);

     }
     else if(e.getActionCommand().equals("Load User"))
     {
         load();
         JOptionPane.showMessageDialog(null,"File has successfully loaded","Loaded File",JOptionPane.INFORMATION_MESSAGE);
         showUser();
     }
     else
         JOptionPane.showMessageDialog(null,"No clue about what was chosen","Unknown click",JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String[] args)
    {
    MainGameMenu jfw = new MainGameMenu(); //Sets up the JFrame Window
    jfw.setVisible(true);//Displays the JFrame Window to be seen without it being invisible
    }

}
