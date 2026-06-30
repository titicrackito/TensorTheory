package ChessBoard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board chessboard = new Board();

        Scanner input = new Scanner(System.in);
        boolean isWhiteTurn =true;
        boolean checkmate = false;
        int numberOfMoves = 0;
        while(!checkmate){
            BitBoardUtils.DisplayBoard(chessboard);

            System.out.println("White Turn:\n\tEnter a move to play--> ");
            boolean rightPieces =false;
            String pieceToPlay = input.nextLine();
            long biPieceToPlay = StandardToBinary.ToBinary(pieceToPlay);
                String move = input.nextLine();
                long biMove = StandardToBinary.ToBinary(move);
                boolean ValidMove = false;
                while(!ValidMove){
                    if (MovePiece.IsLegalMove(chessboard, biPieceToPlay,biMove) && MovePiece.IsRightPieces(chessboard , isWhiteTurn , biPieceToPlay)) {
                        ValidMove = true;
                        MovePiece.MoveAPiece(pieceToPlay , move , chessboard);
                        isWhiteTurn = !isWhiteTurn;
                        numberOfMoves++;}
                    else {
                        BitBoardUtils.DisplayBoard(chessboard);
                        System.out.println("Illegal Move\n\tenter a move to play--> ");
                        pieceToPlay = input.nextLine();
                        move = input.nextLine();
                        biPieceToPlay = StandardToBinary.ToBinary(pieceToPlay);
                        biMove = StandardToBinary.ToBinary(move);
                    }
                }

            }
            checkmate = KingUtils.IsMate(chessboard);
        }
    }