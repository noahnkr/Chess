package pieces;

import game.*;

public class Knight extends Piece {

    public Knight(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.KNIGHT;
    }

    @Override
    public void getPossibleMoves() {
        possibleMoves.add(new Move(this, row - 2, col + 1));
        possibleMoves.add(new Move(this, row - 1, col + 2));
        possibleMoves.add(new Move(this, row + 1, col + 2));
        possibleMoves.add(new Move(this, row + 2, col + 1));
        possibleMoves.add(new Move(this, row + 2, col - 1));
        possibleMoves.add(new Move(this, row + 1, col - 2));
        possibleMoves.add(new Move(this, row - 1, col - 2));
        possibleMoves.add(new Move(this, row - 2, col - 1));
    }

    @Override
    public PieceType getType() {
        return type;
    }


    
}
