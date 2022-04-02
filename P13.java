import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P13 extends JFrame{
    private JComboBox comboBox1;
    private JLabel l1;
    private JLabel l2;
    private JPanel p1;
    String url = "jdbc:mysql://localhost:3306/test";
    String username="root";
    String pass1="root";
    P13()
    {
        setVisible(true);
        setContentPane(p1);
        setSize(300,200);
        getPrice();
        getDetails();
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                getDetails();
            }
        });
    }

    private void getDetails()
    {
        String ans = String.valueOf(comboBox1.getSelectedItem());
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(p1,e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select product,price from products where product='"+ans+"'");
            String st;
            String pr;
            while (resultSet.next()) {
                st = resultSet.getString(1);
                pr = resultSet.getString(2);
                l1.setText("Product : "+st);
                l2.setText("Price : "+pr);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getPrice()
    {

            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(p1,e.getMessage());
            }
            try {
                Connection connection = DriverManager.getConnection(url, username, pass1);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select product,price from products order by product");
                comboBox1.removeAllItems();
                String st;
                while (resultSet.next()) {
                    st = resultSet.getString(1);
                    comboBox1.addItem(st);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) {
        new P13();
    }

}
