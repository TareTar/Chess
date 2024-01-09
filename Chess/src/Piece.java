public class Piece {
    public String color;
    public String type;
    
    public Piece(String color, String type)
    {
        this.color = color;
        this.type = type;
    }

    public Piece(Piece piece)
    {
        this.color = piece.color;
        this.type = piece.type;
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
