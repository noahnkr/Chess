package game;

import pieces.Piece;

public class Move {

    private Piece piece;

    private int row;

    private int col;

    private boolean isLegal;

    public Move(Piece piece, Space newSpace) {
        this(piece, newSpace.row, newSpace.col);
    }

    public Move(Piece piece, int newRow, int newCol) {
        this.piece = piece;
        row = newRow;
        col = newCol;

        if(piece != null) {
            isLegal = determineIfLegal();
        } else {
            isLegal = false;
        }

    }

    public boolean determineIfLegal() {
        switch(piece.getType()) {
            case KING:
                break;

            case QUEEN:
                break;
            case ROOK:
                break;
            case BISHOP:
                break;

            case KNIGHT:
                if (onBoard() && isOpenSpace() && (
                    (piece.getRow() - 2 == row && piece.getCol() + 1 == col) || 
                    (piece.getRow() - 1 == row && piece.getCol() + 2 == col) ||
                    (piece.getRow() + 1 == row && piece.getCol() + 2 == col) ||
                    (piece.getRow() + 2 == row && piece.getCol() + 1 == col) ||
                    (piece.getRow() + 2 == row && piece.getCol() - 1 == col) ||
                    (piece.getRow() + 1 == row && piece.getCol() - 2 == col) ||
                    (piece.getRow() - 1 == row && piece.getCol() - 2 == col) ||
                    (piece.getRow() - 2 == row && piece.getCol() - 1 == col)))
                        return true;
                break;
            case PAWN:
                if (onBoard() && isOpenSpace()) {
                    if ((piece.getRow() == 1 && piece.getColor() == Color.BLACK) ||
                        (piece.getRow() == 6 && piece.getColor() == Color.WHITE)) {

                    } else if (withinOneSpace()) {

                    }
                    
                }



                break;
        }

        return false;
    }

    /**
     * Helper method for detmineIfLegal which determines if 
     * the desired move is on the chess board.
     * @param newRow
     * @param newCol
     * @return true if on board, false otherwise
     */
    private boolean onBoard() {
        if ((row < 0 || row > 7) || (col < 0 || col >= 7))
            return false;
        return true;
    }

    /**
     * Helper method for determineIfLegal which determines if the
     * desired move is occupied by either an empty space, or an enemy.
     * @param newRow
     * @param newCol
     * @return true if empty or enemy, false otherwise
     */
    private boolean isOpenSpace() {
        Board board = piece.getBoard();
        if (board.board[row][col].getPiece() == null) 
            return true;
        else if (isEnemy()) 
            return true;
        return false;
    }

    private boolean isEnemy() {
        Board board = piece.getBoard();
        if ((board.board[row][col].getPiece().getColor() == Color.WHITE && piece.getColor() == Color.BLACK) || 
            (board.board[row][col].getPiece().getColor() == Color.BLACK && piece.getColor() == Color.WHITE))
                return true;
        return false;

    }

    private boolean withinOneSpace() {
        if (((piece.getRow() - 1) == row || piece.getRow() == row || (piece.getRow() + 1) == row) && 
            ((piece.getCol() - 1) == col || piece.getCol() == col || (piece.getCol() + 1) == col))
                return true;
        return false;
    }
    
    public Piece getPiece() {
        return piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isLegal() {
        return isLegal;
    }
}
