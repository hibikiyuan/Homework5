package controller.product;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.EmployeeServiceImpl;
import service.impl.PorderServiceImpl;
import service.impl.ProductServiceImpl;
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
import model.Product;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProductManagerUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_4;
    private JTextField product_name;
    private JLabel lblNewLabel_5;
    private JTextField product_price;
    private JLabel lblNewLabel_6;
    private JTextField deleteId;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private static Customer customer = (Customer) Tool.read("customer.txt");
    private static ProductServiceImpl employeeserviceimpl = new ProductServiceImpl();
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
                    ProductManagerUI frame = new ProductManagerUI();
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
    public ProductManagerUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 613, 428);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel_4 = new JLabel("產品名稱");
        lblNewLabel_4.setBounds(0, 305, 76, 15);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_7 = new JLabel("產品編號");
        lblNewLabel_7.setBounds(5, 280, 66, 15);
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_7);

        updateId = new JTextField();
        updateId.setBounds(76, 277, 223, 21);
        updateId.setColumns(10);
        contentPane.add(updateId);

        product_name = new JTextField();
        product_name.setBounds(76, 302, 223, 21);
        product_name.setColumns(10);
        contentPane.add(product_name);

        lblNewLabel_5 = new JLabel("產品價格");
        lblNewLabel_5.setBounds(0, 333, 76, 15);
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_5);

        product_price = new JTextField();
        product_price.setBounds(76, 330, 223, 21);
        product_price.setColumns(10);
        contentPane.add(product_price);

        lblNewLabel_6 = new JLabel("產品編號");
        lblNewLabel_6.setBounds(302, 280, 52, 15);
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_6);

        deleteId = new JTextField();
        deleteId.setBounds(355, 277, 234, 21);
        deleteId.setColumns(10);
        contentPane.add(deleteId);

        

        panel = new JPanel();
        panel.setBounds(302, 245, 287, 29);
        panel.setBackground(new Color(128, 128, 255));
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel_2 = new JLabel("產品資料刪除");
        lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel_2.setBounds(6, 6, 110, 16);
        panel.add(lblNewLabel_2);

        panel_1 = new JPanel();
        panel_1.setBounds(5, 245, 294, 29);
        panel_1.setBackground(new Color(128, 128, 255));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("產品資料修改");
        lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel_1.setBounds(6, 6, 86, 16);
        panel_1.add(lblNewLabel_1);

        panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 587, 29);
        panel_2.setBackground(new Color(128, 128, 255));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("產品資料查詢");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel.setBounds(6, 6, 125, 16);
        panel_2.add(lblNewLabel);

        btnNewButton_3 = new JButton("回主選單");
        btnNewButton_3.setBounds(467, 4, 114, 23);
        panel_2.add(btnNewButton_3);

        // Scroll pane for the JTable
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 34, 586, 168);
        contentPane.add(scrollPane);

        // JTable for displaying orders
        table = new JTable();
        scrollPane.setViewportView(table);

        // Setting default column names for the JTable
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);

        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	BackendAdmUI baui = new BackendAdmUI();
            	baui.setVisible(true);
                dispose();
            }
        });
        
        btnNewButton = new JButton("查詢");
        btnNewButton.setBounds(504, 212, 85, 23);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Using the JTable now
            	List<Product> emploies = employeeserviceimpl.findAllProduct();
                updateTableWithOrders(emploies);
            }
        });
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("修改");
        btnNewButton_1.setBounds(213, 361, 85, 23);
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Emp_id = Integer.parseInt(updateId.getText());
                String Emp_pname = product_name.getText();
                int Emp_pprice = Integer.parseInt(product_price.getText());
                employeeserviceimpl.updateEmployee(Emp_pname, Emp_pprice, Emp_id);
                if (employeeserviceimpl != null) {
                    JOptionPane.showMessageDialog(null, "資料修改完成");
                } else {
                    JOptionPane.showMessageDialog(null, "資料修改失敗");
                }
            }
        });
        contentPane.add(btnNewButton_1);

        btnNewButton_2 = new JButton("刪除");
        btnNewButton_2.setBounds(502, 361, 85, 23);
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id = Integer.parseInt(deleteId.getText());
                employeeserviceimpl.deleteProductById(id);
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
    private void updateTableWithOrders(List<Product> emps) {
        // Assuming `tableModel` is a DefaultTableModel object linked to your JTable
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0); // Clear existing rows
        tableModel.setColumnIdentifiers(new String[]{"Id","產品名稱", "產品價格"});
        for (Product emp : emps) {
            tableModel.addRow(new Object[]{
            		emp.getId(),
            		emp.getProductname(),
            		emp.getPrice()
            });
        }
    }
}
