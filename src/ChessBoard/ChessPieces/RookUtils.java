package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

public class RookUtils {
    public static boolean RookLegalMoves(Board board, long rookToMove, long coordinates) {
        int row = Long.numberOfTrailingZeros(rookToMove) / 8;
        int col = Long.numberOfTrailingZeros(rookToMove) % 8;
        int[] shift = {1, -1, 8, -8};
        int[] range = {(7 - col), col, 7 - row, row};

        long currentSquare;
        for (int direction = 0; direction <= 3; direction++) {
            for (int j = 1; j <= range[direction]; j++) {
                if (shift[direction] > 0) {currentSquare = rookToMove << (j * shift[direction]);}
                else {currentSquare = rookToMove >>> (j * (-1 * shift[direction]));}

                if (MovePiece.IsSquareOccupied(board, rookToMove, currentSquare)) {
                    break;
                }
                if ((currentSquare & coordinates) != 0) {return true;}
                if (MovePiece.IsAnOppositePiece(board, rookToMove, currentSquare)) {
                    break;
                }
            }
        }
        return false;
    }
}