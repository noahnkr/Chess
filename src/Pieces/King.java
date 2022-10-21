package pieces;

import game.*;

public class King extends Piece {

    public King(int row, int col, Color color) {
        super(row, col, color);
        type = PieceType.KING;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
