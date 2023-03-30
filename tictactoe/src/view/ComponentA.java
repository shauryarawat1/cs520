package view;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import model.RowGameModel;
import model.RowGameModel.Player;
import controller.RowGameController;

public class ComponentA implements View {
    // certain elements from the base code of RowGamGUI are used here such as game and block
    public JPanel game;
    public JButton[][] blocks;
    private RowGameController controller;

    // Constructor for the class and creates the game layout
    public ComponentA(RowGameController controller)
    {
        this.controller = controller;
        game = new JPanel(new GridLayout(3, 3));
        blocks = new JButton[3][3];

        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                blocks[row][col] = new JButton();
                blocks[row][col].setPreferredSize(new Dimension(75, 75));
                game.add(blocks[row][col]);
                blocks[row][col].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        controller.move((JButton)e.getSource());
                    }
                });
            }
        }
    }

    // Returns the created layout
    public JPanel getGamePanel()
    {
        return game;
    }

    //updates the text and state of a particular button from the model code. It also prevents overwriting of other player's move
    public void update(RowGameModel model, int row, int column, int trigger)
    {

        String data =  model.blocksData[row][column].getContents();

        if (data.isEmpty() || blocks[row][column].getText().isEmpty())
        {
            blocks[row][column].setText(data);
        }

        blocks[row][column].setEnabled(model.blocksData[row][column].getIsLegalMove());
    }
}

