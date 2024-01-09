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
    private JFrame frame;
    private JPanel[][] panels;
    private JLabel[][] labels;

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
                updateScreen(position.pieces[i][j], i, j);
            }
        }
    }

    public void updateScreen(Piece piece, int row, int column)
    {
        if (piece.toString().equals("emptyEmpty"))
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

    private Position currentPosition;
    private String turn;
    private Piece selectedPiece;
    private Piece previousPiece;
    private int previousRow;
    private int previousColumn;
    private boolean click = false;

    public void performAction(int row, int column)
    {
        currentPosition = positions.get(positions.size() - 1);
        turn = currentPosition.turn;

        selectedPiece = currentPosition.pieces[row][column];

        if (click)
        {
            highlightSquare(previousRow, previousColumn, false);

            Piece[][] pieces = new Piece[8][8];
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    pieces[i][j] = new Piece(currentPosition.pieces[i][j]);
                }
            }

            pieces[previousRow][previousColumn] = new Piece();
            pieces[row][column] = previousPiece;

            updateScreen(pieces[row][column], row, column);
            updateScreen(pieces[previousRow][previousColumn], previousRow, previousColumn);

            turn = turn == "white" ? "black" : "white";

            positions.add(new Position(pieces, turn));
        }
        else
        {
            if (selectedPiece.toString().equals("emptyEmpty") || !selectedPiece.color.equals(turn))
            {
                return;
            }

            highlightSquare(row, column, true);
        }

        previousPiece = new Piece(selectedPiece);
        previousRow = row;
        previousColumn = column;
        click = !click;
    }

    public void highlightSquare(int row, int column, boolean highlight)
    {
        panels[row][column].setBackground(highlight ? Color.orange : row % 2 == 0 && column % 2 == 0 || row % 2 == 1 && column % 2 == 1 ? Color.white : new Color(118,150,86));
    }
}