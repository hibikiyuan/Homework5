package controller.employee;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.EmployeeServiceImpl;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.main.BackendAdmUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Employee;
import model.Customer;
import model.Porder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EmployeeManagerUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField emp_password;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField emp_name;
    private JLabel lblNewLabel_5;
    private JTextField emp_username;
    private JLabel lblNewLabel_6;
    private JTextField deleteId;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private static Customer customer = (Customer) Tool.read("customer.txt");
    private static EmployeeServiceImpl employeeserviceimpl = new EmployeeServiceImpl();
    private JLabel lblNewLabel_7;
    private JTextField updateId;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JLabel lblNewLabel_2;
    private JScrollPane scrollPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmployeeManagerUI frame = new EmployeeManagerUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public EmployeeManagerUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 613, 428);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        emp_password = new JTextField();
        emp_password.setBounds(61, 327, 231, 21);
        emp_password.setColumns(10);
        contentPane.add(emp_password);

        lblNewLabel_3 = new JLabel("密碼");
        lblNewLabel_3.setBounds(20, 331, 46, 15);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("姓名");
        lblNewLabel_4.setBounds(12, 273, 46, 15);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_7 = new JLabel("員工編號");
        lblNewLabel_7.setBounds(0, 246, 57, 15);
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_3_1 = new JLabel("角色");
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1.setBounds(0, 362, 57, 15);
        contentPane.add(lblNewLabel_3_1);

        updateId = new JTextField();
        updateId.setBounds(60, 243, 232, 21);
        updateId.setColumns(10);
        contentPane.add(updateId);

        emp_name = new JTextField();
        emp_name.setBounds(61, 270, 231, 21);
        emp_name.setColumns(10);
        contentPane.add(emp_name);

        lblNewLabel_5 = new JLabel("帳號");
        lblNewLabel_5.setBounds(9, 302, 46, 15);
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_5);

        emp_username = new JTextField();
        emp_username.setBounds(61, 298, 231, 21);
        emp_username.setColumns(10);
        contentPane.add(emp_username);

        lblNewLabel_6 = new JLabel("員工編號");
        lblNewLabel_6.setBounds(297, 250, 52, 15);
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_6);

        deleteId = new JTextField();
        deleteId.setBounds(357, 246, 227, 21);
        deleteId.setColumns(10);
        contentPane.add(deleteId);

        

        panel = new JPanel();
        panel.setBounds(297, 211, 287, 29);
        panel.setBackground(new Color(128, 128, 255));
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel_2 = new JLabel("員工資料刪除");
        lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel_2.setBounds(6, 6, 110, 16);
        panel.add(lblNewLabel_2);

        panel_1 = new JPanel();
        panel_1.setBounds(0, 211, 292, 29);
        panel_1.setBackground(new Color(128, 128, 255));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("員工資料修改");
        lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel_1.setBounds(6, 6, 86, 16);
        panel_1.add(lblNewLabel_1);

        panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 587, 29);
        panel_2.setBackground(new Color(128, 128, 255));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("員工資料查詢");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel.setBounds(6, 6, 125, 16);
        panel_2.add(lblNewLabel);

        btnNewButton_3 = new JButton("回主選單");
        btnNewButton_3.setBounds(467, 4, 114, 23);
        panel_2.add(btnNewButton_3);

        // Scroll pane for the JTable
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 34, 586, 134);
        contentPane.add(scrollPane);

        // JTable for displaying orders
        table = new JTable();
        scrollPane.setViewportView(table);

        // Setting default column names for the JTable
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        
        JComboBox role = new JComboBox();
        role.setModel(new DefaultComboBoxModel(new String[] {"admin", "staff"}));
        role.setBounds(67, 358, 82, 23);
        contentPane.add(role);

        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	BackendAdmUI baui = new BackendAdmUI();
            	baui.setVisible(true);
                dispose();
            }
        });
        
        btnNewButton = new JButton("查詢");
        btnNewButton.setBounds(502, 180, 85, 23);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Using the JTable now
            	List<Employee> emploies = employeeserviceimpl.findAllEmployee();
                updateTableWithOrders(emploies);
            }
        });
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("修改");
        btnNewButton_1.setBounds(207, 358, 85, 23);
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Emp_id = Integer.parseInt(updateId.getText());
                String Emp_name = emp_name.getText();
                String Emp_username = emp_username.getText();
                String Emp_password = emp_password.getText();
                String Role = role.getSelectedItem().toString();
                employeeserviceimpl.updateEmployee(Emp_name, Emp_username, Emp_password, Role, Emp_id);
                if (employeeserviceimpl != null) {
                    JOptionPane.showMessageDialog(null, "資料修改完成");
                } else {
                    JOptionPane.showMessageDialog(null, "資料修改失敗");
                }
            }
        });
        contentPane.add(btnNewButton_1);

        btnNewButton_2 = new JButton("刪除");
        btnNewButton_2.setBounds(499, 273, 85, 23);
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id = Integer.parseInt(deleteId.getText());
                employeeserviceimpl.deleteEmployeeById(id);
                if (employeeserviceimpl != null) {
                    JOptionPane.showMessageDialog(null, "資料刪除完成");
                } else {
                    JOptionPane.showMessageDialog(null, "資料刪除失敗");
                }
            }
        });
        contentPane.add(btnNewButton_2);
    }

    // Update the JTable with order data
    private void updateTable(String[][] orderData) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        for (String[] order : orderData) {
            model.addRow(order); // Add new rows
        }
    }
    private void updateTableWithOrders(List<Employee> emps) {
        // Assuming `tableModel` is a DefaultTableModel object linked to your JTable
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0); // Clear existing rows
        tableModel.setColumnIdentifiers(new String[]{"Id","員工名稱", "員工帳號","員工密碼","員工角色"});
        for (Employee emp : emps) {
            tableModel.addRow(new Object[]{
            		emp.getId(),
            		emp.getEmp_name(),
            		emp.getEmp_username(),
            		emp.getEmp_password(),
            		emp.getRole()
            });
        }
    }
}
