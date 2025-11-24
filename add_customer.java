
package airline_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;//
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class add_customer extends JFrame implements ActionListener {

    JTextField txname, jnation, jadher, jaddress, jphone;
    JRadioButton jr, jr2;

    public add_customer() {
        // frame make
        setSize(900, 600);
        setLocation(300, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // text add
        JLabel l = new JLabel(" Add Customer Details");
        l.setBounds(270, 20, 500, 35);
        l.setFont(new Font("Tahoma", Font.ITALIC, 32));
        l.setForeground(Color.GREEN);
        add(l);
        ///////
        // add name+box
        JLabel l2 = new JLabel("Name");
        l2.setBounds(60, 90, 150, 25);
        l2.setFont(new Font("Tahoma", Font.ITALIC, 20));
        l2.setForeground(Color.BLUE);
        add(l2);
        // make box
        txname = new JTextField();
        txname.setBounds(230, 90, 150, 25);
        add(txname);

        ///...............///
        // add 2nd name+box
        JLabel l3 = new JLabel("Nationality");
        l3.setBounds(60, 150, 150, 25);
        l3.setFont(new Font("Tahoma", Font.ITALIC, 20));
        l3.setForeground(Color.BLUE);
        add(l3);
        // make box
        jnation = new JTextField();
        jnation.setBounds(230, 150, 150, 25);
        add(jnation);
        ////.////////////////////
        // add 3rd name+box
        JLabel l4 = new JLabel("Aadhar Number");
        l4.setBounds(60, 210, 150, 25);
        l4.setFont(new Font("Tahoma", Font.ITALIC, 20));
        l4.setForeground(Color.BLUE);
        add(l4);
        // make box
        jadher = new JTextField();
        jadher.setBounds(230, 210, 150, 25);
        add(jadher);

        // add 4th name+box
        JLabel l44 = new JLabel("Address");
        l44.setBounds(60, 260, 150, 25);
        l44.setFont(new Font("Tahoma", Font.ITALIC, 20));
        l44.setForeground(Color.BLUE);
        add(l44);
        // make box
        jaddress = new JTextField();
        jaddress.setBounds(230, 260, 150, 25);
        add(jaddress);

        ////////////////////////
        // add 5th name+Button
        JLabel l14 = new JLabel("Gender");
        l14.setBounds(60, 310, 150, 25);
        l14.setFont(new Font("Tahoma", Font.ITALIC, 20));
        l14.setForeground(Color.BLUE);
        add(l14);

        // make radio (circle) button
        jr = new JRadioButton("Male");
        jr.setBounds(230, 310, 100, 25);
        jr.setBackground(Color.WHITE);
        add(jr);
        jr2 = new JRadioButton("Female");
        jr2.setBounds(350, 310, 100, 25);
        jr2.setBackground(Color.WHITE);
        add(jr2);

        ButtonGroup b = new ButtonGroup();// we can not select 2 option(male,female) at a time..so need it
        b.add(jr);
        b.add(jr2);

        // add 6th name+Box
        JLabel l114 = new JLabel("Phone");
        l114.setBounds(60, 360, 150, 25);
        l114.setFont(new Font("Tahoma", Font.ITALIC, 20));
        l114.setForeground(Color.BLUE);
        add(l114);
        // make box
        jphone = new JTextField();
        jphone.setBounds(230, 360, 150, 25);
        add(jphone);

        /////////////////....................../////////////////// 

        // save button
        JButton s = new JButton("SAVE");
        s.setBackground(Color.GREEN);
        s.setForeground(Color.RED);
        s.setBounds(60, 410, 70, 25);
        s.addActionListener(this);// save button add actionlistener..means when i click it..it will perform some
                                  // action
        add(s);

        ////////////////////////////////////////////////
        // add image
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/emp.png"));
        JLabel xx = new JLabel(ii);
        xx.setBounds(550, 90, 200, 400);
        add(xx);
        ////////ok

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // JTextField txname,jnation,jadher,jaddress,jphone;
        // JRadioButton jr,jr2;

        String name = txname.getText();
        String nationality = jnation.getText();
        String phone = jphone.getText();
        String address = jaddress.getText();
        String aadhar = jadher.getText();
        String gender = null;// collect info for added database

        if (jr.isSelected()) {
            gender = "MALE";
        } else {
            gender = "FEMALE";
        } 

        // info are add to database

        try {
            conn con = new conn();
            String query = "INSERT INTO passenger VALUES('" + name + "', '" + nationality + "', '" + phone + "', '"
                    + address + "', '" + aadhar + "', '" + gender + "')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer details added successfully");


            //can added another frame hare


            setVisible(false);
        } catch (Exception x) {
            x.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new add_customer();
    }

}
