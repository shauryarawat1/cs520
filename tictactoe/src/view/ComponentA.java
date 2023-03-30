package view;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import model.RowGameModel;
import controller.RowGameController;

public class ComponentA implements View {
    // certain elements from the base code of RowGamGUI are used here such as game and block
    public RowGameModel gameModel;
    public JPanel game;
    public JButton[][] blocks;

    // Constructor for the class and creates the game layout
    public ComponentA(RowGameController controller)
    {
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

    //updates the text and state of a particular button from the model code
    public void update(RowGameModel model, int row, int column, int trigger)
    {
        blocks[row][column].setText(model.blocksData[row][column].getContents());
        blocks[row][column].setEnabled(model.blocksData[row][column].getIsLegalMove());
    }
}

