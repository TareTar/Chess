import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main 
{
    public JFrame frame;
    public JPanel[][] panels;
    public JLabel[][] labels;

    public ArrayList<Position> positions;

    final static public Piece[][] startingPieceConfiguration = {
        {
            new Piece("black", "rook"), new Piece("black", "knight"),
            new Piece("black", "bishop"), new Piece("black", "queen"),
            new Piece("black", "king"), new Piece("black", "bishop"),
            new Piece("black", "knight"), new Piece("black", "rook")
        },
        {
            new Piece("black", "pawn"), new Piece("black", "pawn"),
            new Piece("black", "pawn"), new Piece("black", "pawn"),
            new Piece("black", "pawn"), new Piece("black", "pawn"),
            new Piece("black", "pawn"), new Piece("black", "pawn")
        },
        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
        {new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece(), new Piece()},
        {
            new Piece("white", "pawn"), new Piece("white", "pawn"),
            new Piece("white", "pawn"), new Piece("white", "pawn"),
            new Piece("white", "pawn"), new Piece("white", "pawn"),
            new Piece("white", "pawn"), new Piece("white", "pawn")
        },
        {
            new Piece("white", "rook"), new Piece("white", "knight"),
            new Piece("white", "bishop"), new Piece("white", "queen"),
            new Piece("white", "king"), new Piece("white", "bishop"),
            new Piece("white", "knight"), new Piece("white", "rook")
        }
    };

    final static public Position startingPosition = new Position(startingPieceConfiguration, "white");

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Screen screen = new Screen();
        screen.updateScreen(startingPosition);
    }

    public Main()
    {
        positions = new ArrayList<Position>();
        positions.add(startingPosition);
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

        //if player has already clicked a valid piece
        if (click)
        {
            Screen.highlightSquare(panels, previousRow, previousColumn, false);

            if (row == previousRow && column == previousColumn || !previousPiece.legalMoves[row][column].isLegal)
            {
                click = !click;
                return;
            }

            //creates a new piece configuration
            Piece[][] pieces = new Piece[8][8];
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    pieces[i][j] = new Piece(currentPosition.pieces[i][j]);
                }
            }

            //swaps pieces in this new piece configuration
            pieces[previousRow][previousColumn] = new Piece();
            pieces[row][column] = previousPiece;

            Screen.updateScreen(labels, pieces[row][column], row, column);
            Screen.updateScreen(labels, pieces[previousRow][previousColumn], previousRow, previousColumn);

            turn = turn == "white" ? "black" : "white";
            
            //creates a new position and adds it to the positions list
            positions.add(new Position(pieces, turn));
        }

        //player has not already clicked a valid piece
        else
        {
            if (selectedPiece.toString().equals("emptyEmpty") || !selectedPiece.color.equals(turn))
            {
                return;
            }

            Screen.highlightSquare(panels, row, column, true);
        }

        //create a copy of piece without referencing
        previousPiece = new Piece(selectedPiece);
        
        previousRow = row;
        previousColumn = column;
        click = !click;
    }
}
