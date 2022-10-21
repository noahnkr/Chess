package pieces;

import game.*;

public class Queen extends Piece {

    public Queen(int row, int col, Color color) {
        super(row, col, color);
        type = PieceType.QUEEN;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
