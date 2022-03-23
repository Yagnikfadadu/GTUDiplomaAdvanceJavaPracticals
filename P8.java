import java.awt.*;
import java.awt.event.*;

public class P8 extends Frame implements ItemListener{

    Checkbox c1,c2,c3;
    Canvas cn1;

    P8(){
        setLayout(new FlowLayout());
        setSize(200,150);
        cn1 = new Canvas();
        cn1.setVisible(true);
        cn1.setBounds(10,10,30,30);
        c1 = new Checkbox("Red");
        c2 = new Checkbox("Green");
        c3 = new Checkbox("Blue");


        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);

        add(c1);
        add(c2);
        add(c3);
        add(cn1);
        setVisible(true);
    }

    int r=255,g=255,b=255;




    @Override
    public void itemStateChanged(ItemEvent e)
    {

        if (c1.getState())
        {
            r = 255;
            changeColor();
        }
        else if(!c1.getState())
        {
            r = 0;
            changeColor();
        }

        if (c2.getState())
        {
            g = 255;
            changeColor();
        }
        else if(!c2.getState())
        {
            g = 0;
            changeColor();
        }

        if (c3.getState())
        {
            b = 255;
            changeColor();
        }
        else if(!c3.getState())
        {
            b = 0;
            changeColor();
        }

    }

    public void changeColor()
    {
        cn1.setBackground(new Color(r,g,b));
    }


    public static void main(String[] args)
    {
        new P8();
    }
}