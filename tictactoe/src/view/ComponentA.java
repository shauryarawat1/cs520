package view;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import model.RowGameModel;
import controller.RowGameController;

public class ComponentA implements View {
    private JPanel game;
    private JButton[][] block;

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

    public JPanel getGamePanel()
    {
        return game;
    }

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

