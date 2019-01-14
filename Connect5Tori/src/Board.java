import java.awt.*;

public class Board
{
    public static final int X_SIZE = 8;
    public static final int Y_SIZE = 7;
    public static final int Z_SIZE = 8;
    public static final int TIE = 'T';
    public static final int RED = 'R';
    public static final int BLUE = 'B';
    public static final int WIN = 'W';
    public static final int EMPTY = '-';
    public static final int PLAYING = '-';

    private GeneralMess gm;

    private char[][][] board = new char[X_SIZE][Y_SIZE][Z_SIZE];
    private char winner;

    public Board()
    {
        winner = PLAYING;

        for(int x = 0; x<X_SIZE; x++)
        {
            for(int y = 0; y<Y_SIZE; y++)
            {
                for(int z = 0; z<Z_SIZE; z++)
                {
                    board[x][y][z] = EMPTY;
                }
            }
        }
    }

    public Board(Board b)
    {
        board = b.getBoard();
        winner = b.getWinner();
    }

    public char[][][] getBoard() {
        return board;
    }

    public char getWinner() {
        return winner;
    }

    public void setLocation(Location l, char p)
    {
        board[l.getX()][l.getY()][l.getZ()] = p;
    }

    public char getLocation(Location l)
    {
        return board[l.getX()][l.getY()][l.getZ()];
    }

    public boolean makeMove(Move m, char p)
    {
        Location l = new Location(0,0,0);

        if(isFull(m))
        {
            for(int y = 6; y>0; y--)
            {
                if (board[m.getRow()][y][m.getCol()] == EMPTY)
                {
                    board[m.getRow()][y][m.getCol()] = p;
                    l = new Location(m.getRow(), y, m.getCol());
                    gm.repaint();
                    break;
                }
                y--;
            }

            for(int x = 0; x<X_SIZE; x++)
            {
                for(int y = 0; y<Y_SIZE; y++)
                {
                    for(int z = 0; z<Z_SIZE; z++)
                    {
                        if(board[x][y][z] == EMPTY)
                        {
                            winner = PLAYING;
                            break;
                        }

                        winner = TIE;
                    }
                }
            }


            for(int x = -1; x<=1; x++)
            {
                for(int y = -1; y<=1; y++)
                {
                    for(int z = -1; z<=1; z++)
                    {
                        if(l.getX()+x>0 && l.getY()+y>0 && l.getZ()+y>0 && l.getX()+x<X_SIZE && l.getY()+y<Y_SIZE && l.getZ()+y<Z_SIZE && board[l.getX()+x][l.getY()+y][l.getZ()+z]==p)
                        {
                            if(x==0 && y==0 && z==0)
                                break;

                            System.out.print("\n" + x + " " + y + " " + z);

                            int one = frontCheck(l, p, x, y ,z, 0);
                            int two = backCheck(l, p, x, y ,z, 0);

                            if(one + two + 1 >= 5)
                            {
                                winner = WIN;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int frontCheck(Location l, char p, int x, int y, int z, int count)
    {
        if(l.getX()+x>0 && l.getY()+y>0 && l.getZ()+y>0 && l.getX()+x<X_SIZE && l.getY()+y<Y_SIZE && l.getZ()+y<Z_SIZE && board[l.getX()+x][l.getY()+y][l.getZ()+z]==p)
        {
            l = new Location(l.getX()+x, l.getY()+y, l.getZ()+z);
            return frontCheck(l, p, x, y, z, count++);
        }

        return count;
    }
    public int backCheck(Location l, char p, int x, int y, int z, int count)
    {
        if(l.getX()-x>0 && l.getY()-y>0 && l.getZ()-y>0 && l.getX()-x<X_SIZE && l.getY()-y<Y_SIZE && l.getZ()-y<Z_SIZE && board[l.getX()-x][l.getY()-y][l.getZ()-z]==p)
        {
            l = new Location(l.getX()-x, l.getY()-y, l.getZ()-z);
            return backCheck(l, p, x, y, z, count++);
        }
        return count;
    }

    public boolean isFull(Move m)
    {
        for(int y = 0; y<Y_SIZE; y++)
        {
            if(board[m.getRow()][y][m.getCol()]==EMPTY)
            {
                return true;
            }

        }

        return false;
    }

    public void reset()
    {
        winner = PLAYING;

        for(int x = 0; x<X_SIZE; x++)
        {
            for(int y = 0; y<Y_SIZE; y++)
            {
                for(int z = 0; z<Z_SIZE; z++)
                {
                    board[x][y][z] = EMPTY;
                }
            }
        }
    }

    public void draw()
    {

    }
    public void setGeneralMess(GeneralMess g)
    {
        gm = g;
    }
}
