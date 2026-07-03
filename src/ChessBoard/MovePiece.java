package ChessBoard;

import ChessBoard.ChessPieces.*;

public class MovePiece {

    public static void removePiece(long removeAtCoordinate, Board board) {
        board.whitePawns &= ~removeAtCoordinate;
        board.whiteRooks &= ~removeAtCoordinate;
        board.whiteKnights &= ~removeAtCoordinate;
        board.whiteBishops &= ~removeAtCoordinate;
        board.whiteQueens &= ~removeAtCoordinate;
        board.whiteKing &= ~removeAtCoordinate;

        board.blackPawns &= ~removeAtCoordinate;
        board.blackRooks &= ~removeAtCoordinate;
        board.blackKnights &= ~removeAtCoordinate;
        board.blackBishops &= ~removeAtCoordinate;
        board.blackQueens &= ~removeAtCoordinate;
        board.blackKing &= ~removeAtCoordinate;
    }

    public static void MoveAPiece(long from, long to, Board chessBoard) {
        char piece = chessBoard.getPiece(from).charAt(0);
        removePiece(from, chessBoard);
        removePiece(to, chessBoard);
        switch (piece) {
            case 'P':
                chessBoard.whitePawns |= to;
                break;
            case 'R':
                chessBoard.whiteRooks |= to;
                if (from == 0x0000_0000_0000_0001L) {chessBoard.WhiteLongCastle=false;}
                if (from == 0x0000_0000_0000_0080L) {chessBoard.WhiteShortCastle=false;}
                break;
            case 'N':
                chessBoard.whiteKnights |= to;
                break;
            case 'B':
                chessBoard.whiteBishops |= to;
                break;
            case 'Q':
                chessBoard.whiteQueens |= to;
                break;
            case 'K':
                chessBoard.whiteKing |= to;
                chessBoard.WhiteShortCastle = false;
                chessBoard.WhiteLongCastle = false;
                break;

            case 'p':
                chessBoard.blackPawns |= to;
                break;
            case 'r':
                chessBoard.blackRooks |= to;
                if (from == 0x0100_0000_0000_0000L) {chessBoard.BlackLongCastle=false;}
                if (from == 0x8000_0000_0000_0000L) {chessBoard.BlackShortCastle=false;}
                break;
            case 'n':
                chessBoard.blackKnights |= to;
                break;
            case 'b':
                chessBoard.blackBishops |= to;
                break;
            case 'q':
                chessBoard.blackQueens |= to;
                break;
            case 'k':
                chessBoard.blackKing |= to;
                break;

            default:
                throw new IllegalArgumentException("Unrecognized piece ");
        }
        // TODO PROMOTION : c'est ICI que tu la traiteras.
    }

    public static void MoveAPiece(String formerCoordinates, String newCoordinates, Board chessBoard) {
        long from = StandardToBinary.ToBinary(formerCoordinates);
        long to = StandardToBinary.ToBinary(newCoordinates);
        MoveAPiece(from, to, chessBoard);
    }
    public static boolean IsSquareOccupied(Board board, long pieceToMove, long coordinate) {
        if ((board.whitePieces() & pieceToMove) != 0) {
            return (board.whitePieces() & coordinate) != 0;
        }
        if ((board.blackPieces() & pieceToMove) != 0) {
            return (board.blackPieces() & coordinate) != 0;
        }
        return false;
    }

    public static boolean IsAnOppositePiece(Board board, long pieceToMove, long coordinate) {
        if ((board.whitePieces() & pieceToMove) != 0) {
            return (board.blackPieces() & coordinate) != 0;
        }
        if ((board.blackPieces() & pieceToMove) != 0) {
            return (board.whitePieces() & coordinate) != 0;
        }
        return false;
    }

    public static boolean IsLegalMove(Board board, long pieceToMove, long coordinate) {
        if (pieceToMove == -1L || coordinate == -1L) {return false;}
        String piece = board.getPiece(pieceToMove);
        switch (piece) {
            case "K":
            case "k":
                return KingUtils.KingLegalMove(board, pieceToMove, coordinate);
            case "P":
            case "p":
                return PawnUtils.PawnLegalMoves(board, pieceToMove, coordinate);
            case "R":
            case "r":
                return RookUtils.RookLegalMoves(board, pieceToMove, coordinate);
            case "N":
            case "n":
                return KnightUtils.KnightLegalMoves(board, pieceToMove, coordinate);
            case "B":
            case "b":
                return BishopUtils.BishopLegalMoves(board, pieceToMove, coordinate);
            case "Q":
            case "q":
                return QueenUtils.QueenLegalMoves(board, pieceToMove, coordinate);
            default:
                return false;
        }
    }
    public static boolean IsRightPieces(Board board, boolean whiteTurn, long pieceToMove) {
        if (whiteTurn) {
            return (board.whitePieces() & pieceToMove) != 0;
        }
        return (board.blackPieces() & pieceToMove) != 0;
    }
}