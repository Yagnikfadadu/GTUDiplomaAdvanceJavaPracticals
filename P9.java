import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.*;
public class P9 extends JFrame implements ActionListener
{
    private JMenuItem one;
    private JMenuItem two;
    private JMenuItem three;
    private JMenuItem four;
    private JTextArea l;
    public P9()
    {
        FlowLayout f=new FlowLayout();

        JMenuBar menubar=new JMenuBar();
        JMenu menu=new JMenu("Shop");
        l=new JTextArea(null,1,5);
        JPanel p=new JPanel();
        add(p);
        l.setLayout(new FlowLayout());
        p.add(l);
        one=new JMenuItem("Apple");
        two=new JMenuItem("Ball");
        three=new JMenuItem("Cat");
        four=new JMenuItem("Dog");

        menubar.add(menu);
        menu.add(one);
        menu.add(two);
        menu.add(three);
        menu.add(four);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(menubar);
        setSize(300,150);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== one)
        {
            l.setText(one.getText());
        }
        else if(e.getSource()== two)
        {
            l.setText(two.getText());
        }
        else if(e.getSource()== three)
        {
            l.setText(three.getText());

        }
        else if(e.getSource()== four)
        {
            l.setText(four.getText());
        }

    }
    public static void main(String args[])
    {
       new P9();
    }
}
