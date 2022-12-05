package pieces;

import java.util.ArrayList;

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
    protected Board board;

    /**
     * The type of this chess piece.
     */
    protected PieceType type;

    /**
     * A list of all the possible moves for this piece.
     */
    protected ArrayList<Move> possibleMoves;

    /**
     * A list of all the legal moves for this piece.
     */
    protected ArrayList<Move> legalMoves;

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
        this.board = board;
        possibleMoves = new ArrayList<Move>();
    }

    /**
     * Moves piece to the new row and column.
     * 
     * @param newRow  
     * @param newCol
     */
    public void move(Move move) {
        if (move.isLegal()) {
            Piece temp = this;
            int newRow = move.getRow();
            int newCol = move.getCol();

            // Replace old space with null
            board.board[temp.getRow()][temp.getCol()].setPiece(null);

            // Fill new space with old piece
            temp.setRow(newRow);
            temp.setCol(newCol);
            board.board[newRow][newCol].setPiece(temp);
        }
    }

    public void move(String key) {
        move(new Move(this, board.getSpaceFromKey(key).row, board.getSpaceFromKey(key).col));
    }

    public void getMoves() {
        getPossibleMoves();
        getLegalMoves();
    }

    protected void getLegalMoves() {
        legalMoves = new ArrayList<Move>();
        for (Move m : possibleMoves) {
            if (m.isLegal())
                legalMoves.add(m);
        }
    }

    @Override
    public String toString() {
        return "[row=" + row + ", col=" + col + ", type=" + getType().toString() + ", color=" + color + "]";
    }

    /**
     * Populates the possibleMoves array with the possible moves 
     * for a certain piece.
     */
    protected abstract void getPossibleMoves();

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
     * Gets the board this piece is on.
     * @return
     */
    public Board getBoard() {
        return board;
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
