public class Move {
    private int row;
    private int col;

    public int getCol()
    {
        return col;
    }

    public Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public String toString()
    {
        return "( " + col + ", " + row + ")";
    }
}
