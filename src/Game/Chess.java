package game;

/**
 * Simulates a game of chess played between two players.
 */
public class Chess {

    public static void main(String[] args) {
        Board b = new Board();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("{" + b.getBoard()[i][j].getPiece().toString() + ", ");
            }
            System.out.print("\n");
        }
        System.out.print("}");
    }
    
}
