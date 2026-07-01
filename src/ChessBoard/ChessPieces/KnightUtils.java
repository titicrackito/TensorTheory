package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnightUtils {
    public static boolean KnightLegalMoves(Board board, long knightToMove, long coordinates) {
        final long COLUMN_A = 0b1000000010000000100000001000000010000000100000001000000010000000L;
        final long COLUMN_B = 0b0100000001000000010000000100000001000000010000000100000001000000L;
        final long COLUMN_G = 0b0000001000000010000000100000001000000010000000100000001000000010L;
        final long COLUMN_H = 0b0000000100000001000000010000000100000001000000010000000100000001L;
        List<Integer> indexMoves = new ArrayList<>();
        indexMoves.addAll(List.of(-17, -15, -10, -6, 6, 10, 15, 17));
        if (coordinates != (coordinates & ~COLUMN_A)) {
            indexMoves.removeAll(List.of(6, -10, -17, 15));
        }
        if (coordinates != (coordinates & ~COLUMN_B)) {
            indexMoves.removeAll(List.of(6, -10));
        }
        if (coordinates != (coordinates & ~COLUMN_G)) {
            indexMoves.removeAll(List.of(-6, 10));
        }
        if (coordinates != (coordinates & ~COLUMN_H)) {
            indexMoves.removeAll(List.of(-6, 10, 17, -15));
        }
        long currentSquare = knightToMove;
        for (int index : indexMoves) {
            if (index < 0) {
                currentSquare = knightToMove >> (-index);
            } else {
                currentSquare = knightToMove << index;
            }
            if (!MovePiece.IsSquareOccupied(board, knightToMove, currentSquare) && currentSquare == coordinates) {
                return true;
            }
        } return false;
    }
}

