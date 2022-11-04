package game;

import java.io.File;
import java.io.FileNotFoundException;

import exceptions.IllegalLayoutException;
import pieces.Pawn;

/**
 * Simulates a game of chess played between two players.
 */
public class Chess {

    public static void main(String[] args) throws FileNotFoundException, IllegalLayoutException {
        File inputFile = new File("src\\tests\\TestFile1.txt");
        Board b = new Board();
        System.out.println(b.getSpaceFromKey("a8"));
        
    }
    
}
