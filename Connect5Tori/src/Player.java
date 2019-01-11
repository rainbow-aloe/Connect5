public abstract class Player {
    public String name;
    public  char letter;

    public Player() {
    }

    public Player(String name, char letter)
    {
        this.name = name;
        this.letter = letter;
    }

    public char letter()
    {
        return letter;
    }

    public abstract Move getMove();

    public String getName()
    {
        return name;
    }

    public abstract Player freshCopy();

    public String toString()
    {
        return "(" + name + " as " + letter + ")";
    }

}
