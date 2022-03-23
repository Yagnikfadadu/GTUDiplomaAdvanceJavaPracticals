import java.applet.Applet;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class P6 extends Applet implements MouseListener {
    String str;
    public void init()
    {
        addMouseListener(this);
    }

    public void paint(Graphics G)
    {
        G.drawString(str, 20,20);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        str= "mousePressed Method Called!";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        str = "mouseReleased Method Called!";
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
