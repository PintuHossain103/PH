package jdbclab;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class JDBCLAB {
    
    static Connection cn; static Statement st; static ResultSet rs;

    public static void main(String[] args) {
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/Raihan","root","");
            
            JFrame jFrame = new JFrame("My Frame");
            jFrame.setBounds(500, 200, 400, 300);
            jFrame.setLayout(new FlowLayout());
            
            JLabel label1 = new JLabel("User ID : ");
            jFrame.add(label1);
            JTextField tx1 = new JTextField(25);
            jFrame.add(tx1);
            JLabel label2 = new JLabel("First Name : ");
            jFrame.add(label2);
            JTextField tx2 = new JTextField(25);
            jFrame.add(tx2);
            JLabel label3 = new JLabel("Middle Name : ");
            jFrame.add(label3);
            JTextField tx3 = new JTextField(25);
            jFrame.add(tx3);
            JLabel label4 = new JLabel("Last Name : ");
            jFrame.add(label4);
            JTextField tx4 = new JTextField(25);
            jFrame.add(tx4);
            JLabel label5 = new JLabel("Email Account : ");
            jFrame.add(label5);
            JTextField tx5 = new JTextField(25);
            jFrame.add(tx5);
            JLabel label6 = new JLabel("Mobile No : ");
            jFrame.add(label6);
            JTextField tx6 = new JTextField(25);
            jFrame.add(tx6);
            
            JButton button1 = new JButton("Insert");
            jFrame.add(button1);
            JButton button2 = new JButton("Update");
            jFrame.add(button2);
            JButton button3 = new JButton("Delete");
            jFrame.add(button3);
            JButton button4 = new JButton("First");
            jFrame.add(button4);
            JButton button5 = new JButton("Next");
            jFrame.add(button5);
            JButton button6 = new JButton("Previous");
            jFrame.add(button6);
            JButton button7 = new JButton("Last");
            jFrame.add(button7);
            
            st = (Statement) cn.createStatement();
            rs = st.executeQuery("SELECT * FROM `persondetails`");;
            
            button1.addActionListener((e) -> {
                try {
                    st = (Statement) cn.createStatement();
                    String id = tx1.getText();
                    String fName = tx2.getText();
                    String mName = tx3.getText();
                    String lName = tx4.getText();
                    String mail = tx5.getText();
                    String phone = tx6.getText();
                    st.execute("INSERT INTO `persondetails` (`ID`, `FirstName`, `MiddleName`, `LastName`, `EmailAccount`, `MoileNo`) VALUES ('"+id+"', '"+fName+"', '"+mName+"', '"+lName+"', '"+mail+"', '"+phone+"')");
                    rs = st.executeQuery("SELECT * FROM `persondetails`");
                    System.out.println("Insertion successful..!!!");
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCLAB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            button2.addActionListener((e) -> {
                try {
                    st = (Statement) cn.createStatement();
                    String id = tx1.getText();
                    String fName = tx2.getText();
                    String mName = tx3.getText();
                    String lName = tx4.getText();
                    String mail = tx5.getText();
                    String phone = tx6.getText();
                    st.execute("UPDATE `persondetails` SET `FirstName`='"+fName+"',`MiddleName`='"+mName+"',`LastName`='"+lName+"',`EmailAccount`='"+mail+"',`MoileNo`='"+phone+"' WHERE `ID`='"+id+"'");
                    rs = st.executeQuery("SELECT * FROM `persondetails`");
                    System.out.println("Updating successful..!!!");
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCLAB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            button3.addActionListener((e) -> {
                try {
                    st = (Statement) cn.createStatement();
                    String id = tx1.getText();
                    st.execute("DELETE FROM `persondetails` WHERE `ID`='"+id+"'");
                    rs = st.executeQuery("SELECT * FROM `persondetails`");
                    if (rs.next()) {
                        tx1.setText(rs.getString(1));
                        tx2.setText(rs.getString(2));
                        tx3.setText(rs.getString(3));
                        tx4.setText(rs.getString(4));
                        tx5.setText(rs.getString(5));
                        tx6.setText(rs.getString(6));
                    } else {
                        JOptionPane.showMessageDialog(null, "This is the end of the Table");
                    }
                    System.out.println("Deletion successful..!!!");
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCLAB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            button4.addActionListener((e) -> {
                try {
                    if (rs.first()) {
                        tx1.setText(rs.getString(1));
                        tx2.setText(rs.getString(2));
                        tx3.setText(rs.getString(3));
                        tx4.setText(rs.getString(4));
                        tx5.setText(rs.getString(5));
                        tx6.setText(rs.getString(6));
                    } else {
                        JOptionPane.showMessageDialog(null, "The Table is null");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCLAB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            button5.addActionListener((e) -> {
                try {
                    if (rs.next()) {
                        tx1.setText(rs.getString(1));
                        tx2.setText(rs.getString(2));
                        tx3.setText(rs.getString(3));
                        tx4.setText(rs.getString(4));
                        tx5.setText(rs.getString(5));
                        tx6.setText(rs.getString(6));
                    } else {
                        JOptionPane.showMessageDialog(null, "This is the end of the Table");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCLAB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            button6.addActionListener((e) -> {
                try {
                    if (rs.previous()) {
                        tx1.setText(rs.getString(1));
                        tx2.setText(rs.getString(2));
                        tx3.setText(rs.getString(3));
                        tx4.setText(rs.getString(4));
                        tx5.setText(rs.getString(5));
                        tx6.setText(rs.getString(6));
                    } else {
                        JOptionPane.showMessageDialog(null, "This is the first of the Table");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCLAB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            button7.addActionListener((e) -> {
                try {
                    if (rs.last()) {
                        tx1.setText(rs.getString(1));
                        tx2.setText(rs.getString(2));
                        tx3.setText(rs.getString(3));
                        tx4.setText(rs.getString(4));
                        tx5.setText(rs.getString(5));
                        tx6.setText(rs.getString(6));
                    } else {
                        JOptionPane.showMessageDialog(null, "The Table is null");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCLAB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCLAB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
