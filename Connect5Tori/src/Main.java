public class Main
{
    public static void main(String[] args)
    {
        Board b = new Board();
        GeneralMess g = new GeneralMess(b);
        b.setGeneralMess(g);

        b.makeMove(new Move(2,2), 'R');
        b.makeMove(new Move(3,2), 'R');
        b.makeMove(new Move(4,2), 'R');
        b.makeMove(new Move(5,2), 'R');
        b.makeMove(new Move(6,2), 'R');
    }
}
