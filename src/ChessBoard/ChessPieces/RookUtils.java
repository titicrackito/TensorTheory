package ChessBoard.ChessPieces;

import ChessBoard.Board;
import ChessBoard.MovePiece;

public class RookUtils {
    public static boolean RookLegalMoves(Board board, long rookToMove, long coordinates) {
        int row = Long.numberOfTrailingZeros(rookToMove)/8;
        int col = Long.numberOfTrailingZeros(rookToMove) % 8;
        long legalMoves = 0L;
        String pieceHavingToMove = board.getPiece(coordinates);
        String piece = board.getPiece(coordinates);
        for (long j = 1; j < 7-col; j++) {
            long currentSquare = rookToMove<<j;
            if (MovePiece.IsSquareOccupied(board,rookToMove, currentSquare ))
            {break;}
            legalMoves |= currentSquare;
            if ((pieceHavingToMove.equals("p") || pieceHavingToMove.equals("r")
                    || pieceHavingToMove.equals("n") || pieceHavingToMove.equals("b")
                    || pieceHavingToMove.equals("q") || pieceHavingToMove.equals("k"))
            && (piece.equals("P") || piece.equals("R") || piece.equals("N") || piece.equals("B") || piece.equals("Q") || piece.equals("K"))
            || ((pieceHavingToMove.equals("P") || pieceHavingToMove.equals("R") || pieceHavingToMove.equals("N")
                    || pieceHavingToMove.equals("B") || pieceHavingToMove.equals("Q") || pieceHavingToMove.equals("K")) || (piece.equals("p") ||
                    piece.equals("r") || piece.equals("n") || piece.equals("b") || piece.equals("q") || piece.equals("k")))){break;};




        }
    if (coordinates != (coordinates & ~legalMoves)) {return false;}
    return true;
    }
}
