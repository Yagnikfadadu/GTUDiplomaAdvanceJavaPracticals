import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IFSC extends JFrame {
    private JComboBox state;
    private JComboBox city;
    private JTextField textifsc;
    private JPanel panel1;
    private JComboBox branch;
    String url = "jdbc:mysql://localhost:3306/test";
    String username="root";
    String pass1="root";
    IFSC()
    {
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,500);
        setVisible(true);
        getStateName();
        getCityName();
        getBranch();
        state.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e)
            {

                getCityName();
            }
        });
        city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getBranch();
            }
        });

        branch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                IFSCCode();
            }
        });

    }

    public void getStateName()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct state from ifsc_details");
            while (resultSet.next()) {
                String st;

                st = resultSet.getString(1);
                state.addItem(st);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public  void  getCityName()
    {
        String ctvalue = String.valueOf(state.getSelectedItem());
        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct city1 from ifsc_details where state='"+ctvalue+"'");
            city.removeAllItems();
            while (resultSet.next()) {
                String ct;

                ct = resultSet.getString(1);
                city.addItem(ct);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void getBranch()
    {
        String city1 = String.valueOf(city.getSelectedItem());
        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct branch from ifsc_details where city1='"+city1+"'");
            branch.removeAllItems();
            while (resultSet.next()) {
                String br;

                br = resultSet.getString(1);
                branch.addItem(br);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void IFSCCode()
    {
        String branch1 = String.valueOf(branch.getSelectedItem());
        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct address,ifsc from ifsc_details where branch='"+branch1+"'");

            while (resultSet.next()) {
                String ifscdetails = resultSet.getString(1);
                textifsc.setText(ifscdetails);
                System.out.println(ifscdetails);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        IFSC obj = new IFSC();
    }
}
