package pieces;

import game.*;

public class Rook extends Piece {

    public Rook(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.ROOK;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public PieceType getType() {
        return type;
    }
    
}
