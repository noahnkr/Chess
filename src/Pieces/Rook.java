package pieces;

import game.*;

public class Rook extends Piece {

    public Rook(int row, int col, Color color) {
        super(row, col, color);
        type = PieceType.ROOK;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
