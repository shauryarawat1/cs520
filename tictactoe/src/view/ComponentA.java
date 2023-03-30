package view;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import model.RowGameModel;
import controller.RowGameController;

public class ComponentA implements View {
    // certain elements from the base code of RowGamGUI are used here such as game and block
    private JPanel game;
    private JButton[][] block;

    // Creates the game layout
    public ComponentA(RowGameController controller)
    {
        game = new JPanel(new GridLayout(3, 3));
        block = new JButton[3][3];

        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                block[row][col] = new JButton();
                block[row][col].setPreferredSize(new Dimension(75, 75));
                game.add(block[row][col]);
                block[row][col].addActionListener(new ActionListener() {
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

    //updates the text and state of each button from the model code
    public void update(RowGameModel model)
    {
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                block[row][col].setText(model.blocksData[row][col].getContents());
                block[row][col].setEnabled(model.blocksData[row][col].getIsLegalMove());
            }
        }
    }
}

