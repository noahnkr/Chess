package pieces;

import game.*;

public class Rook extends Piece {

    public Rook(int row, int col, Color color, Board board) {
        super(row, col, color, board);
        type = PieceType.ROOK;
    }

    @Override
    public void getPossibleMoves() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public PieceType getType() {
        return type;
    }


    
    
}
