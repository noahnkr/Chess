package pieces;


import game.*;

public class Bishop extends Piece {

    public Bishop(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.BISHOP;
    }

    @Override
    public void getPossibleMoves() {
        for (int i = 0; i < 8; i++) {
            possibleMoves.add(new Move(this, row + i, col + i));
            possibleMoves.add(new Move(this, row + i, col + i));


        }
        
    }


    @Override
    public PieceType getType() {
        return type;
    }


    
    
}
