package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

public class PawnUtils {

    public static boolean PawnLegalMoves(Board board, long pawnToMove, long coordinate) {
        long COLUMN_A = 0x0101010101010101L;
        long COLUMN_H = 0x8080808080808080L;
        long startingPosition = 0x0000_0000_0000_FF00L;

        if (MovePiece.IsSquareOccupied(board, pawnToMove, coordinate)) {return false;}

        if ((pawnToMove & board.getWhitePawns()) != 0) {
            if ((pawnToMove << 8 == coordinate) && (!MovePiece.IsAnOppositePiece(board, pawnToMove, coordinate))) {
                return true;
            }
            if ((pawnToMove << 7 == coordinate) && (MovePiece.IsAnOppositePiece(board, pawnToMove, coordinate))) {
                if ((pawnToMove & COLUMN_A) != 0) {return false;}
                return true;
            }
            if ((pawnToMove << 9 == coordinate) && (MovePiece.IsAnOppositePiece(board, pawnToMove, coordinate))) {
                if ((pawnToMove & COLUMN_H) != 0) {return false;}
                return true;
            }
            if ((pawnToMove << 16 == coordinate)
                    && ((pawnToMove & startingPosition) != 0)
                    && (board.getPiece(pawnToMove << 8).equals("free"))
                    && (board.getPiece(coordinate).equals("free"))) {
                return true;
            }
        }

        if ((pawnToMove & board.getBlackPawns()) != 0) {
            startingPosition = 0x00FF_0000_0000_0000L;
            if ((pawnToMove >>> 8 == coordinate) && (!MovePiece.IsAnOppositePiece(board, pawnToMove, coordinate))) {
                return true;
            }
            if ((pawnToMove >>> 7 == coordinate) && (MovePiece.IsAnOppositePiece(board, pawnToMove, coordinate))) {
                if ((pawnToMove & COLUMN_H) != 0) {return false;}
                return true;
            }
            if ((pawnToMove >>> 9 == coordinate) && (MovePiece.IsAnOppositePiece(board, pawnToMove, coordinate))) {
                if ((pawnToMove & COLUMN_A) != 0) {return false;}
                return true;
            }
            if ((pawnToMove >>> 16 == coordinate)
                    && ((pawnToMove & startingPosition) != 0)
                    && (board.getPiece(pawnToMove >>> 8).equals("free"))
                    && (board.getPiece(coordinate).equals("free"))) {
                return true;
            }
        }
        return false;
    }
}