package ChessBoard;

import ChessBoard.ChessPieces.KingUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board chessboard = new Board();

        try (Scanner input = new Scanner(System.in)) {
            boolean isWhiteTurn = true;
            int numberOfMoves = 0;

            while (true) {
                BitBoardUtils.DisplayBoard(chessboard);
                boolean inCheck = KingUtils.IsInCheck(chessboard, isWhiteTurn);
                if (!KingUtils.HasLegalMove(chessboard, isWhiteTurn)) {
                    if (inCheck) {
                        System.out.println(isWhiteTurn
                                ? "Black won by checkmate"
                                : "White won by checkmate");
                    } else {
                        System.out.println("Stalemate: draw");
                    }
                    break;
                }

                if (inCheck) {
                    System.out.println("Check");
                }
                if (isWhiteTurn) {
                    System.out.println("White Turn:\n\tEnter a move to play--> ");
                } else {
                    System.out.println("Black Turn:\n\tEnter a move to play--> ");
                }
                boolean validMove = false;
                while (!validMove) {
                    String pieceToPlay = input.nextLine();
                    String move = input.nextLine();
                    long from = StandardToBinary.ToBinary(pieceToPlay);
                    long to = StandardToBinary.ToBinary(move);

                    if (MovePiece.IsLegalMove(chessboard, from, to)
                            && MovePiece.IsRightPieces(chessboard, isWhiteTurn, from)) {
                        Board verificationBoard = new Board();
                        verificationBoard.copy(chessboard);
                        MovePiece.MoveAPiece(from, to, verificationBoard);

                        if (KingUtils.IsInCheck(verificationBoard, isWhiteTurn)) {
                            System.out.println("This move leaves your king in check\n\tEnter a move to play--> ");
                        } else {
                            MovePiece.MoveAPiece(from, to, chessboard);
                            isWhiteTurn = !isWhiteTurn;
                            numberOfMoves++;
                            validMove = true;
                        }
                    } else {
                        System.out.println("Illegal Move\n\tEnter a move to play--> ");
                    }
                }
            }
        }
    }
}