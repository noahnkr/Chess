package game;
import pieces.Piece;

/**
 * Individual spaces of a chess board, can either have
 * a piece occupying the space, or no piece, in which it's 
 * piece field is null.
 */
public class Space {
    
    private int row, col;

    private Piece piece = null;

    /**
     * Creates a new space on a chess board at the
     * specified row and column without a piece.
     * 
     * @param row row on board
     * @param col colun on board
     */
    public Space(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Creates a new space on chess board at the
     * specified row and column with a chess piece.
     * 
     * @param row row on board
     * @param col column on board
     * @param piece chess piece occupying space
     */
    public Space(int row, int col, Piece piece) {
        this(row, col);
        this.piece = piece;
    }

    /**
     * Gets piece occupying this space.
     * 
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }

    
}
