package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

public class BishopUtils {
    public static boolean BishopLegalMoves(Board board, long BishopToMove, long coordinates) {
        int row = Long.numberOfTrailingZeros(BishopToMove) / 8;
        int col = Long.numberOfTrailingZeros(BishopToMove) % 8;
        int[] shift = {9, 7, -9, -7};
        int[] range = {Math.min((7 - col), (7 - row))
                ,Math.min((7-row), col)
                ,Math.min(col, row)
                ,Math.min(row, (7 - col))};
        long currentSquare = BishopToMove;
        for (int direction = 0; direction <= 3; direction++) {
            for (int j = 1; j <= range[direction]; j++) {
                if (shift[direction] > 0) {
                    currentSquare = BishopToMove << (j * shift[direction]);
                }
                if (shift[direction] < 0) {
                    currentSquare = BishopToMove >>> (j * (-1 * shift[direction]));
                }
                if (MovePiece.IsSquareOccupied(board, BishopToMove, currentSquare)) {
                    break;
                }
                if ((currentSquare & coordinates) != 0) {
                    return true;
                }
                if (MovePiece.IsAnOppositePiece(board, BishopToMove, currentSquare)) {
                    break;
                }
            }
        }
        return false;
    }
}
