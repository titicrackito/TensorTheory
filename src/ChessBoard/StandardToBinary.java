package ChessBoard;

public class StandardToBinary {
    public static long ToBinary(String coordinates){
        if (!coordinates.matches("[a-h][1-8]")){return -1L;}
        int indexColumn = coordinates.length()-2;
        int indexRow = coordinates.length()-1;
        char columnChar = coordinates.charAt(indexColumn);
        char rowChar = coordinates.charAt(indexRow);
        int column = columnChar - 'a';
        int row = rowChar - '1';
        if (column<0 || row<0 || column>7 || row>7){
            throw new IllegalArgumentException("Invalid coordinates");
        }
        long index = (8*(row)+column);
        return 1L<<index;
    }
}