package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField teducation, tfname, taddress, tphone, temail, tsalary, tdesignation;
    JLabel tempid;
    JButton add, back;
    String number;

    // receiving the empid
    UpdateEmployee(String number) {

        this.number = number;

        // ✅ FIX 1: setLayout BEFORE adding components
        setLayout(null);
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        tname.setOpaque(true); // ✅ FIX 2
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 180, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        add(teducation);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        add(tdesignation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setOpaque(true); // ✅ FIX 2
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); // ✅ FIX 3
        tempid.setForeground(Color.RED);
        add(tempid);

        // DB fetch (UNCHANGED)
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '" + number + "'";
            ResultSet rs = c.statement.executeQuery(query);

            if (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                taddress.setText(rs.getString("address"));
                tsalary.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                taadhar.setText(rs.getString("addhar")); // ✅ FIXED
                tempid.setText(rs.getString("empId"));
                tdesignation.setText(rs.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("UPDATE");
        add.setBounds(450, 550, 150, 40);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            try {
                Conn c = new Conn();
                String query = "update employee set fname='" + tfname.getText() +
                        "', salary='" + tsalary.getText() +
                        "', address='" + taddress.getText() +
                        "', phone='" + tphone.getText() +
                        "', email='" + temail.getText() +
                        "', education='" + teducation.getText() +
                        "', designation='" + tdesignation.getText() +
                        "' where empId='" + number + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("101"); // ✅ FIX 4
    }
}
