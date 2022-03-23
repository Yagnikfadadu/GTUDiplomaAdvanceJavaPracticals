import java.applet.Applet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class P4 extends Applet implements MouseListener,MouseMotionListener  {

    String msg="";

    int x,y;
    public void init()
    {
        super.init();
        setSize(400,400);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics G)
    {

        showStatus(msg);
        G.fillRect(x, y, 10, 10);
        G.drawString("x: "+x+" Y:"+y, 20,20);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        x=e.getX();
        y=e.getY();
        msg="X="+x+"Y="+y;
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

        x=e.getX();
        y=e.getY();

        repaint();
        msg="X="+x+"Y="+y;



    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }


}