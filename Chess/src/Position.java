public class Position
{
    public Piece[][] pieces;
    public String turn;

    public Position(Position position)
    {
        this.pieces = new Piece[8][8];

        for (int row = 0; row < 8; row++)
        {
            for (int column = 0; column < 8; column++)
            {
                this.pieces[row][column] = position.pieces[row][column];
            }
        }

        this.turn = position.turn;
    }

    public Position(Piece[][] pieces, String turn) {
        this.pieces = new Piece[8][8];

        for (int row = 0; row < 8; row++)
        {
            for (int column = 0; column < 8; column++)
            {
                this.pieces[row][column] = new Piece(pieces[row][column]);
            }
        }

        this.turn = turn;
        evaluateLegalMoves();
    }

    public void evaluateLegalMoves()
    {
        for (int row = 0; row < 8; row++)
        {
            for (int column = 0; column < 8; column++)
            {
                Piece piece = pieces[row][column];

                if (piece.type.equals("empty"))
                {
                    continue;
                }

                piece.legalMoves = new LegalMove[8][8];
                
                for (int nextRow = 0; nextRow < 8; nextRow++)
                {
                    for (int nextColumn = 0; nextColumn < 8; nextColumn++)
                    {   
                        piece.legalMoves[nextRow][nextColumn] = new LegalMove(false, false, false);
                    }
                }

                switch(piece.type)
                {
                    case "pawn":
                    if (piece.color.equals("white"))
                    {

                    }
                    else
                    {

                    }
                    break;

                    case "knight":
                    if (piece.color.equals("white"))
                    {

                    }
                    else
                    {

                    }
                    break;

                    case "bishop":
                    if (piece.color.equals("white"))
                    {

                    }
                    else
                    {

                    }
                    break;

                    case "rook":
                    if (piece.color.equals("white"))
                    {

                    }
                    else
                    {

                    }
                    break;

                    case "queen":
                    if (piece.color.equals("white"))
                    {

                    }
                    else
                    {

                    }
                    break;

                    case "king":
                    if (piece.color.equals("white"))
                    {

                    }
                    else
                    {

                    }
                    break;
                }
            }
        }
    }

    public boolean checkForChecks(String color, int row, int column, int previousRow, int previousColumn)
    {
        return false;
    }
}
