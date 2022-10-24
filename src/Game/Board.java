package game;

import pieces.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import exceptions.IllegalLayoutException;

/**
 * A chess board which simulates a game of chess.
 * @author Noah Roberts
 */
public class Board {
    
    private static final int BOARD_SIZE = 8;
    
    public Space[][] board;

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
     * 
     * K - King
     * Q - Queen
     * R - Rook
     * B - Bishop
     * N - Knight
     * P - Pawn
     * . - Empty Space
     * 
     * 0 - White
     * 1 - Black
     * 
     * @param inputFile an input file which specifies layout of chess board.
     */
    public Board(File inputFile) throws IllegalLayoutException, FileNotFoundException {
        // TODO: Fix this...
        board = new Space[BOARD_SIZE][BOARD_SIZE];
        Scanner boardScanner = new Scanner(inputFile);

        int curRow = 0;
        int curCol = 0;
        while (boardScanner.hasNextLine()) {
            while (boardScanner.hasNext()) {
                String spaceStr = boardScanner.next();
                char pieceType = spaceStr.charAt(0);
                char color = spaceStr.charAt(1);
                Color team = null;
                
                if(spaceStr.length() == 2) {
                    if (color == '0')
                        team = Color.WHITE;
                    else if(color == '1')
                        team = Color.BLACK;
                    else
                        throw new IllegalLayoutException("Unknown color character");
                }
                    
                    switch (pieceType) {
                        case 'K':
                            board[curRow][curCol] = new Space(curRow, curCol, new King(curRow, curCol, team, this));
                            break;
                        case 'Q':
                            board[curRow][curCol] = new Space(curRow, curCol, new Queen(curRow, curCol, team, this));
                            break;
                        case 'R':
                            board[curRow][curCol] = new Space(curRow, curCol, new Rook(curRow, curCol, team, this));
                            break;
                        case 'B':
                            board[curRow][curCol] = new Space(curRow, curCol, new Bishop(curRow, curCol, team, this));
                            break;
                        case 'N':
                            board[curRow][curCol] = new Space(curRow, curCol, new Knight(curRow, curCol, team, this));
                            break;
                        case 'P':
                            board[curRow][curCol] = new Space(curRow, curCol, new Pawn(curRow, curCol, team, this));
                            break;
                        case '.':
                            board[curRow][curCol] = new Space(curRow, curCol);
                            break;
                        default:
                            throw new IllegalLayoutException("Unknown space character");
                    }
                    curCol++;
                }
                if (curCol != 7)
                    throw new IllegalLayoutException("Missing space character at [" + curRow + ", " + curCol + "]");
                else if (boardScanner.hasNextLine()) {
                    boardScanner.nextLine();
                    curCol = 0;
                }  
            }

        if(curRow != 7)
            throw new IllegalLayoutException("Not enough rows in input file.");
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
        board[0][0] = new Space(0, 0, new Rook(0, 0, Color.BLACK, this));
        board[0][1] = new Space(0, 0, new Knight(0, 1, Color.BLACK, this));
        board[0][2] = new Space(0, 2, new Bishop(0, 2, Color.BLACK, this));
        board[0][3] = new Space(0, 0, new Queen(0, 3, Color.BLACK, this));
        board[0][4] = new Space(0, 4, new King(0, 4, Color.BLACK, this));
        board[0][5] = new Space(0, 5, new Bishop(0, 5, Color.BLACK, this));
        board[0][6] = new Space(0, 6, new Knight(0, 6, Color.BLACK, this));
        board[0][7] = new Space(0, 7, new Rook(0, 7, Color.BLACK, this));

        for (int i = 0; i < BOARD_SIZE; i++) {
            board[1][i] = new Space(1, i, new Pawn(1, i, Color.BLACK, this));
        }

        // Empty Spaces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Space(i, j);
            }
        }

        // White Pieces
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[6][i] = new Space(6, i, new Pawn(6, i, Color.WHITE, this));
        }

        board[7][0] = new Space(7, 0, new Rook(7, 0, Color.WHITE, this));
        board[7][1] = new Space(7, 1, new Knight(7, 1, Color.WHITE, this));
        board[7][2] = new Space(7, 2, new Bishop(7, 2, Color.WHITE, this));
        board[7][3] = new Space(7, 3, new King(7, 3, Color.WHITE, this));
        board[7][4] = new Space(7, 4, new Queen(7, 4, Color.WHITE, this));
        board[7][5] = new Space(7, 5, new Bishop(7, 5, Color.WHITE, this));
        board[7][6] = new Space(7, 6, new Knight(7, 6, Color.WHITE, this));
        board[7][7] = new Space(7, 7, new Rook(7, 7, Color.WHITE, this));
    }

    @Override
    public String toString() {
        String ret = "";
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                try {
                    PieceType type =  board[row][col].getPiece().getType();
                    switch(type) {
                        case KING:
                            ret += "K ";
                            break;
                        case QUEEN:
                            ret += "Q ";
                            break;
                        case ROOK:
                            ret += "R ";
                            break;
                        case BISHOP:
                            ret += "B ";
                            break;
                        case KNIGHT:
                            ret += "N ";
                            break;
                        case PAWN:
                            ret += "P ";
                            break;
                    }
                } catch(NullPointerException e) {
                    ret += "· ";
                }
            }
            if(row != 7)
                ret += "\n";
        }

        return ret;
    }

}
