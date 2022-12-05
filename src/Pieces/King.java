package pieces;

import java.util.ArrayList;

import game.*;

public class King extends Piece {

    private boolean inCheck;

    public King(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.KING;
        possibleMoves = new ArrayList<Move>();
        inCheck = false;
    }

    @Override
    public void getPossibleMoves() {
        possibleMoves.add(new Move(this, row - 1, col - 1));
        possibleMoves.add(new Move(this, row - 1, col));
        possibleMoves.add(new Move(this, row - 1, col + 1));
        possibleMoves.add(new Move(this, row, col - 1));
        possibleMoves.add(new Move(this, row - 1, col + 1));
        possibleMoves.add(new Move(this, row + 1, col - 1));
        possibleMoves.add(new Move(this, row + 1, col));
        possibleMoves.add(new Move(this, row + 1, col + 1));
    }


    @Override
    public PieceType getType() {
        return type;
    }

    
    
}
