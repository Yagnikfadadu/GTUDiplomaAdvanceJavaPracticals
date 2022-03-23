import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Timer;

public class UserRegistration extends JFrame {
    private JTextField textUser;
    private JTextField textEmail;
    private JTextField textPass;
    private JTextField textConfirmPass;
    private JTextField textPhone;
    private JButton SAVEButton;
    private JButton CANCELButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JButton FIRSTButton;
    private JButton NEXTButton;
    private JButton PREVIOUSButton;
    private JButton LASTButton;
    private JTable table1;
    private JPanel panel1;
    protected DefaultTableModel model;
    String url = "jdbc:mysql://localhost:3306/javadb";
    String username="root";
    String pass1="root";
    UserRegistration()
    {
        model = new DefaultTableModel();
        model.addColumn("Username");
        model.addColumn("Email");
        model.addColumn("Password");
        model.addColumn("Contact");
        table1.setModel(model);
        setContentPane(panel1);
        setTitle("User Registration");
        setVisible(true);
        setSize(1200,600);
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getValue(table1.getSelectedRow());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        showTable();

        table1.setRowHeight(30);

        SAVEButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e)
            {
                addDataInDatabase(textUser.getText().toString(),textEmail.getText().toString(),textPass.getText().toString(),textPhone.getText().toString());
//                showTable();
                clearAll();
            }

        });

        FIRSTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                firstDatabase();
                getValue(0);

                try
                {
                    table1.changeSelection(0, 1, false, false);

                }
                catch (Exception ee)
                {
                    JOptionPane.showMessageDialog(panel1,ee.getMessage());
                }
//                showTable();
            }
        });

        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                showTable();
                clearAll();
            }
        });


        NEXTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                next();
                getValue(table1.getSelectedRow()+1);
                try
                {
                    if (table1.getRowCount()-1==table1.getSelectedRow())
                    {
                        JOptionPane.showMessageDialog(panel1,"Already at Last record");
                    }
                    else {
                        table1.changeSelection(table1.getSelectedRow() + 1, table1.getSelectedColumn(), false, false);
                        System.out.println(table1.getSelectedRow());
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(panel1,ex.getMessage());
                }
//                showTable();
                }
        });

        PREVIOUSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                showTable();
                previous();
                getValue(table1.getSelectedRow()-1);
                try {
                    if (table1.getSelectedRow() == 0) {
                        JOptionPane.showMessageDialog(panel1, "Already at First Record");
                    } else {
                        table1.changeSelection(table1.getSelectedRow() - 1, table1.getSelectedColumn(), false, false);
                    }
                }
                catch (Exception e2)
                {
                    JOptionPane.showMessageDialog(panel1,e2.getMessage());
                }
            }
        });

        LASTButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
//               showTable();
                lastDatabase();
                getValue(table1.getRowCount()-1);
                table1.changeSelection(table1.getRowCount()-1,table1.getColumnCount()-1,false,false);
                System.out.println(table1.getSelectedRow());
            }
        });

        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteData();
                }
                catch (Exception ed)
                {
                    JOptionPane.showMessageDialog(panel1,ed.getMessage());
                }
            }
        });

        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });
    }

    public  void getValue(int row)
    {
        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from registration_data limit " + row + ",1 ");
            while (resultSet.next()) {
                String s1;
                String s2;
                String s3;
                String s4;
                s1 = resultSet.getString(1);
                s2 = resultSet.getString(2);
                s3 = resultSet.getString(3);
                s4 = resultSet.getString(4);
                System.out.println(s1 + s2 + s3 + s4);
            textUser.setText(s1);
            textEmail.setText(s2);
            textPass.setText(s3);
            textPhone.setText(s4);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void clearTable()
    {
        model.setRowCount(0);
        revalidate();
    }

    public void next()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
//            statement.executeQuery("select * from registration_data ORDER BY username DESC LIMIT 1;");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getUsername()
    {
        int row = table1.getSelectedRow();
        String s1 = null;
        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from registration_data limit " + row + ",1 ");
            while (resultSet.next()) {
                s1 = resultSet.getString(1);

            }
            return s1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  s1;
        }
    }

    public void previous()
    {

        try
        {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
//            statement.executeQuery("select * from registration_data ORDER BY username DESC LIMIT 1;");

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }
    }


    public void showTable()
    {
//        clearTable();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Class Name sucess");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }

        try
        {
            Connection connection1=DriverManager.getConnection(url,username,pass1);
            System.out.println("Connection created");
            Statement statement = connection1.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from registration_data");

            while (resultSet.next()) {
                String s1;
                String s2;
                String s3;
                String s4;
                s1 = resultSet.getString(1);
                s2 = resultSet.getString(2);
                s3 = resultSet.getString(3);
                s4 = resultSet.getString(4);
                model.addRow(new Object[]{s1, s2, s3, s4});
            }

    }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }
    }


    public void updateData()
    {
        String u1 = getUsername();
        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement insertStatement = connection.createStatement();
            insertStatement.executeUpdate("update registration_data  set username='"+textUser.getText().toString()+"', email='"+textEmail.getText().toString()+"', password='"+textPass.getText().toString()+"', phone='"+textPhone.getText().toString()+"' where username='"+u1+"'");
            connection.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }


    }

    public void deleteData()
    {
        String un = getUsername();
        try {

            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement deleteStatement = connection.createStatement();
            deleteStatement.executeUpdate("delete from registration_data where username='"+un+"'");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }
    }
    public void addDataInDatabase(String uname,String email,String pass,String phone)
    {

        if(uname.isEmpty())
        {
            JOptionPane.showMessageDialog(panel1,"Username Cannot be Empty!");
        }
        else
        {
            try {


                Connection connection = DriverManager.getConnection(url, username, pass1);
                Statement insertStatement = connection.createStatement();
                insertStatement.executeUpdate("insert into registration_data (username,email,password,phone) values('"+uname+"','"+email+"','"+pass+"','"+phone+"')");
                connection.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(panel1,e.getMessage());
            }
        }
    }

    public void firstDatabase()
    {

        try
        {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM registration_data LIMIT 1");

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }
    }
    public void lastDatabase()
    {

        try
        {
            Connection connection = DriverManager.getConnection(url, username, pass1);
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from registration_data ORDER BY username DESC LIMIT 1;");

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }
    }

    public void clearAll()
    {
        textEmail.setText("");
        textUser.setText("");
        textPass.setText("");
        textPhone.setText("");
        textConfirmPass.setText("");
    }
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/javadb";
        String username="root";
        String pass1="root";



        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Class Name sucess");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, pass1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        UserRegistration ur = new UserRegistration();
    }
}
