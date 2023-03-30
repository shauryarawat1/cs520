package view;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import model.RowGameModel;
import model.RowGameModel.Player;

public class ComponentC implements View{
    private JTextArea playerturn;

    //Constructor for the class and is called at the beginning of the game
    public ComponentC()
    {
        playerturn = new JTextArea();
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
    public void update(RowGameModel model)
    {
        if(model.getPlayer() == Player.USER_1)
        {
            playerturn.setText("Player 1 to play 'X'");
        }
        else
        {
            playerturn.setText("Player 2 to play 'O'")
        }
    }
}
