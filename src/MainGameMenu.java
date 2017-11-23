import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
* @author Jack Carroll
        * version 1.0*/


public class MainGameMenu extends JFrame implements ActionListener{

    JMenu gameMenu,playerMenu,fileMenu;
    static ArrayList <Person>  players;//Array of users
    int count;//No of users in array
    JButton userAdd,play;



  public MainGameMenu()
  {
      newSys();//Creates user array and set count to 0

      Container pane = getContentPane();
    pane.setLayout(new FlowLayout());
    setLayout(new BorderLayout());//Set up button layout for the shortcut buttons by using border



      /*Set up an icon of an O mashed up with an X symbol for the display  of the icon on the
      * top left corner of the screen*/
      setIconImage(new ImageIcon("src\\images\\XO Icon.PNG").getImage());//Sets up icon for the game at the top corner of the app

    setTitle("Tic Tac Toe");
    setSize(575,760);
    setLocation(300,100);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//Default close operation where the app does not close when action performed



    createGameMenu();//Adds menus to the MenuBar
      createPlayerMenu();
      createFileMenu();



 /*Form the JMenuBar which will have the drop down menu items*/
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    menuBar.add(gameMenu);
    menuBar.add(playerMenu);
    menuBar.add(fileMenu);



      play = new JButton("Play Game");
      play.setPreferredSize(new Dimension(4,25));
      add(play,BorderLayout.PAGE_START);//Place the play game button at the top of the frame just below the menu bar.



  userAdd = new JButton("Add User");
   userAdd.setPreferredSize(new Dimension(10,25));
    add(userAdd,BorderLayout.SOUTH);//Place the add user game button at the bottom of the frame.



    /*Set up a decorative XO Image in the centre of the main menu to replace JLabel. No text needed.
    * Picture makes user aware of the game that is going to be played*/
      JLabel XOPic = new JLabel(new ImageIcon("src\\images\\XO Picture.PNG"));
     add(XOPic,BorderLayout.CENTER);
     XOPic.setSize(300,300);
     XOPic.setBounds(10,10,10,10);



    addWindowListener(new WindowAdapter() {
      @Override
      /*When the window is closing, user given a choice to keep playing the game and keep
      the application opened or quit the game and terminate the app.
       */
      public void windowClosing(WindowEvent e) {

      int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit the game?");
      if(choice == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null,"Thanks for playing Tic Tac Toe! Goodbye","Quit", JOptionPane.WARNING_MESSAGE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.exit(0);
      }
      else {
          JOptionPane.showMessageDialog(null,"Resuming Application","Continue",JOptionPane.INFORMATION_MESSAGE);
      }
      }
    });//End of Window Listener Action to close window in main menu


      //Switches to new player registration when add user button is selected
      userAdd.addActionListener(e -> newPlayer());

      //Switches to new game along with the player selector menu when the play button is pressed.
      play.addActionListener(e -> {
          dispose();
          PlayerSelector ps = new PlayerSelector();
          ps.setVisible(true);
          TicTacToeGame w = new TicTacToeGame();
          w.setVisible(true);
      });

      //Example of Players for the game to be added alongside the array list of the remaining users
      players.add(new Person("Jake",0,0,0));
      players.add(new Person("Emily",0,0,0));

      addWindowListener(new WindowAdapter() {
          @Override
          public void windowIconified (WindowEvent e){ //Minimising the window
              JOptionPane.showMessageDialog(null, "Minimizing the window", "Minimizing", JOptionPane.INFORMATION_MESSAGE);
              setExtendedState(Frame.ICONIFIED);
          }
      });

      addWindowListener(new WindowAdapter() {
          @Override
          public void windowDeiconified(WindowEvent e) { //Maximising the window
              JOptionPane.showMessageDialog(null, "Restoring the window", "Restoration", JOptionPane.INFORMATION_MESSAGE);
              setExtendedState(Frame.NORMAL);
          }
      });
  }//End of constructor




  /*Initiate process to save the user file for future use of the game
  * by placing the user players array into Users.dat*/
  public void saveUser() throws IOException
  {
      File userFile = new File("Users.dat");
      FileOutputStream fos = new FileOutputStream(userFile);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(players);
      oos.close();
  }//End of saveUser() method



  /*Loads array of users from Users.dat file*/
  public void load()
  {
      count = 1;
     try {
      ObjectInputStream ois;
        ois = new ObjectInputStream(new FileInputStream("Users.dat"));
        players = (ArrayList<Person>) ois.readObject();
        ois.close();
         JOptionPane.showMessageDialog(null,"File has successfully loaded","Loaded File",JOptionPane.INFORMATION_MESSAGE);
     }
     catch (FileNotFoundException e)
     {
         JOptionPane.showMessageDialog(null,"File could not be found. Sorry! See if file name is correctly written",
                 "Load Failed",JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
     }

     catch (IOException e)
     {
         JOptionPane.showMessageDialog(null,"File could not load. Sorry!",
                 "Load Fail",JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
     }

     catch (Exception e)
       {
         JOptionPane.showMessageDialog(null,"File did not load. Sorry!",
                 "Load Failed",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }

  }//End of load() method




  public void newSys(){
     players = new ArrayList<>(); //Form new player array list to be displayed and list them later on

  }//End of newSys() Class




  //Method to register new player for game
  public void newPlayer()
  {
   Person player = new Person(); //Create new user by using an instance of Person.
  player.setName(JOptionPane.showInputDialog("Please enter a user name for registration"));
  if(player.getName().equals(""))
  {
      JOptionPane.showMessageDialog(null,"The person's name has not been entered. Please fill in a name!","No name",
              JOptionPane.ERROR_MESSAGE);
      newPlayer();
  }
  player.setWins(0);
  player.setLoss(0);
  player.setDraws(0);
  JOptionPane.showMessageDialog(null,"This users's name has been added","User Added",
          JOptionPane.INFORMATION_MESSAGE);
     // player.setWins(Integer.parseInt(JOptionPane.showInputDialog("Please enter the starting number of wins(0 recommended)")));
              //player.setLoss(Integer.parseInt(JOptionPane.showInputDialog("Please enter the starting number of losses(0 recommended)")));
  //player.setWins(0);
 //player.setLoss(0);

 players.add(player);

 count++; //Increase users by 1 until list reaches 5.
  }//End of newPlayer() method




  //Show list of players in JTextArea
  public void showUser()
  {
      JTextArea jta = new JTextArea();
      if(count > 0) {
          jta.setText("Users: \n\n");
          for (int i = 1; i < players.size(); i++)//Loop of users with array list of users available for playing
             jta.append("User no: " + i + "\n" + players.get(i).toString() + "\n");
             JOptionPane.showMessageDialog(null,jta,"User List",JOptionPane.INFORMATION_MESSAGE);
      }
      else
          {
        JOptionPane.showMessageDialog(null,"There are no users available for play","No users",JOptionPane.ERROR_MESSAGE);
      }
  }//End of showUser() method



  //Create the Game menu segment containing the items to play the game and display the rules of the game
 public void createGameMenu(){
      //Creating the Game menu
  gameMenu = new JMenu("Game");

 JMenuItem item = new JMenuItem("Play");
 item.addActionListener(this);
  gameMenu.add(item);

     item = new JMenuItem("Info");
     item.addActionListener(this);
     gameMenu.add(item);
 }//End of createGameMenu() method



    public void createPlayerMenu(){
        //Creating the Player menu
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
    }//End of createPlayerMenu() method



    public void createFileMenu(){
        //Creating the File menu
        fileMenu = new JMenu("File");

        JMenuItem item = new JMenuItem("Save");
        item.addActionListener(this);
        fileMenu.add(item);

        fileMenu.addSeparator();
        item = new JMenuItem("Exit");
        item.addActionListener(this);
        fileMenu.add(item);
    }//End of createFileMenu() method


    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getActionCommand().equals("Info")){ //If Info button pressed,Message shows up of how to play game
         JOptionPane.showMessageDialog(null,"How to play Tic Tac Toe?\n\n" +
         "The aim of the game is to get 3 consecutive Xs or 3 Os in a horizontal,vertical or a " +
                 "diagonal direction in a row to win the game.\nOne player uses the X while the other uses the O.\nIf no one gets the 3 in one direction and all " +
                 "nine boxes are filled, the game ends in a draw.\n" +
                 "This game is only a 2 player game. No AI is used in this game" +
                 "\nBest of Luck with the game!","Instructions",JOptionPane.INFORMATION_MESSAGE);
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
           dispose();
           /*Reference
           Title: How do I close a JFrame while opening another one?
           Author: Anon
           Site Owner: stackoverflow.com
           Date: 2011
           Code version edited Nov 8'17 at 14:30
           Availability: https://stackoverflow.com/questions/7256606/jdialog-setvisiblefalse-vs-dispose
           (Accessed 7 November 2017)
           Modified: Use dispose() based on JFrame extension
                      Close down 1 JFrame when opening another JFrame*/

          PlayerSelector ps = new PlayerSelector();
          ps.setVisible(true);
           TicTacToeGame w = new TicTacToeGame();
           w.setVisible(true);

     }
     //Method to load up user files when Load Menu item is pressed and shows the loaded users from the program
     else if(e.getActionCommand().equals("Load User"))
     {
         load();
         showUser();
     }
     else
         JOptionPane.showMessageDialog(null,"No clue about what was chosen","Unknown click",JOptionPane.INFORMATION_MESSAGE);
    }//End of actionPerformed method




    public static void main(String[] args)
    {
    MainGameMenu jfw = new MainGameMenu(); //Sets up the JFrame Window
    jfw.setVisible(true);//Displays the JFrame Window to be seen without it being invisible
    }//End of main method

}//End of Class
