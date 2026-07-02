package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

public class KingUtils {

    private static final long COLUMN_A = 0x0101010101010101L;
    private static final long COLUMN_H = 0x8080808080808080L;

    private static final long[] KING_ATTACKS = new long[64];

    static {
        for (int square = 0; square < 64; square++) {
            long king = 1L << square;
            long moves = 0L;

            moves |= king << 8;
            moves |= king >>> 8;

            if ((king & COLUMN_H) == 0) {
                moves |= king << 1;
                moves |= king << 9;
                moves |= king >>> 7;
            }
            if ((king & COLUMN_A) == 0) {
                moves |= king >>> 1;
                moves |= king >>> 9;
                moves |= king << 7;
            }
            KING_ATTACKS[square] = moves;
        }
    }

    public static boolean IsMate(Board board) {
        if (board.whiteKing == 0L) {
            System.out.println("Black won by checkmate");
            return true;
        }
        if (board.blackKing == 0L) {
            System.out.println("White won by checkmate");
            return true;
        }
        return false;
    }

    public static boolean KingLegalMove(Board board, long kingToMove, long coordinate) {
        int square = Long.numberOfTrailingZeros(kingToMove);
        if ((KING_ATTACKS[square] & coordinate) == 0) {
            return false;
        }
        if (MovePiece.IsSquareOccupied(board, kingToMove, coordinate)) {
            return false;
        }
        return true;
    }
    public static boolean IsSquareAttackedWhite(Board board, long squareToCheck){
        if (RookUtils.RookLegalMoves(board,squareToCheck,board.getBlackRooks())) {return true;}
        if (BishopUtils.BishopLegalMoves(board,squareToCheck,board.getBlackBishops())) {return true;}
        if (KnightUtils.KnightLegalMoves(board,squareToCheck,board.getBlackKnights())) {return true;}
        if (QueenUtils.QueenLegalMoves(board,squareToCheck,board.getBlackQueens())) {return true;}
        if ((((squareToCheck<<7) & board.getBlackPawns())!=0) || (((squareToCheck>>>9) & board.getBlackPawns())!=0)){return true;}
        return false;
    }
}