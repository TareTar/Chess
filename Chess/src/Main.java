import java.util.ArrayList;

public class Main 
{
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
}
