import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P11 extends JFrame{
    private JTable table1;
    private JPanel panel1;
    DefaultTableModel defaultTableModel;
    String url = "jdbc:mysql://localhost:3306/test";
    String username="root";
    String pass1="root";
    P11()
    {
        setVisible(true);
        setSize(300,400);
        setContentPane(panel1);
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Product");
        defaultTableModel.addColumn("Price");
        table1.setModel(defaultTableModel);
        table1.setRowHeight(20);
        showTable();

    }
    public void showTable()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }

        try
        {
            Connection connection1= DriverManager.getConnection(url,username,pass1);
            Statement statement = connection1.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products");

            while (resultSet.next()) {
                String s1;
                String s2;
                s1 = resultSet.getString(1);
                s2 = resultSet.getString(2);
                defaultTableModel.addRow(new Object[]{s1, s2});
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(panel1,e.getMessage());
        }
    }

    public static void main(String[] args) {
        new P11();
    }

}
