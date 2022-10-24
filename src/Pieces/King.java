package pieces;

import javax.swing.plaf.TreeUI;

import game.*;

public class King extends Piece {

    private boolean inCheck;

    public King(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.KING;
        inCheck = false;
    }

    @Override
    public boolean isLegalMove(int newRow, int newCol) {
        if (onBoard(newRow, newCol)) {
            if (withinOneSpace(newRow, newCol) && isOpenSpace(newRow, newCol) &&
                wontBeInCheck(newRow, newCol))
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

    private boolean wontBeInCheck(int newRow, int newCol) {
        // TODO: 
        return true;
    }

    @Override
    public PieceType getType() {
        return type;
    }
    
}
