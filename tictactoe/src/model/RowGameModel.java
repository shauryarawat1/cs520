package model;


public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */

    // the player field was made private
    private String player = "1";
    public int movesLeft = 9;

    private String finalResult = null;


    public RowGameModel() {
	super();

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

    //getter and setter methods were created for the player for access and modification just like finalResult
    public String getPlayer()
    {
        return this.player;
    }

    public void setPlayer(String player)
    {
        this.player = player;
    }
}
