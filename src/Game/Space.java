package game;
import pieces.Piece;

/**
 * Individual spaces of a chess board, can either have
 * a piece occupying the space, or no piece, in which it's 
 * piece field is null.
 */
public class Space {
    
    public final int row;

    public final int col;

    private Piece piece = null;

    public String key;

    /**
     * Creates a new empty space on chess board at 
     * the specifieed row and column.
     * 
     * @param row 
     * @param col
     */
    public Space(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    /**
     * Creates a new space on chess board at the
     * specified row and column with a chess piece.
     * 
     * @param row
     * @param col
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
    public Piece getPiece() throws NullPointerException {
        return piece;
    }

    public void setPiece(Piece p) {
        piece = p;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
