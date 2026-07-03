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

    public static boolean KingLegalMove(Board board, long kingToMove, long coordinate) {
        int square = Long.numberOfTrailingZeros(kingToMove);

        if (board.WhiteShortCastle
                && kingToMove == 0x0000_0000_0000_0010L
                && coordinate == 0x0000_0000_0000_0040L
                && (board.getWhiteRooks() & 0x0000_0000_0000_0080L) != 0
                && (board.allPieces() & 0x0000_0000_0000_0060L) == 0
                && !IsSquareAttackedWhite(board, 0x0000_0000_0000_0010L)
                && !IsSquareAttackedWhite(board, 0x0000_0000_0000_0020L)
                && !IsSquareAttackedWhite(board, 0x0000_0000_0000_0040L)) {
                MovePiece.MoveAPiece(0x0000_0000_0000_0080L, 0x0000_0000_0000_0020L ,board );
            return true;
        }


        if (board.WhiteLongCastle
                && kingToMove == 0x0000_0000_0000_0010L
                && coordinate == 0x0000_0000_0000_0004L
                && (board.getWhiteRooks() & 0x0000_0000_0000_0001L) != 0
                && (board.allPieces() & 0x0000_0000_0000_000EL) == 0
                && !IsSquareAttackedWhite(board, 0x0000_0000_0000_0010L)
                && !IsSquareAttackedWhite(board, 0x0000_0000_0000_0008L)
                && !IsSquareAttackedWhite(board, 0x0000_0000_0000_0004L)) {
                MovePiece.MoveAPiece(0x0000_0000_0000_0001L, 0x0000_0000_0000_0008L ,board );
            return true;
        }


        if (board.BlackShortCastle
                && kingToMove == 0x1000_0000_0000_0000L
                && coordinate == 0x4000_0000_0000_0000L
                && (board.getBlackRooks() & 0x8000_0000_0000_0000L) != 0
                && (board.allPieces() & 0x6000_0000_0000_0000L) == 0
                && !IsSquareAttackedBlack(board, 0x1000_0000_0000_0000L)
                && !IsSquareAttackedBlack(board, 0x2000_0000_0000_0000L)
                && !IsSquareAttackedBlack(board, 0x4000_0000_0000_0000L)) {
                MovePiece.MoveAPiece(0x8000_0000_0000_0000L, 0x2000_0000_0000_0000L ,board );
            return true;
        }

        if (board.BlackLongCastle
                && kingToMove == 0x1000_0000_0000_0000L
                && coordinate == 0x0400_0000_0000_0000L
                && (board.getBlackRooks() & 0x0100_0000_0000_0000L) != 0
                && (board.allPieces() & 0x0E00_0000_0000_0000L) == 0
                && !IsSquareAttackedBlack(board, 0x1000_0000_0000_0000L)
                && !IsSquareAttackedBlack(board, 0x0800_0000_0000_0000L)
                && !IsSquareAttackedBlack(board, 0x0400_0000_0000_0000L)) {
                MovePiece.MoveAPiece(0x0100_0000_0000_0000L, 0x0800_0000_0000_0000L ,board );
            return true;
        }

        if ((KING_ATTACKS[square] & coordinate) == 0) {
            return false;
        }
        if (MovePiece.IsSquareOccupied(board, kingToMove, coordinate)) {
            return false;
        }
        return true;
    }

    public static boolean IsSquareAttackedWhite(Board board, long squareToCheck) {

        long rookLike   = board.getBlackRooks()   | board.getBlackQueens();
        long bishopLike = board.getBlackBishops() | board.getBlackQueens();

        if (RookUtils.RookLegalMoves(board, squareToCheck, rookLike)) {return true;}
        if (BishopUtils.BishopLegalMoves(board, squareToCheck, bishopLike)) {return true;}

        int square = Long.numberOfTrailingZeros(squareToCheck);
        if ((KnightUtils.KNIGHT_ATTACKS[square] & board.getBlackKnights()) != 0) {return true;}
        if ((KING_ATTACKS[square] & board.getBlackKing()) != 0) {return true;}

        long notA = squareToCheck & ~COLUMN_A;
        long notH = squareToCheck & ~COLUMN_H;
        if ((((notA << 7) | (notH << 9)) & board.getBlackPawns()) != 0) {return true;}

        return false;
    }

    public static boolean IsSquareAttackedBlack(Board board, long squareToCheck) {
        long rookLike   = board.getWhiteRooks()   | board.getWhiteQueens();
        long bishopLike = board.getWhiteBishops() | board.getWhiteQueens();

        if (RookUtils.RookLegalMoves(board, squareToCheck, rookLike)) {return true;}
        if (BishopUtils.BishopLegalMoves(board, squareToCheck, bishopLike)) {return true;}

        int square = Long.numberOfTrailingZeros(squareToCheck);

        if ((KnightUtils.KNIGHT_ATTACKS[square] & board.getWhiteKnights()) != 0) {return true;}
        if ((KING_ATTACKS[square] & board.getWhiteKing()) != 0) {return true;}

        long notA = squareToCheck & ~COLUMN_A;
        long notH = squareToCheck & ~COLUMN_H;
        if ((((notH >>> 7) | (notA >>> 9)) & board.getWhitePawns()) != 0) {return true;}

        return false;
    }

    public static boolean IsInCheck(Board board, boolean white) {
        if (white) {
            return IsSquareAttackedWhite(board, board.getWhiteKing());
        }
        return IsSquareAttackedBlack(board, board.getBlackKing());
    }

    public static boolean HasLegalMove(Board board, boolean whiteTurn) {
        for (int f = 0; f < 64; f++) {
            long from = 1L << f;
            if (!MovePiece.IsRightPieces(board, whiteTurn, from)) {continue;}

            for (int t = 0; t < 64; t++) {
                long to = 1L << t;
                if (!MovePiece.IsLegalMove(board, from, to)) {continue;}

                Board verification = new Board();
                verification.copy(board);
                MovePiece.MoveAPiece(from, to, verification);
                if (!IsInCheck(verification, whiteTurn)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean IsMate(Board board, boolean whiteTurn) {
        return IsInCheck(board, whiteTurn) && !HasLegalMove(board, whiteTurn);
    }

    public static boolean IsStalemate(Board board, boolean whiteTurn) {
        return !IsInCheck(board, whiteTurn) && !HasLegalMove(board, whiteTurn);
    }
}