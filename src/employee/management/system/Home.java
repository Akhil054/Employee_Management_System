package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home  extends JFrame {


    Home(){

        //background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICONS/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        // setting an images on frame
        img.setBounds(0,0,1120,630);
        add(img);
        
        //Making an Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,130,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        // img.add(heading) is written in this way.. coz text should visible above image
        img.add(heading);


        // Adding Buttons
        JButton add = new JButton("Add Employee");
        add.setBounds(335,270,150,40);  //setting up pss of button
        add.setForeground(Color.BLACK);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddEmployee();
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(565,270,150,40);  //setting up pss of button
        view.setForeground(Color.BLACK);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);  //setting up pss of button
        rem.setForeground(Color.BLACK);
        rem.setBackground(Color.BLACK);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        img.add(rem);



        setSize(1120,630);
        setVisible(true);
        setLayout(null);
        setLocation(250,100);

    }
    public static void main(String[] args) {

        new Home();

    }


}
