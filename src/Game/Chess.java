package game;

import java.io.File;
import java.io.FileNotFoundException;

import exceptions.IllegalLayoutException;
import pieces.*;

/**
 * Simulates a game of chess played between two players.
 */
public class Chess {

    public static void main(String[] args) throws FileNotFoundException, IllegalLayoutException {
        Board b = new Board();
        System.out.println(b.toString());
        Piece p = b.getSpaceFromKey("b1").getPiece();
        p.move(new Move(p, b.getSpaceFromKey("b1")));
        System.out.println(b.toString());
        

        
    }
    
}
