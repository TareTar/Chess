import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

public class Screen extends Main
{
    public Screen()
    {
        frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(new GridLayout(8, 8));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panels = new JPanel[8][8];
        labels = new JLabel[8][8];

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {   
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1 ? Color.white : new Color(118,150,86));
                panels[i][j].setLayout(null);
                panels[i][j].setVisible(true);

                JButton button = new JButton();
                button.setSize(125, 125);
                button.setLayout(null);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);

                final int row = i;
                final int column = j;
                button.addActionListener(e -> performAction(row, column));

                labels[i][j] = new JLabel();
                labels[i][j].setSize(125, 125);

                panels[i][j].add(button);
                panels[i][j].add(labels[i][j]);

                frame.add(panels[i][j]);
            }
        }

        frame.setVisible(true);
    }

    public void updateScreen(Position position)
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {   
                updateScreen(labels, position.pieces[i][j], i, j);
            }
        }
    }

    public static void updateScreen(JLabel[][] labels, Piece piece, int row, int column)
    {
        if (piece.type.equals("empty"))
        {
            labels[row][column].setIcon(null);
            return;
        }

        ImageIcon imageIcon = new ImageIcon("img/" + piece.toString() + ".png");
        Image image = imageIcon.getImage();
        Image newing = image.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newing);

        labels[row][column].setIcon(imageIcon);
    }        

    public static void highlightSquare(JPanel[][] panels, int row, int column, boolean highlight)
    {
        panels[row][column].setBackground(highlight ? Color.orange : row % 2 == 0 && column % 2 == 0 || row % 2 == 1 && column % 2 == 1 ? Color.white : new Color(118,150,86));
    }
}