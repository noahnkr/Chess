package pieces;

import game.*;

public class Pawn extends Piece {

    public Pawn(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.PAWN;
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
