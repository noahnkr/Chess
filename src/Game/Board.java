package game;

import pieces.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import exceptions.IllegalLayoutException;

/**
 * A chess board which simulates a game of chess.
 * 
 * @author Noah Roberts
 */
public class Board {

    private static final int BOARD_SIZE = 8;

    public Space[][] board;

    public HashMap<String, Space> coordinates;


    /**
     * Constructs a new chess board with the standard starting
     * layout for a game of chess.
     */
    public Board() {
        board = new Space[BOARD_SIZE][BOARD_SIZE];
        setDefaultBoard();
        labelSpaces();
        initializeHashMap();
        updatePossibleMoves();
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
        board = new Space[BOARD_SIZE][BOARD_SIZE];
        scanFromFile(inputFile);
        labelSpaces();
        initializeHashMap();
        updatePossibleMoves();
    }

    private void scanFromFile(File inputFile) throws FileNotFoundException, IllegalLayoutException {
        Scanner boardScanner = new Scanner(inputFile);
        int curRow = 0;
        int curCol = 0;
        while (boardScanner.hasNextLine()) {
            while (boardScanner.hasNext()) {
                char pieceType = boardScanner.next().charAt(0);
                System.out.println(pieceType);
                switch (pieceType) {
                    case 'K':
                        board[curRow][curCol] = new Space(curRow, curCol, new King(curRow, curCol, Color.WHITE, this));
                        break;
                    case 'k':
                        board[curRow][curCol] = new Space(curRow, curCol, new King(curRow, curCol, Color.BLACK, this));
                        break;
                    case 'Q':
                        board[curRow][curCol] = new Space(curRow, curCol, new Queen(curRow, curCol, Color.WHITE, this));
                        break;
                    case 'q':
                        board[curRow][curCol] = new Space(curRow, curCol, new Queen(curRow, curCol, Color.BLACK, this));
                        break;
                    case 'R':
                        board[curRow][curCol] = new Space(curRow, curCol, new Rook(curRow, curCol, Color.WHITE, this));
                        break;
                    case 'r':
                        board[curRow][curCol] = new Space(curRow, curCol, new Rook(curRow, curCol, Color.BLACK, this));
                        break;
                    case 'B':
                        board[curRow][curCol] = new Space(curRow, curCol, new Bishop(curRow, curCol, Color.WHITE, this));
                        break;
                    case 'b':
                        board[curRow][curCol] = new Space(curRow, curCol, new Bishop(curRow, curCol, Color.BLACK, this));
                        break;
                    case 'N':
                        board[curRow][curCol] = new Space(curRow, curCol, new Knight(curRow, curCol, Color.WHITE, this));
                        break;
                    case 'n':
                        board[curRow][curCol] = new Space(curRow, curCol, new Knight(curRow, curCol, Color.BLACK, this));
                        break;
                    case 'P':
                        board[curRow][curCol] = new Space(curRow, curCol, new Pawn(curRow, curCol, Color.WHITE, this));
                        break;
                    case 'p':
                        board[curRow][curCol] = new Space(curRow, curCol, new Pawn(curRow, curCol, Color.BLACK, this));
                        break;
                    case '.':
                        board[curRow][curCol] = new Space(curRow, curCol);
                        break;
                }
                curCol++;
            }

            if (curCol != 7) {
                throw new IllegalLayoutException("Missing columns in input file. curCol=" + curCol);
            } else if (boardScanner.hasNextLine()) {
                boardScanner.nextLine();
                curCol = 0;
            }
        }

        if (curRow != 7)
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

    private void labelSpaces() {

        char[] colIndex = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                String key = "";
                key += colIndex[col] + "" + (8 - row);
                board[row][col].setKey(key);
            }

        }
    }


    private void initializeHashMap() {
        coordinates = new HashMap<>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                coordinates.put(board[row][col].key, board[row][col]);
            }
        }
    }

    public void updatePossibleMoves() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                try {
                    board[row][col].getPiece().getColor();
                } catch(NullPointerException e) {
                    continue;
                }
                
            }
        }

    }

    public Space getSpaceFromKey(String key) {
        return coordinates.get(key);
    }

    @Override
    public String toString() {
        String ret = "";
        for (int row = 0; row < BOARD_SIZE; row++) {
            // Horizontal Border
            ret += drawHorizontalLine();
            
            for (int col = 0; col < BOARD_SIZE; col++) {
                try {
                    PieceType type = board[row][col].getPiece().getType();
                    Color color = board[row][col].getPiece().getColor();
                    switch (type) {
                        case KING:
                            if (color == Color.WHITE)
                                ret += "| K ";
                            else
                                ret += "| k ";
                            break;
                        case QUEEN:
                            if (color == Color.WHITE)
                                ret += "| Q ";
                            else
                                ret += "| q ";
                            break;
                        case ROOK:
                            if (color == Color.WHITE)
                                ret += "| R ";
                            else
                                ret += "| r ";
                            break;
                        case BISHOP:
                            if (color == Color.WHITE)
                                ret += "| B ";
                            else
                                ret += "| b ";
                            break;
                        case KNIGHT:
                            if (color == Color.WHITE)
                                ret += "| N ";
                            else
                                ret += "| n ";
                            break;
                        case PAWN:
                            if (color == Color.WHITE)
                                ret += "| P ";
                            else
                                ret += "| p ";
                            break;
                    }
                } catch (NullPointerException e) {
                    ret += "|   ";
                }

                if (col == 7)
                    ret += "| " + (8 - row);
            }
            if (row != 7)
                ret += "\n";
        }

        ret += "\n" + drawHorizontalLine();

        char[] charCols = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        for (int i = 0; i < charCols.length; i++) {
            ret += "  " + charCols[i] + " ";
        }
        return ret;
    }

    private String drawHorizontalLine() {
        String ret = "";
        for (int i = 0; i < 33; i++) {
            // +
            if (i % 4 == 0) {
                ret += "+";
                // + at end
                if (i == 32)
                    ret +="\n";
            // -
            } else
                ret += "-";
        }
        return ret;
    }

}
