package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

public class KingUtils {
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
        final long COLUMN_A = 0x0101010101010101L;
        final long COLUMN_H = 0x8080808080808080L;
        long kingPosition = 0L;
        if (kingToMove==board.getWhiteKing()){kingPosition = board.getWhiteKing();}
        if (kingToMove==board.getBlackKing()){kingPosition = board.getBlackKing();}
        long kingMoves = (kingPosition >> 9) | (kingPosition >> 8) | (kingPosition >> 7) | (kingPosition >> 1) |
                (kingPosition << 9) | (kingPosition << 8) | (kingPosition << 7) | (kingPosition << 1);
        if (kingMoves != (kingMoves & ~COLUMN_A)) {kingMoves &= ~COLUMN_H;}
        if (kingMoves != (kingMoves & ~COLUMN_H)) {kingMoves &= ~COLUMN_A;}
        if (!MovePiece.IsSquareOccupied(board, kingPosition, coordinate) && kingMoves != (kingMoves & ~coordinate)) {return true;}
        return false;
    }
}
