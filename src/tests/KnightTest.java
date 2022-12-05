package tests;
import game.*;
import pieces.*;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KnightTest {

    @Test
    public void testKnightMove1() {
        Board b = new Board();
        Piece knight = b.getSpaceFromKey("b1").getPiece();
        knight.move(new Move(knight, b.getSpaceFromKey("c3")));
        assertTrue(b.getSpaceFromKey("b1").getPiece() == null &&
            b.getSpaceFromKey("c3").getPiece().equals(knight));
    }
    
}
