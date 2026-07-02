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

    public static void MoveAPiece(String formerCoordinates, String newCoordinates, Board chessBoard) {
        long bformCoordinate = StandardToBinary.ToBinary(formerCoordinates);
        long bnewCoordinate = StandardToBinary.ToBinary(newCoordinates);
        char piece = chessBoard.getPiece(bformCoordinate).charAt(0);
        removePiece(bformCoordinate, chessBoard);
        removePiece(bnewCoordinate, chessBoard);
        switch (piece) {
            case 'P':
                chessBoard.whitePawns |= bnewCoordinate;
                break;
            case 'R':
                chessBoard.whiteRooks |= bnewCoordinate;
                break;
            case 'N':
                chessBoard.whiteKnights |= bnewCoordinate;
                break;
            case 'B':
                chessBoard.whiteBishops |= bnewCoordinate;
                break;
            case 'Q':
                chessBoard.whiteQueens |= bnewCoordinate;
                break;
            case 'K':
                chessBoard.whiteKing |= bnewCoordinate;
                break;

            case 'p':
                chessBoard.blackPawns |= bnewCoordinate;
                break;
            case 'r':
                chessBoard.blackRooks |= bnewCoordinate;
                break;
            case 'n':
                chessBoard.blackKnights |= bnewCoordinate;
                break;
            case 'b':
                chessBoard.blackBishops |= bnewCoordinate;
                break;
            case 'q':
                chessBoard.blackQueens |= bnewCoordinate;
                break;
            case 'k':
                chessBoard.blackKing |= bnewCoordinate;
                break;

            default:
                throw new IllegalArgumentException("Unrecognized piece ");
        }
    }

    public static boolean IsSquareOccupied(Board board,long pieceToMove, long coordinate) {
        String piece = board.getPiece(coordinate);
        String pieceHavingToMove = board.getPiece(pieceToMove);
        if (pieceHavingToMove.equals("P") || pieceHavingToMove.equals("R") || pieceHavingToMove.equals("N") || pieceHavingToMove.equals("B") || pieceHavingToMove.equals("Q") || pieceHavingToMove.equals("K")) {
            if (piece.equals("P") || piece.equals("R") || piece.equals("N") || piece.equals("B") || piece.equals("Q") || piece.equals("K")) {
                return true;
            }}
        if (pieceHavingToMove.equals("p") || pieceHavingToMove.equals("r") || pieceHavingToMove.equals("n") || pieceHavingToMove.equals("b") || pieceHavingToMove.equals("q") || pieceHavingToMove.equals("k")) {
            if (piece.equals("p") || piece.equals("r") || piece.equals("n") || piece.equals("b") || piece.equals("q") || piece.equals("k")) {
                return true;
            }}
            return false;
    }
    public static boolean IsLegalMove(Board board, long pieceToMove, long coordinate) {
        if (pieceToMove==-1L || coordinate==-1L){return false;}
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
            default: return false;
        }

    }
    public static boolean IsRightPieces(Board board, boolean whiteTurn, long pieceToMove) {
        if (whiteTurn) {
            switch (board.getPiece(pieceToMove)) {
                case "P", "R", "N", "B", "Q", "K" -> {
                    return true;
                }default -> {return false;}
                }
            }
            switch (board.getPiece(pieceToMove)) {
                case "p", "r", "n", "b", "q", "k" -> {
                    return true;
                }
                default -> {
                    return false;
                }
            }
        }
        public static boolean IsAnOppositePiece(Board board, long pieceToMove, long coordinate) {
            String pieceHavingToMove = board.getPiece(pieceToMove);
            String piece = board.getPiece(coordinate);
            if(((pieceHavingToMove.equals("p") || pieceHavingToMove.equals("r")
                    || pieceHavingToMove.equals("n") || pieceHavingToMove.equals("b")
                    || pieceHavingToMove.equals("q") || pieceHavingToMove.equals("k"))
                    && (piece.equals("P") || piece.equals("R") || piece.equals("N") || piece.equals("B") || piece.equals("Q") || piece.equals("K")))
                    || ((pieceHavingToMove.equals("P") || pieceHavingToMove.equals("R") || pieceHavingToMove.equals("N")
                    || pieceHavingToMove.equals("B") || pieceHavingToMove.equals("Q") || pieceHavingToMove.equals("K")) && ((piece.equals("p") ||
                    piece.equals("r") || piece.equals("n") || piece.equals("b") || piece.equals("q") || piece.equals("k")))))
            {return true;}
            return false;
        }
    }

