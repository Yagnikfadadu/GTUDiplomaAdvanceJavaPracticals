import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
public class P10 extends Applet {

    int x, y, h, w;
    @Override
    public void init()
    {
        setSize(330, 350);
        x = 10;
        y = 100;
        h = 300;
        w = 200;
    }
    @Override
    public void paint(Graphics g)
    {
        for (int i = 0; i < 20; i++)
        {
            x = x + 5;
            y = y + 5;
            h = h - 10;
            w = w - 10;
            if(i % 2 == 0)
            {
            g.setColor(Color.black);
            }
            else
            {
                g.setColor(Color.white);
            }
            g.fillRect(x, y, h, w);
        }
    } }

