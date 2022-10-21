package pieces;

import game.*;

/**
 * A superclass outline for all pieces on the chess board.
 */
public abstract class Piece {
    
    protected int row, col;

    protected Color color;

    protected PieceType type;

    /**
     * Creates a new abstract chess piece which has a position 
     * on the chess board and a color to represent its team.
     * 
     * @param row row piece occupies on board
     * @param col column piece occupies on board
     * @param color black or white
     */
    public Piece(int row, int col, Color color) {

    }

    /**
     * Moves piece to the new row and column.
     * 
     * @param newRow  
     * @param newCol
     */
    public void move(int newRow, int newCol) {

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
     * Gets the piece type of this piece.
     * 
     * @return type
     */
    public PieceType getType() {
        return type;
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
