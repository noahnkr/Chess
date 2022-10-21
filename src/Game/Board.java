package game;

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
        initializeDefaultBoard();
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
     * Occupies board with the default chess starting chess layout.
     */
    private void initializeDefaultBoard() {

    }

}
