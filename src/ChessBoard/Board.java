package ChessBoard;

public class Board {

    public long whitePawns = 0x0000_0000_0000_FF00L;
    public long blackPawns = 0x00FF_0000_0000_0000L;

    // Les pièces blanches (Ligne 1)
    public long whiteRooks   = 0x0000_0000_0000_0081L;
    public long whiteKnights = 0x0000_0000_0000_0042L;
    public long whiteBishops = 0x0000_0000_0000_0024L;
    public long whiteQueens  = 0x0000_0000_0000_0008L;
    public long whiteKing   = 0x0000_0000_0000_0010L;

    public long blackRooks   = 0x8100_0000_0000_0000L;
    public long blackKnights = 0x4200_0000_0000_0000L;
    long blackBishops = 0x2400_0000_0000_0000L;
    public long blackQueens  = 0x0800_0000_0000_0000L;
    public long blackKing = 0x1000_0000_0000_0000L;

    public long getWhitePawns() {
        return whitePawns;
    }
    public long getBlackPawns() {
        return blackPawns;
    }
    public long getWhiteRooks() {
        return whiteRooks;
    }
    public long getWhiteKnights() {
        return whiteKnights;
    }
    public long getWhiteBishops() {
        return whiteBishops;
    }
    public long getWhiteQueens() {
        return whiteQueens;
    }
    public long getWhiteKing() {
        return whiteKing;
    }
    public long getBlackRooks() {
        return blackRooks;
    }
    public long getBlackKnights() {
        return blackKnights;
    }
    public long getBlackBishops() {
        return blackBishops;
    }
    public long getBlackQueens() {
        return blackQueens;
    }
    public long getBlackKing() {
        return blackKing;
    }
    public String getPiece(long coordinatePieceToMove) {
        if (getWhitePawns() != (getWhitePawns() & ~coordinatePieceToMove)) {return "P";}
        if (getBlackPawns() != (getBlackPawns() & ~coordinatePieceToMove)) {return "p";}
        if (getWhiteRooks() != (getWhiteRooks() & ~coordinatePieceToMove)) {return "R";}
        if (getWhiteBishops() != (getWhiteBishops() & ~coordinatePieceToMove)) {return "B";}
        if (getWhiteKnights() != (getWhiteKnights() & ~coordinatePieceToMove)) {return "N";}
        if (getWhiteQueens() != (getWhiteQueens() & ~coordinatePieceToMove)) {return "Q";}
        if (getWhiteKing() != (getWhiteKing() & ~coordinatePieceToMove)) {return "K";}
        if (getBlackRooks() != (getBlackRooks() & ~coordinatePieceToMove)) {return "r";}
        if (getBlackBishops() != (getBlackBishops() & ~coordinatePieceToMove)) {return "b";}
        if (getBlackKnights() != (getBlackKnights() & ~coordinatePieceToMove)) {return "n";}
        if (getBlackQueens() != (getBlackQueens() & ~coordinatePieceToMove)) {return "q";}
        if (getBlackKing() != (getBlackKing() & ~coordinatePieceToMove)) {return "k";}
        else {return "free";}
    }
    public void setWhitePawns(long whitePawns) {
        this.whitePawns = whitePawns;
    }
    public void setBlackPawns(long blackPawns) {
        this.blackPawns = blackPawns;
    }
    public void setWhiteRooks(long whiteRooks) {
        this.whiteRooks = whiteRooks;
    }
    public void setWhiteKnights(long whiteKnights) {
        this.whiteKnights = whiteKnights;
    }
    public void setWhiteBishops(long whiteBishops) {
        this.whiteBishops = whiteBishops;
    }
    public void setWhiteQueens(long whiteQueens) {
        this.whiteQueens = whiteQueens;
    }
    public void setWhiteKing(long whiteKing) {
        this.whiteKing = whiteKing;
    }
    public void setBlackRooks(long blackRooks) {
        this.blackRooks = blackRooks;
    }
    public void setBlackKnights(long blackKnights) {
        this.blackKnights = blackKnights;
    }
    public void setBlackBishops(long blackBishops) {
        this.blackBishops = blackBishops;
    }
    public void setBlackQueens(long blackQueens) {
        this.blackQueens = blackQueens;
    }
    public void setBlackKing(long blackKing) {
        this.blackKing = blackKing;
    }
}