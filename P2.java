import java.applet.Applet;
import java.awt.*;

public class P2 extends Applet {
    public void init()
    {
        super.init();
        setSize(500,700);
    }
    public void paint(Graphics G)
    {
        Dimension dim = getSize();
        int x= dim.width/2;
        G.setColor(Color.red);
        for(int i=1;i<=10;i++)
        {
            G.fillOval(x, i*50, 50,50);
        }

        }

}
