import java.applet.Applet;
import java.awt.*;

/*<Applet code="AppletTry.class" width"500" height"500"></Applet>*/
public class P1 extends Applet {

    public void init()
    {
        super.init();
        setSize(500,300);
    }
    public void paint(Graphics G) {
        int diameter=200;
        Dimension dim = getSize();
        int x= dim.width/2;
        int y= dim.height/2;
        G.drawOval(x-(diameter/2), y-(diameter/2), diameter, diameter);
        int sWidth = G.getFontMetrics().stringWidth("Yagnik");
        G.drawString("Yagnik", x-(sWidth/2),y);

    }
}
