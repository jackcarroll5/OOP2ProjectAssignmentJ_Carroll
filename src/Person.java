/**Saves the array of Users to the file*/
import java.io.*;

/**
 * This class will form the details of a person for the OOP2
* Project on the Tic Tac Toe game. It is an Instantiable class.
 * @author Jack Carroll
 * version 1.0*/

public class Person extends ButtonPresserXO implements PercentWinsAndLosses,Serializable,PercentWins{ //Serializable required for saving
    //attributes
    private String name;
    private static int wins;
    private static int losses;
    private static int draws;

    /**
     * Empty argument Constructor for Person
     */
    public Person()
    {
        setName("");
        setWins(0);
        setLoss(0);
        setDraws(0);
    }

    /**Constructor method
     * @param name the player
     * @param wins of games
     * @param losses of games
     * @param draws of games*/
    public Person(String name,int wins,int losses,int draws){
        setName(name);
        setWins(wins);
        setLoss(losses);
        setDraws(draws);
    }//End of Constructor class


    /**Mutator method to set the player's name
     *
     * @param name of player
     */
    public void setName(String name) {
        this.name = name;
    }


    /**Mutator method to set the number of wins
     *
     * @param wins of games
     */
    public static void setWins(int wins) {
        Person.wins = wins;
    }


    /**Mutator method to set the number of losses
     *
     * @param losses of games
     */
    public void setLoss(int losses) {
        this.losses = losses;
    }


    /**Mutator method to set the number of draws
     *
     * @param draws of games
     */
    public static void setDraws(int draws) {
        Person.draws = draws;
    }

    /**Accessor method to return the player's name
     *
     * @return name of player
     */
    public String getName() {
        return name;
    }

    /**Accessor method to return the number of wins for that player
     *
     * @return number of wins
     */
    public static int getWins() {
        return wins;
    }

    /**Accessor method to return the number of losses for that player
     *
     * @return number of losses
     */
    public static int getLoss() {
        return losses;
    }

    /**Accessor method to return the number of draws for that player
     *
     * @return number of draws
     */
    public static int getDraws() {
        return draws;
    }

    /**To set up the victories if the player wins and forming a percentage of victories
     * once the player gets 3 consecutive Xs or Os diagonally,vertically or horizontally*/
    @Override
    public int winsPercentage(int percentWins) {
     setWins(getWins() /  (getWins() + getLoss() + getDraws()) * 100);
        return percentWins;
    }

    @Override
    public float winsPercent(float percent) {
        setWins(getWins() /  (getWins() + getLoss() + getDraws()) * 100);
        return percent;
    }

    @Override
    public void winsPercentage(float percent) {
        setWins(getWins()  / (getWins() + getLoss() + getDraws()) * 100);
    }

    /**Establishing interface method for incrementing the number of victories
     * for a player by 1 if the player wins.*/
    public int updateVictories() {
        return getWins() + 1;
    }

    /**Creates method based on interface to increase the number of losses by
     * 1 if the player loses the game*/
    public int updateLosses() {
        return getLoss() + 1;
    }

    /**Creates method based on interface to increase the number of draws by
     * 1 if the player loses the game*/
    @Override
    public int updateDraws() {
        return getDraws() + 1;
    }

    /**Creates method based on interface to increase the number of losses by
     * 1 if the player loses the game*/
    @Override
    public int totalGames() {
        return getWins() + getLoss() + getDraws();
    }

    /**toString method to return current player details
     *
     * @return the name of the player,wins, losses and draws for that player in the game as a
     * String
     */
    @Override
    public String toString() {
        return String.format("Name: %4s  Wins:%3d  Losses:%3d  Draws:%3d",getName(),getWins(),getLoss(),getDraws());
    }
}//End of class
