package ChessBoard;

public class Board {

    public long whitePawns = 0x0000_0000_0000_FF00L;
    public long blackPawns = 0x00FF_0000_0000_0000L;
    public long whiteRooks   = 0x0000_0000_0000_0081L;
    public long whiteKnights = 0x0000_0000_0000_0042L;
    public long whiteBishops = 0x0000_0000_0000_0024L;
    public long whiteQueens  = 0x0000_0000_0000_0008L;
    public long whiteKing    = 0x0000_0000_0000_0010L;

    public long blackRooks   = 0x8100_0000_0000_0000L;
    public long blackKnights = 0x4200_0000_0000_0000L;
    public long blackBishops = 0x2400_0000_0000_0000L;
    public long blackQueens  = 0x0800_0000_0000_0000L;
    public long blackKing    = 0x1000_0000_0000_0000L;

    public boolean WhiteShortCastle = true;
    public boolean BlackShortCastle = true;
    public boolean WhiteLongCastle = true;
    public boolean BlackLongCastle = true;

    public long temporaryEnPassant = 0L;

    public long whitePieces() {
        return whitePawns | whiteRooks | whiteKnights | whiteBishops | whiteQueens | whiteKing;
    }
    public long blackPieces() {
        return blackPawns | blackRooks | blackKnights | blackBishops | blackQueens | blackKing;
    }
    public long allPieces() {
        return whitePieces() | blackPieces();
    }

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

    public String getPiece(long coordinate) {
        if ((whitePawns   & coordinate) != 0) {return "P";}
        if ((blackPawns   & coordinate) != 0) {return "p";}
        if ((whiteRooks   & coordinate) != 0) {return "R";}
        if ((whiteBishops & coordinate) != 0) {return "B";}
        if ((whiteKnights & coordinate) != 0) {return "N";}
        if ((whiteQueens  & coordinate) != 0) {return "Q";}
        if ((whiteKing    & coordinate) != 0) {return "K";}
        if ((blackRooks   & coordinate) != 0) {return "r";}
        if ((blackBishops & coordinate) != 0) {return "b";}
        if ((blackKnights & coordinate) != 0) {return "n";}
        if ((blackQueens  & coordinate) != 0) {return "q";}
        if ((blackKing    & coordinate) != 0) {return "k";}
        return "free";
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

    public void copy(Board copyFrom) {
        this.setWhitePawns(copyFrom.getWhitePawns());
        this.setWhiteRooks(copyFrom.getWhiteRooks());
        this.setWhiteKnights(copyFrom.getWhiteKnights());
        this.setWhiteBishops(copyFrom.getWhiteBishops());
        this.setWhiteQueens(copyFrom.getWhiteQueens());
        this.setWhiteKing(copyFrom.getWhiteKing());
        this.setBlackPawns(copyFrom.getBlackPawns());
        this.setBlackQueens(copyFrom.getBlackQueens());
        this.setBlackKing(copyFrom.getBlackKing());
        this.setBlackKnights(copyFrom.getBlackKnights());
        this.setBlackBishops(copyFrom.getBlackBishops());
        this.setBlackRooks(copyFrom.getBlackRooks());
    }
}