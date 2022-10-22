package game;

import pieces.*;
import java.io.File;
import exceptions.IllegalLayoutException;

/**
 * A chess board which simulates a game of chess.
 * @author Noah Roberts
 */
public class Board {
    
    private static final int BOARD_SIZE = 8;
    
    protected Space[][] board;

    /**
     * Constructs a new chess board with the standard starting
     * layout for a game of chess.
     */
    public Board() {
        board = new Space[BOARD_SIZE][BOARD_SIZE];
        setDefaultBoard();
    }


    /**
     * Constructs a new chess board with a custom layout
     * specified in the input file. Format for the file is as follows:
     * K - King
     * Q - Queen
     * R - Rook
     * B - Bishop
     * N - Knight
     * P - Pawn
     * 
     * @param inputFile an input file which specifies layout of chess board.
     */
    public Board(File inputFile) throws IllegalLayoutException {
        board = new Space[BOARD_SIZE][BOARD_SIZE];
    }

    /**
     * Gets the 2D array of Spaces of the chess board.
     * 
     * @return board
     */
    public Space[][] getBoard() {
        return board;
    }

    /**
     * Occupies board with the default starting chess layout.
     */
    private void setDefaultBoard() {
        // Black Pieces
        board[0][0] = new Space(0, 0, new Rook(0, 0, Color.BLACK));
        board[0][1] = new Space(0, 1, new Knight(0, 1, Color.BLACK));
        board[0][2] = new Space(0, 2, new Bishop(0, 2, Color.BLACK));
        board[0][3] = new Space(0, 3, new Queen(0, 3, Color.BLACK));
        board[0][4] = new Space(0, 4, new King(0, 4, Color.BLACK));
        board[0][2] = new Space(0, 5, new Bishop(0, 5, Color.BLACK));
        board[0][1] = new Space(0, 6, new Knight(0, 6, Color.BLACK));
        board[0][0] = new Space(0, 7, new Rook(0, 7, Color.BLACK));

        for (int i = 0; i < BOARD_SIZE; i++) {
            board[1][i] = new Space(1, i, new Pawn(1, i, Color.BLACK));
        }

        // Empty Spaces
        for (int i = 2; i < BOARD_SIZE; i++) {
            for (int j = 0; i < 7; j++) {
                board[i][j] = new Space(i, j);
            }
        }

        // White Pieces
        for(int i = 0; i < BOARD_SIZE; i++) {
            board[6][i] = new Space(6, i, new Pawn(6, i, Color.WHITE));
        }

        board[7][0] = new Space(7, 0, new Rook(7, 0, Color.WHITE));
        board[7][1] = new Space(7, 1, new Knight(7, 1, Color.WHITE));
        board[7][2] = new Space(7, 2, new Bishop(7, 2, Color.WHITE));
        board[7][3] = new Space(7, 3, new King(7, 3, Color.WHITE));
        board[7][4] = new Space(7, 4, new Queen(7, 4, Color.WHITE));
        board[7][5] = new Space(7, 5, new Bishop(7, 5, Color.WHITE));
        board[7][6] = new Space(7, 6, new Knight(7, 6, Color.WHITE));
        board[7][7] = new Space(7, 7, new Rook(7, 7, Color.WHITE));
        
        
    }

}
