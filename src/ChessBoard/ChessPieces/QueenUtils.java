package ChessBoard.ChessPieces;

import ChessBoard.Board;

public class QueenUtils {
    public static boolean QueenLegalMoves(Board board, long queenToMove, long coordinates){
        if (RookUtils.RookLegalMoves(board,queenToMove,coordinates) || BishopUtils.BishopLegalMoves(board,queenToMove,coordinates)){
            return true;
        }
        return false;
    }
}
