package pieces;

import game.*;

public class Knight extends Piece {

    public Knight(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.KNIGHT;
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
