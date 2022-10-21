package pieces;

import game.*;

public class Knight extends Piece {

    public Knight(int row, int col, Color color) {
        super(row, col, color);
        type = PieceType.KNIGHT;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
