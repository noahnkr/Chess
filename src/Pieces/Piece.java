package pieces;

import game.*;

/**
 * A superclass outline for all pieces on the chess board.
 */
public abstract class Piece {
    
    /**
     * Row of the board that this piece occupies.
     */
    protected int row; 

    /**
     * Column of the board that this piece occupies.
     */
    protected int col;

    /**
     * Color or team of this piece.
     */
    protected Color color;

    /**
     * The Board object that this chess piece is on.
     */
    protected Space[][] board;

    /**
     * The type of this chess piece.
     */
    protected PieceType type;

    /**
     * Creates a new abstract chess piece which has a position 
     * on the chess board and a color to represent its team.
     * 
     * @param row row piece occupies on board
     * @param col column piece occupies on board
     * @param color black or white
     */
    public Piece(int row, int col, Color color, Board board) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.board = board.board;
    }

    /**
     * Moves piece to the new row and column.
     * 
     * @param newRow  
     * @param newCol
     */
    public void move(int newRow, int newCol) {
        if (isLegalMove(newRow, newCol)) {
            Piece temp = this;

            // Replace old space with null
            board[temp.getRow()][temp.getCol()].setPiece(null);

            // Fill new space with old piece
            temp.setRow(newRow);
            temp.setCol(newCol);
            board[newRow][newCol].setPiece(temp);
        }
    }

    @Override
    public String toString() {
        return "[row=" + row + ", col=" + col + ", type=" + getType().toString() + "]";
    }


    /**
     * Determines if the move at the new space is legal
     * for the specific piece.
     * 
     * @param newRow
     * @param newCol 
     * @return true if a legal move, false otherwise
     */
    public abstract boolean isLegalMove(int newRow, int newCol);

    /**
     * Gets the type of the piece.
     * 
     * @return type of the piece
     */
    public abstract PieceType getType();

    // --------------------------------------- Accessor and Mutator Methods ---------------------------------------

    /**
     * Gets row of this piece.
     * 
     * @return row
     */
    public int getRow() {
        return row;
    } 

    /**
     * Gets column of this piece.
     * 
     * @return col
     */
    public int getCol() {
        return col;
    }

    /**
     * Gets the color of this piece.
     * 
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets row of this piece.
     * 
     * @param newRow
     */
    public void setRow(int newRow) {
        row = newRow;
    }

    /**
     * Sets column of this piece.
     * @param newCol
     */
    public void setCol(int newCol) {
        col = newCol;
    }





}
