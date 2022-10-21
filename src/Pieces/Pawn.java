package pieces;

import game.*;

public class Pawn extends Piece {

    public Pawn(int row, int col, Color color) {
        super(row, col, color);
        type = PieceType.PAWN;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
