package pieces;

import game.*;

public class King extends Piece {

    public King(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.KING;
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
