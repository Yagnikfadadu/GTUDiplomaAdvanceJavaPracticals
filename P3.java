import java.applet.Applet;
import java.awt.*;

public class P3 extends Applet{

    public void init()
    {
        setSize(400,500);
    }
    public void paint(Graphics G)
    {
        Dimension dim = getSize();
        int x= dim.width/2;
        int y= dim.height/2;

        G.setColor(Color.black);
        G.drawRect(x-25,y-26,100,51 );
        for(int i=100;i<200; i++)
        {
            try {
                Thread.sleep(25);
                G.setColor(Color.BLACK);
                G.fillRect(i+(x-125),y-25,3,51);
                G.setColor(Color.YELLOW);
                G.drawString("Charging ⚡", x, y+2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

