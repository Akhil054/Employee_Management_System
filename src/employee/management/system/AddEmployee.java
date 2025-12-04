package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// JFrame in java Swing used for GUI purposes

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    // Allowing user for input in boxes
    JTextField tname, tfname, taddress, tphone, taddhar, temail, tsalary, tdesignation;

    // Provide a label on screen..
    JLabel tempid;

    // For Date Picker
    JDateChooser tdob;

    // For Drop Down
    JComboBox BoxEducation;

    JButton add,back;

    AddEmployee(){

        // Background Color is set
        getContentPane().setBackground(new Color(160,255,188));

        // Creates heading text and positions it on frame.
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,25));
        add(heading);


        JLabel name = new JLabel("Name - ");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(name);

        // Creates a textbox to type name
        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);


        JLabel fname = new JLabel("Fathers Name - ");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);


        JLabel dob = new JLabel("Date of Birth  ");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(dob);

        //Calendar
        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);



        JLabel salary = new JLabel("Salary - ");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);


        JLabel address = new JLabel("Address - ");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);


        JLabel phone = new JLabel("Phone - ");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);


        JLabel email = new JLabel("Email - ");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);


        JLabel Education = new JLabel("Highst Education - ");
        Education.setBounds(400,300,150,30);
        Education.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(Education);

       // DropDown - JComboBox
        String items[] = {"BBA","B.Tech","BCA","BSC","B.COM","MBA","MA","M.TECH","MSC","PHD"};
        BoxEducation = new JComboBox(items);
        BoxEducation.setBackground(new Color(177,252,197));
        BoxEducation.setBounds(600,300,150,30);
        add(BoxEducation);


        JLabel Addhar = new JLabel("Addhar No - ");
        Addhar.setBounds(400,350,150,30);
        Addhar.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(Addhar);

        taddhar = new JTextField();
        taddhar.setBounds(600,350,150,30);
        taddhar.setBackground(new Color(177,252,197));
        add(taddhar);


        JLabel EmpID = new JLabel("EmpID - ");
        EmpID.setBounds(50,400,150,30);
        EmpID.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(EmpID);

        // Random number will store into tempisd
        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setBackground(new Color(177,252,197));
        tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);


        JLabel Designation = new JLabel("Designation  ");
        Designation.setBounds(50,350,150,30);
        Designation.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(Designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        back = new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);   // to listen the click of button or action of them
        add(back);

        add = new JButton("ADD");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);



        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == add){

            // The data we are gonna pass in text field is going to come here & .getText() is used for extracted  & getting store into DB
            String name = tname.getText();
            String fname = tfname.getText();

            // extracted the date / textfields
            String dob = ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String addhar = taddhar.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();

            // taken as String coz drop down is of string type
            String education = (String) BoxEducation.getSelectedItem();

            String designation = tdesignation.getText();
            String empId = tempid.getText();


            //passing the data into db
            try{

                Conn c = new Conn();  // --> object created of conn class
                
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+addhar+"','"+empId+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
                setVisible(false);  // employee screen closed
                new Home();
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {

        new AddEmployee();
    }


}
