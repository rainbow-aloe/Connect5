

public class RandomComputer /*extends Player*/{
    public RandomComputer(String name, char letter)
    {
        /*super.name = name;
        super.letter = letter;*/
    }

    public Move getMove(/*Board board*/)
    {


        return new Move((int)((Math.random() * (7)) + 1) , (int)((Math.random() * (7)) + 1));
    }
}
