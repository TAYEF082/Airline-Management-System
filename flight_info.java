package airline_management_system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class flight_info extends JFrame {

    public flight_info() {
        // make frame
        setSize(800, 500);
        setLocation(400, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        //make 2d array for store flight info data from database

        String[][] data = new String[20][4];
        String[] columnNames = { "Flight Code", "Flight Name", "Source", "Destination" };

        int row = 0;

        try {
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("SELECT * FROM flight");//'rs' store flight info data from database

            while (rs.next()) {
                data[row][0] = rs.getString("f_code");
                data[row][1] = rs.getString("f_name");
                data[row][2] = rs.getString("source");
                data[row][3] = rs.getString("destination");
                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//
        //make a table for show data
        JTable jt = new JTable(data, columnNames);//এটা একটি খালি টেবিল তৈরি করে, যেটাতে পরে ডেটা বসানো হবে। 
        JScrollPane sp = new JScrollPane(jt);///JTable-কে JScrollPane-এর ভেতরে প্যাক করা হয়েছে, যাতে টেবিল বড় হয়ে গেলে স্ক্রল করে দেখা যায়।
        sp.setBounds(40, 80, 700, 400);
        add(sp);//ok
        
        
        //write a text
        JLabel l44 = new JLabel("Flight info");
        l44.setBounds(40, 20, 150, 30);
        l44.setFont(new Font("Tahoma", Font.ITALIC, 25));
        l44.setForeground(Color.BLACK);
        add(l44);

        

        setVisible(true);
    }

    public static void main(String[] args) {
        new flight_info();
    }

}
