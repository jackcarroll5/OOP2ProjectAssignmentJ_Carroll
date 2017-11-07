import java.io.*;

/**
 * This class will form the details of a person for the OOP2
* Project on the game It is an Instantiable class.
 * @author Jack Carroll
 * version 1.0*/

public class Person implements PercentWins{
    //attributes
    private String name;
    private int wins;
    private int losses;

    public Person()
    {
        setName("");
        setWins(0);
        setLoss(0);
    }

    /**Constructor method
     * @param name the player
     * @param wins of games
     * @param losses of games*/
    public Person(String name,int wins,int losses){
        setName(name);
        setWins(wins);
        setLoss(losses);
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
    public void setWins(int wins) {
        this.wins = wins;
    }


    /**Mutator method to set the number of losses
     *
     * @param losses of games
     */
    public void setLoss(int losses) {
        this.losses = losses;
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
    public int getWins() {
        return wins;
    }

    /**Accessor method to return the number of losses for that player
     *
     * @return number of losses
     */
    public int getLoss() {
        return losses;
    }


    @Override
    public void winsPercentage(float percent) {
       setWins(getWins() + 1 / 100);
    }

    /**toString method to return current player details
     *
     * @return the name of the player,wins for that player and losses for that player in the game as
     * String
     */
    @Override
    public String toString() {
        return String.format("%6s  Wins%5d:  Losses:%5d   Percentage of Wins:%.2f",getName(),getWins(),getLoss());
    }
}//End of class
