package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    //constructor
    Splash(){

        // elements items are kept above this functions

        // The ImageIcon class in Java Swing is an implementation of the Icon interface,
        // primarily used for displaying images within Swing components such as JLabel, JButton, and JMenuItem

        // ClassLoader - loads the (files videos, icons, text) stored inside your project folders.
        // getSystemResources - Finds a file inside your project folder and returns its URL.
        // getScaledInstance - Rezise the images

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICONS/front.gif"));    // getting an images from folder
        Image i2 = i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT); //scaling an image according to window size
        ImageIcon i3 = new ImageIcon(i2);       // we directly can't pass image which is scaled so we created an new ImageIcon
        JLabel image = new JLabel(i3);           //scaled image is saved in JLabel & JLabel is used to display
        image.setBounds(0,0 , 1170,650); // .setBounds is used to set image manually
        add(image);

        setSize(1170,650);
        setLocation(200,50);
        setLayout(null);
        setVisible(true);

        //going to login screen after some seconds so we are using thread concept
        try{
            Thread.sleep(5000);
            setVisible(false);      // frame will not visible after 5 sec
            new Login();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new Splash();
    }

}
