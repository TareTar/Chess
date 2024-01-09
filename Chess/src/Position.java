public class Position {
    public Piece[][] pieces;
    public LegalMove[][] legalMoves;
    public String turn;

    public Position(Position position)
    {
        this.pieces = position.pieces;
        this.legalMoves = position.legalMoves;
        this.turn = position.turn;
    }

    public Position(Piece[][] pieces, String turn) {
        this.pieces = pieces;

        legalMoves = new LegalMove[8][8];

        for (int row = 0; row < 8; row++)
        {
            for (int column = 0; column < 8; column++)
            {
                legalMoves[row][column] = new LegalMove(pieces, row, column);
            }
        }

        this.turn = turn;
    }
}
