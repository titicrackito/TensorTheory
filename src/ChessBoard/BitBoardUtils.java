package ChessBoard;

public class BitBoardUtils {
    public static void SimpleDisplay(long position){
        for (int row = 7; row >= 0; row--) {
            for (int col = 0; col < 8; col++) {
                int index = (row * 8) + col;
                long squareMask = 1L << index;
                if (position == squareMask) {
                    System.out.print("X  ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }
    }

    public static void DisplayBoard(Board b) {
        for (int row = 7; row >= 0; row--) {
            for (int col = 0; col < 8; col++) {

                int index = (row * 8) + col;
                long squareMask = 1L << index;

                if ((b.whitePawns & squareMask) != 0) {
                    System.out.print("P  ");
                } else if ((b.whiteRooks & squareMask) != 0) {
                    System.out.print("R  ");
                } else if ((b.whiteKnights & squareMask) != 0) {
                    System.out.print("N  ");
                } else if ((b.whiteBishops & squareMask) != 0) {
                    System.out.print("B  ");
                } else if ((b.whiteQueens & squareMask) != 0) {
                    System.out.print("Q  ");
                } else if ((b.whiteKing & squareMask) != 0) {
                    System.out.print("K  ");
                }

                else if ((b.blackPawns & squareMask) != 0) {
                    System.out.print("p  ");
                } else if ((b.blackRooks & squareMask) != 0) {
                    System.out.print("r  ");
                } else if ((b.blackKnights & squareMask) != 0) {
                    System.out.print("n  ");
                } else if ((b.blackBishops & squareMask) != 0) {
                    System.out.print("b  ");
                } else if ((b.blackQueens & squareMask) != 0) {
                    System.out.print("q  ");
                } else if ((b.blackKing & squareMask) != 0) {
                    System.out.print("k  ");
                }

                else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }
    }
}