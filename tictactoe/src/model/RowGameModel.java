package model;


public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";


    // Enumerated types is used here to represent the two users of the game. The values 1 and 2 will
    // be the only values to be considered valid. This ensures that there are no errors due to incorrect values.
    public enum Player
    {
        USER_1("1"),
        USER_2("2");

        private final String data;

        Player(String data)
        {
            this.data = data;
        }

        public String getData()
        {
            return data;
        }
    }

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */

     // the variable is made private to protect its value while running the code. Initially it is set to user 1 for the very first move of the game
    private Player player = Player.USER_1;
    public int movesLeft = 9;

    private String finalResult = null;


    public RowGameModel() {

	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    public String getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }
    // The getter and setter methods are implemented for encapsulation and application of open-closed principle. 
    // The details are hidden from other classes. The getter and setter methods can be used to access and modify the player field.

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
}
