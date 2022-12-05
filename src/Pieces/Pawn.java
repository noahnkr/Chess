package pieces;

import game.*;

public class Pawn extends Piece {

    public Pawn(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.PAWN;
    }

    @Override
    public void getPossibleMoves() {
        if (color == Color.WHITE) {
            possibleMoves.add(new Move(this, row - 1, col));
            possibleMoves.add(new Move(this, row - 2, col));
            possibleMoves.add(new Move(this, row - 1, col - 1));
            possibleMoves.add(new Move(this, row - 1, col + 1));
        } else {
            possibleMoves.add(new Move(this, row + 1, col));
            possibleMoves.add(new Move(this, row + 2, col));
            possibleMoves.add(new Move(this, row + 1, col - 1));
            possibleMoves.add(new Move(this, row + 1, col + 1));
        }
    }

    @Override
    public PieceType getType() {
        return type;
    }




    
    
}
