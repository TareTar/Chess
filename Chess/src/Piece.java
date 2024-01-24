public class Piece
{
    public String color;
    public String type;
    public boolean hasMoved;
    public boolean hasCastled;
    public LegalMove[][] legalMoves;
    
    public Piece(String color, String type)
    {
        this.color = color;
        this.type = type;
        hasMoved = false;
        hasCastled = false;
    }

    public Piece(Piece piece)
    {
        color = piece.color;
        type = piece.type;
        hasMoved = piece.hasMoved;
        hasCastled = piece.hasCastled;
        legalMoves = piece.legalMoves;
    }

    public Piece()
    {
        color = "empty";
        type = "empty";
    }

    public String toString()
    {
        return color + type.substring(0, 1).toUpperCase() + type.substring(1);
    }
}
