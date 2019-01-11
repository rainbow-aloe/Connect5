public class Main
{
    public static void main(String[] args)
    {
        Board b = new Board();
        GeneralMess g = new GeneralMess(b);
        b.setGeneralMess(g);

        b.makeMove(new Move(2,2), 'R');

    }
}
