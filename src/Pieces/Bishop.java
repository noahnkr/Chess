package pieces;

import game.*;

public class Bishop extends Piece {

    public Bishop(int row, int col, Color color) {
        super(row, col, color);
        type = PieceType.BISHOP;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
