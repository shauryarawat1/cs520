package view;

import javax.swing.JTextArea;
import javax.lang.model.util.ElementScanner14;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import model.RowGameModel;
import model.RowGameModel.Player;

public class ComponentC implements View{
    // the playerturn is set to JLabel since it is non-editable
    public JLabel playerturn;

    //Constructor for the class and is called at the beginning of the game
    public ComponentC()
    {
        playerturn = new JLabel();
        playerturn.setText("Player 1 to play 'X'");
    }

    // Used to create the message panel and show the message
    public JPanel getMessagePanel()
    {
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);
        messages.add(playerturn);
        return messages;
    }

    // Depending upon the current player, the related text is set
    public void update(RowGameModel model, int row, int column, int trigger)
    {
        if(model.getFinalResult() != null)
        {
            playerturn.setText(model.getFinalResult());
        }

        else if(model.movesLeft % 2 == 1)
        {
            playerturn.setText("Player 1 to play 'X'");
        }
        else
        {
            playerturn.setText("Player 2 to play 'O'");
        }
    }
}
