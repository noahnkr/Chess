package pieces;

import game.*;

public class Pawn extends Piece {

    public Pawn(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.PAWN;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        if (onBoard(newRow, newCol)) {
            if (withinOneSpace(newRow, newCol) && isOpenSpace(newRow, newCol))
                return true;
        }
        return false;
    }

    public boolean withinOneSpace(int newRow, int newCol) {
        if (((row - 1) == newRow || row == newRow || (row + 1) == newRow) && 
            ((col - 1) == newCol || col == newCol || (col + 1) == newCol))
                return true;
        return false;
    }

    @Override
    public PieceType getType() {
        return type;
    }
    
}
