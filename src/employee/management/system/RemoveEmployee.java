package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete, back;

    RemoveEmployee(){

        // Background panel
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon bgImg2 = new ImageIcon(bgImg);
        JLabel background = new JLabel(bgImg2);
        background.setLayout(null);

        // Use background as main content layer
        setContentPane(background);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,150,30);
        label.setFont(new Font("Tahoma", Font.BOLD,15));
        background.add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        background.add(choiceEMPID);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEMPID.add(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD,15));
        background.add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,200,30);
        background.add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        background.add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,200,30);
        background.add(textPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50,200,100,30);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD,15));
        background.add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,200,30);
        background.add(textEmail);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery(
                    "select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(e -> {
            try{
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(
                        "select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'");
                while (resultSet.next()){
                    textName.setText(resultSet.getString("name"));
                    textPhone.setText(resultSet.getString("phone"));
                    textEmail.setText(resultSet.getString("email"));
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.WHITE);
        delete.setForeground(Color.BLACK);
        delete.addActionListener(this);
        background.add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        background.add(back);

        // Delete icon on right
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(700,80,200,200);
        background.add(img);

        setSize(1120,630);
        setLocation(300,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            try {
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
                setVisible(false);
                new Home();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
