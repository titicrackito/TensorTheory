package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

import java.util.ArrayList;
import java.util.List;

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
        if (MovePiece.IsSquareOccupied(board, kingToMove, coordinate)){return false;}
        final long COLUMN_A = 0x0101010101010101L;
        final long COLUMN_H = 0x8080808080808080L;
        List<Integer> shift = new ArrayList<>();
        shift.addAll(List.of(1,7,8,9));
        if (kingToMove != (kingToMove & ~COLUMN_A)) {shift.removeAll(List.of(-9,-1,7));}
        if (kingToMove != (kingToMove & ~COLUMN_H)) {shift.removeAll(List.of(9,1,-7));}
        for (int index:shift) {
            if ((kingToMove<<index==coordinate) || (kingToMove<<((-1)*index)==coordinate)) {
                return true;
            }
        }
        return false;
    }
}
