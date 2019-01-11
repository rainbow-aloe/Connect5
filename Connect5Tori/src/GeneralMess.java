import javax.swing.*;
import java.awt.*;

public class GeneralMess extends JFrame {


    //x z y
    int x,y,z = 0;
    Board b;

    char[][][] array = new char[8][7][8];


    public GeneralMess(Board b)
    {
        super();
        this.b = b;
        /*array[0][0][0] = 'B';
        array[1][1][1] = 'R';
        array[2][2][2] = 'R';
        array[3][3][3] = 'B';
        array[4][4][4] = 'R';
        array[5][5][5] = 'B';
        array[6][6][6] = 'R';
        array[7][6][7] = 'R';
        array[6][5][7] = 'R';*/
        //array[6][3][2] = 'R';
        this.array = array;

        setSize(200,700);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
        repaint();
    }

    public void paint(Graphics g)
    {
        array = b.getBoard();
        g.setColor(Color.black);
        g.fillRect(0,0,210,520);
        g.setColor(Color.WHITE);
        /*g.drawLine(10,700,60,650);
        g.drawLine(200,700,250,650);
        g.drawLine(10,700,200,700);
        g.drawLine(60,650,250,650);

        g.drawLine(19,693,207,693);
        g.drawLine(27,686,214,686);
        g.drawLine(33,679,221,679);
        g.drawLine(39,673,228,673);
        g.drawLine(45,667,235,667);
        g.drawLine(51,661,242,661);*/

        int multi = 70;
        for(int i = 0; i < 7; i++) {
            g.setColor(Color.WHITE);
            g.drawLine(40, 10 + (i * multi), 195, 10+ (i * multi));
            g.drawLine(36, 15+ (i *multi), 192, 15+ (i * multi));
            g.drawLine(32, 20+ (i * multi), 187, 20+ (i * multi));
            g.drawLine(28, 25+ (i * multi), 185, 25+ (i * multi));
            g.drawLine(24, 30+ (i * multi), 183, 30+ (i * multi));
            g.drawLine(20, 35+ (i * multi), 180, 35+ (i * multi));
            g.drawLine(16, 40+ (i * multi), 177, 40+ (i * multi));
            g.drawLine(12, 45+ (i * multi), 173, 45+ (i * multi));
            g.drawLine(8, 50+ (i * multi), 168, 50+ (i * multi));

            g.drawLine(40, 10+ (i * multi), 8, 50+ (i * multi));
            g.drawLine(60, 10+ (i * multi), 30, 50+ (i * multi));
            g.drawLine(80, 10+ (i * multi), 50, 50+ (i * multi));
            g.drawLine(100, 10+ (i * multi), 70, 50+ (i * multi));
            g.drawLine(120, 10+ (i * multi), 90, 50+ (i * multi));
            g.drawLine(140, 10+ (i * multi), 110, 50+ (i * multi));
            g.drawLine(160, 10+ (i * multi), 130, 50+ (i * multi));
            g.drawLine(180, 10+ (i * multi), 150, 50+ (i * multi));
            g.drawLine(195, 10+ (i * multi), 170, 50+ (i * multi));
        }

        for(int i = 0;i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                for(int k = 0; k < array[0][0].length; k++)
                {
                    if(array[i][j][k] == 'R')
                    {
                        g.setColor(new Color(15, 175, 255));

                        g.fillOval((int)(43 + (i * 16.5)),9 + (k * 5) + (j * 70),10,5 );
                    }
                    else if(array[i][j][k] == 'B')
                    {
                        g.setColor(new Color(255, 40, 66));
                        g.fillOval((int)(43 + (i * 16.5)),9 + (k * 5) + (j * 70),10,5 );
                    }
                }
            }
        }
    }
}
