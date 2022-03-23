import java.awt.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class p5i extends Applet
{
    public void init()
    {}
}

public class P5 extends Applet implements ActionListener{
    Button btn;
    public void init()
    {
        Dimension dim = getSize();
        int x= dim.width/2;
        int y= dim.height/2;

        btn= new Button(" Start ");
        btn.addActionListener((ActionListener) this);
        add(btn);

    }
    public void actionPerformed(ActionEvent AE)
    {
        if(btn.getLabel() == " Start ")
        {
            btn.setLabel(" Stop ");
            System.out.println(" Start button clicked !");
        }
        else
        {
            btn.setLabel(" Start ");
            System.out.println(" Stop button clicked !");
        }
    }

}
