import java.util.ArrayList;

public class LegalMove
{
    public ArrayList<int[]> LegalMoveList;
    public int row;
    public int column;

    LegalMove(Piece[][] pieces, int row, int column)
    {  
        this.row = row;
        this.column = column;
        LegalMoveList = new ArrayList<int[]>();
    }
}
