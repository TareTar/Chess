public class LegalMove
{
    public boolean isLegal;
    public boolean castle;
    public boolean enPassant;

    public LegalMove(boolean isLegal, boolean castle, boolean enPassant)
    {  
        this.isLegal = isLegal;
        this.castle = castle;
        this.enPassant = enPassant;
    }
}
