package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice choiceEmp;

    JButton searchbtn, print, update, back;

    ViewEmployee() {

        // 🔹 Frame settings
        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 131, 122));

        // 🔹 Label
        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(20, 20, 200, 25);
        search.setFont(new Font("Arial", Font.BOLD, 14));
        add(search);

        // 🔹 Dropdown
        choiceEmp = new Choice();
        choiceEmp.setBounds(230, 20, 150, 25);
        add(choiceEmp);

        // 🔹 Fetch Employee IDs
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                choiceEmp.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 🔹 Table
        table = new JTable();
        table.setRowHeight(25);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 120, 900, 550);
        add(jp);

        // 🔹 Buttons
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 80, 90, 25);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120, 80, 90, 25);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 80, 90, 25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 80, 90, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    // 🔹 Event Handling
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchbtn) {
            String query = "SELECT * FROM employee WHERE empId = '" +
                    choiceEmp.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        else if (e.getSource() == update) {
            setVisible(false);
             new UpdateEmployee(choiceEmp.getSelectedItem());   //sending an emp id to update page
        }

        else if (e.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
