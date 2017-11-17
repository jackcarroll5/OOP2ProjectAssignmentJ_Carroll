
//Interface for the percentage of victories by the user in Tic Tac Toe

public interface PercentWinsAndLosses {
    /*Interface method for establishing the percentage of victories according to the number of
    games won and the games played altogether*/

    public void winsPercentage(int percent);

/*The method for incrementing the number of games won by 1*/
    public int updateVictories();

    /*The method for incrementing the number of games lost by 1*/
    public int updateLosses();

    /*The method for calculating the number of games altogether*/
    public int totalGames();


}
