package airline_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener {

    public Home() {
        // frame create
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);// set size__full screen

        // add image on this frame
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/front.jpg"));
        JLabel image = new JLabel(i);
        image.setBounds(0, 0, 1600, 800); // 1600,800=full screen
        add(image);

        // add text
        JLabel h1 = new JLabel("WELCOME BANGLADESH AIRLINE");
        h1.setBounds(450, 30, 1000, 60);
        image.add(h1);// h1 text is add on the image of this frame
        h1.setForeground(Color.RED);//
        h1.setFont(new Font("Tahoma", Font.BOLD, 36));// 36=FONT SIZE

        // add menuber
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar); // ✅ JFrame-এর নিচে add করলাম
        JMenu details = new JMenu("DETAILS"); // ✅ এইভাবে মেনুর নাম দিতে হবে
        menubar.add(details); // ✅ মেনুবারে যোগ করলাম

        // add 5 menuitem in menuber
        JMenuItem fd = new JMenuItem("Flight Details");
        fd.addActionListener(this);
        details.add(fd);

        JMenuItem cd = new JMenuItem("Add Customer Details");
        cd.addActionListener(this);
        details.add(cd);

        JMenuItem bf = new JMenuItem("Book Flight");
        bf.addActionListener(this);
        details.add(bf);

        JMenuItem jd = new JMenuItem("Journey Details");
        jd.addActionListener(this);
        details.add(jd);

        JMenuItem tc = new JMenuItem("Cancel Ticket");
        tc.addActionListener(this);
        details.add(tc);

        ////...................///
        //add another menuber and menu_item
        JMenu ticket = new JMenu("TICKET"); // ✅ এইভাবে মেনুর নাম দিতে হবে
        ticket.addActionListener(this);
        menubar.add(ticket); // ✅ মেনুবারে যোগ করলাম

        JMenuItem bp = new JMenuItem("Boarding_pass");
        bp.addActionListener(this);
        ticket.add(bp);
        /////-----/////

        /////............................./////
        setVisible(true);// it always last line
    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();//collect command from menuber

        if (text.equals("Add Customer Details")) {
            //open add customer class
            new add_customer();
        } else if (text.equals("Flight Details")) {
            //open flight info
            new flight_info();
        } else if (text.equals("Book Flight")) {
            //open flight info
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            //open flight info
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            //open flight info
            new Cancel();
        } else if (text.equals("Boarding_pass")) {
            new BoardingPass();
        }

    }

    public static void main(String[] args) {
        new Home();

    }

}
