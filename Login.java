// package airline_management_system;
// import java.awt.Color;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.ResultSet;
// import javax.swing.*;//
// public class Login extends JFrame implements ActionListener {
//     JButton r, s, c;
//     JTextField user, pass;// for add BOX
//     public Login() {
//         // make a frame
//         // setVisible(true);///it will be last line
//         setSize(400, 250);// frame size
//         setLocation(600, 250);
//         getContentPane().setBackground(Color.WHITE);// frame color
//         setLayout(null);
//         /*
//          * setLayout(null); মানে তুমি জানিয়ে দিচ্ছো যে
//          * "আমি নিজে প্রতিটি UI কম্পোনেন্টের অবস্থান (position) ও আকার (size) নির্ধারণ
//          * করব।
//          * Java নিজে থেকে কিছু করবে না।"
//          * এটাকে বলে null layout বা absolute positioning।
//          * 
//          * মানে:
//          * 
//          * JLabel, JButton, JTextField ইত্যাদি যখন add করবে, তখন setBounds(x, y, width,
//          * height); দিয়ে হাতে করে অবস্থান ও সাইজ দিতে হবে।
//          * 
//          * Java এর layout manager (যেমন FlowLayout, BorderLayout, GridLayout) কাজ করবে
//          * না।
//          */
//         // add text on login frame
//         JLabel l1 = new JLabel("User_name");
//         l1.setBounds(20, 20, 100, 20);
//         add(l1);
//         JLabel l2 = new JLabel("Password");
//         l2.setBounds(20, 60, 100, 20);
//         add(l2);
//         // add box
//         user = new JTextField();
//         user.setBounds(130, 20, 200, 20);
//         add(user);
//         // Use JPasswordField instead of JTextField for password
//         pass = new JPasswordField();
//         pass.setBounds(130, 60, 200, 20);
//         add(pass);
//         // Button add
//         r = new JButton("RESET");
//         r.setBounds(40, 120, 120, 20);
//         r.addActionListener(this);// reset button performed some action..that are define in actionPerformed method
//         add(r);
//         s = new JButton("SUBMIT");
//         s.setBounds(230, 120, 120, 20);
//         s.addActionListener(this);
//         add(s);
//         c = new JButton("CLOSE");
//         c.setBounds(135, 160, 120, 20);
//         c.addActionListener(this);
//         add(c);
//         /////
//         setVisible(true);// it always write it last line .. so all component are show in frame
//     }
//     public void actionPerformed(ActionEvent ae) {
//         if (ae.getSource() == s) {
//             String name = user.getText();
//             String pasword = pass.getText();
//             try {
//                 conn c = new conn();
//                String query = "select * from login where username = '" + name + "' and password = '" + pasword + "'";
//                 ResultSet rs = c.executeQuery(query);
//                 if (rs.next()) {
//                     System.out.println("valid");
//                 } else {
//                     JOptionPane.showMessageDialog(null, "Invalis username and password");
//                     setVisible(false);
//                 }
//             } catch (Exception c) {
//                 c.printStackTrace();
//             }
//         } else if (ae.getSource() == r) {
//             user.setText("");
//             pass.setText("");
//         } else if (ae.getSource() == c) {
//             setVisible(false);
//         }
//     }
//     public static void main(String[] args) {
//         new Login();
//     }
// }
//CHAT GPT
// Login.java
package airline_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JButton r, s, c;
    JTextField user;
    JPasswordField pass;

    public Login() {
        setSize(400, 250);
        setLocation(600, 250);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("User_name");
        l1.setBounds(20, 20, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(20, 60, 100, 20);
        add(l2);

        user = new JTextField();
        user.setBounds(130, 20, 200, 20);
        add(user);

        pass = new JPasswordField();
        pass.setBounds(130, 60, 200, 20);
        add(pass);

        r = new JButton("RESET");
        r.setBounds(40, 120, 120, 20);
        r.addActionListener(this);
        add(r);

        s = new JButton("SUBMIT");
        s.setBounds(230, 120, 120, 20);
        s.addActionListener(this);
        add(s);

        c = new JButton("CLOSE");
        c.setBounds(135, 160, 120, 20);
        c.addActionListener(this);
        add(c);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == s) {
            String name = user.getText();
            // String password = String.valueOf(pass.getPassword());
            String pasword = new String(((JPasswordField) pass).getPassword());//chat gpt

            try {
                conn c = new conn();
                String query = "SELECT * FROM login WHERE username = '" + name + "' AND password = '" + pasword + "'";
                ResultSet rs = c.s.executeQuery(query);//rs store data from query

                if (rs.next()) {
                    // JOptionPane.showMessageDialog(null, "Login Successful");
                    // setVisible(false);
                   
                     new Home();
                     setVisible(false);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    user.setText("");
                    pass.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == r) {
            user.setText("");
            pass.setText("");
        } else if (ae.getSource() == c) {
            setVisible(false);
        }
        
        
        
        
        
    }

    public static void main(String[] args) {
        new Login();
    }
}
