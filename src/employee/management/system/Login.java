package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    // Adding the text fields and buttons globally
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login(){

        // JLabel is used because we are brining image on frame
        // Main use of JLabel is bring the textfield visible on Frame

        JLabel username = new JLabel("User Name - ");      //text written under double quotes will be visible on frame
        username.setBounds(40,20,100,30);   // SetBound is used for getting up the text position
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);


        JLabel password = new JLabel("PassWord");
        password.setBounds(40,70,100,30);
        add(password);

        // Password Fields
        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);


        // Getting the Buttons on Frame & they have declared as globally
        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);      // Setting the bg of button as black
        login.setForeground(Color.black);      // Setting color as white of text
        login.addActionListener(this);
        add(login);


        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);      // Setting the bg of button as black
        back.setForeground(Color.black);      // Setting color as white of text
        back.addActionListener(this);      // used for action performing
        add(back);


        // Adding Icon on Bg
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("ICONS/second.jpg"));
        Image i21 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i21);
        JLabel imgg = new JLabel(i31);
        imgg.setBounds(350,10,600,380);
        add(imgg);


        // Adding Backgorund
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICONS/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);



        // Frame
        setSize(600,300);
        setLocation(450,200);
        setLayout(null);        // by default layout is border layout
        setVisible(true);       // ketp as true coz by default fram visiblity is false..

    }


    // Implements ActionsListener & when we hit the button it will go to ActionEvent e
    @Override
    public void actionPerformed(ActionEvent e) {

        //getSource is used for getting login values
        if(e.getSource() == login){

            // try-catch used coz dealing with db

            try{
                // we have declared username & pass as global coz as we are going to insert values so we have to get those
                // values check with db present or not.. if we have not declare as global we will not able to use them outside of constructor

                String username = tusername.getText();
                String password = tpassword.getText();

                //created obj of conn
                Conn conn = new Conn();

                // Creating an query to check weather the data we have got using getText is same / available  with db or not
                String query = "select * from login where username = '"+ username+"' and password = '"+ password+"'";

                // If data match and stored into resultSet & when we want to match thing from data we use excutequery() mthd
                ResultSet resultSet = conn.statement.executeQuery(query);

                // If data doesn't store in resultSet then frame will close or give an message
                if(resultSet.next()){
                    // .next() will help us to know data has come or not & if data comes the login frame will close & goes to next one..
                    setVisible(false);
                    new Home();     // goes to Home Page
                }
                // if Data is not match it will give an message
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }


            }
            catch (Exception E){
                E.printStackTrace();
            }

        }
        else if (e.getSource() == back) {
            System.exit(200);
        }
    }

    public static void main(String[] args) {
        new Login();

    }


}
