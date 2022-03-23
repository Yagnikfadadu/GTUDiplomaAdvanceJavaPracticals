import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P7 extends Frame {
    public static void main(String []args)
    {
        Frame f1 = new Frame();
        Button b1 = new Button();
        b1.setBounds(150, 225, 150,30);
        b1.setLabel("Click Me!");
        f1.setBackground(Color.red);
//        b1.setBackground(Color.red);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(f1.getBackground() == Color.red) {
                    f1.setBackground(Color.green);
//                    b1.setBackground(Color.green);
                }
                else if(f1.getBackground()==Color.green) {
                    f1.setBackground(Color.blue);
//                    b1.setBackground(Color.blue);
                }
                else if(f1.getBackground()==Color.blue)
                {
                    f1.setBackground(Color.red);
//                    b1.setBackground(Color.red);
                }
            }
        });
        f1.setVisible(true);
        f1.setResizable(false);
        f1.setSize(470,500);
        f1.setLayout(null);
        f1.add(b1);
    }

}
