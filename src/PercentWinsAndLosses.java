
//Interface for the number of victories and losses
// by the user in Tic Tac Toe

public interface PercentWinsAndLosses {
    /*Interface method for establishing the percentage of victories according to the number of
    games won and the games played altogether*/


    public float winsPercent (float percent);

/*The method for incrementing the number of games won by 1*/
    public void updateVictories();

    /*The method for incrementing the number of games lost by 1*/
    public void updateLosses();

    public void updateDraws();

    /*The method for calculating the number of games altogether*/
    public int totalGames();


}
