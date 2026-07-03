package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

public class KnightUtils {
    private static final long COLUMN_A = 0x0101010101010101L;
    private static final long COLUMN_B = 0x0202020202020202L;
    private static final long COLUMN_G = 0x4040404040404040L;
    private static final long COLUMN_H = 0x8080808080808080L;
    public static final long[] KNIGHT_ATTACKS = new long[64];
    static {
        for (int square = 0; square < 64; square++) {
            long n = 1L << square;
            long moves = 0L;

            moves |= (n & ~COLUMN_H) << 17;
            moves |= (n & ~COLUMN_A) << 15;
            moves |= (n & ~COLUMN_G & ~COLUMN_H) << 10;
            moves |= (n & ~COLUMN_A & ~COLUMN_B) << 6;
            moves |= (n & ~COLUMN_G & ~COLUMN_H) >>> 6;
            moves |= (n & ~COLUMN_H) >>> 15;
            moves |= (n & ~COLUMN_A) >>> 17;

            KNIGHT_ATTACKS[square] = moves;
        }
    }

    public static boolean KnightLegalMoves(Board board, long knightToMove, long coordinates) {
        int square = Long.numberOfTrailingZeros(knightToMove);
        if ((KNIGHT_ATTACKS[square] & coordinates) == 0) {
            return false;
        }
        if (MovePiece.IsSquareOccupied(board, knightToMove, coordinates)) {
            return false;
        }
        return true;
    }
}