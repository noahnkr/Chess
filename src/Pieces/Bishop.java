package pieces;

import game.*;

public class Bishop extends Piece {

    public Bishop(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.BISHOP;
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
