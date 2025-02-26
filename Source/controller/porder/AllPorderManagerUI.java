package controller.porder;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import controller.main.BackendOrderManagement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Employee;
import model.Customer;
import model.Porder;
import java.awt.Font;

public class AllPorderManagerUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField rose;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField lavander;
    private JLabel lblNewLabel_5;
    private JTextField babysbreath;
    private JLabel lblNewLabel_6;
    private JTextField deleteId;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private static Customer customer = (Customer) Tool.read("customer.txt");
    private static Employee employee = (Employee) Tool.read("employee.txt");
    private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();
    private JLabel lblNewLabel_7;
    private JTextField updateId;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JLabel lblNewLabel_2;
    private JScrollPane scrollPane;
    private JTable table;
    private JTextField recipient;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AllPorderManagerUI frame = new AllPorderManagerUI();
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
    public AllPorderManagerUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 613, 428);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        rose = new JTextField();
        rose.setBounds(61, 361, 70, 21);
        rose.setColumns(10);
        contentPane.add(rose);

        lblNewLabel_3 = new JLabel("鼓");
        lblNewLabel_3.setBounds(0, 365, 52, 15);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("吉他");
        lblNewLabel_4.setBounds(0, 300, 57, 15);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_7 = new JLabel("訂單編號");
        lblNewLabel_7.setBounds(0, 246, 57, 15);
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_3_1 = new JLabel("送貨日期");
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1.setBounds(139, 308, 57, 15);
        contentPane.add(lblNewLabel_3_1);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("y-M-d");
        dateChooser.setBounds(202, 297, 90, 26);
        contentPane.add(dateChooser);

        updateId = new JTextField();
        updateId.setBounds(60, 243, 232, 21);
        updateId.setColumns(10);
        contentPane.add(updateId);

        lavander = new JTextField();
        lavander.setBounds(61, 297, 70, 21);
        lavander.setColumns(10);
        contentPane.add(lavander);

        lblNewLabel_5 = new JLabel("貝斯");
        lblNewLabel_5.setBounds(0, 334, 56, 15);
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_5);

        babysbreath = new JTextField();
        babysbreath.setBounds(62, 330, 69, 21);
        babysbreath.setColumns(10);
        contentPane.add(babysbreath);

        lblNewLabel_6 = new JLabel("訂單編號");
        lblNewLabel_6.setBounds(297, 250, 52, 15);
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_6);

        deleteId = new JTextField();
        deleteId.setBounds(357, 246, 232, 21);
        deleteId.setColumns(10);
        contentPane.add(deleteId);

        btnNewButton = new JButton("查詢");
        btnNewButton.setBounds(502, 180, 85, 23);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Using the JTable now
            	
            	List<Porder> orders = porderserviceimpl.findAllPorder();
                updateTableWithOrders(orders);
            	
            	
            }
        });
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("修改");
        btnNewButton_1.setBounds(207, 360, 85, 23);
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Date date = dateChooser.getDate();
                String order_no = updateId.getText();
                String Recipient = recipient.getText();
                int Rose = Integer.parseInt(rose.getText());
                int Lavander = Integer.parseInt(lavander.getText());
                int Babysbreath = Integer.parseInt(babysbreath.getText());
                String Delivery_Date = new SimpleDateFormat("yyyy-MM-dd").format(date);
                porderserviceimpl.updatePorder(Recipient, Delivery_Date, Lavander, Babysbreath, Rose, order_no);
                if (porderserviceimpl != null) {
                    JOptionPane.showMessageDialog(null, "資料修改完成");
                } else {
                    JOptionPane.showMessageDialog(null, "資料修改失敗");
                }
            }
        });
        contentPane.add(btnNewButton_1);

        btnNewButton_2 = new JButton("刪除");
        btnNewButton_2.setBounds(502, 277, 85, 23);
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String order_no = deleteId.getText();
                porderserviceimpl.deletePorderByOrderNo(order_no);
                if (porderserviceimpl != null) {
                    JOptionPane.showMessageDialog(null, "資料刪除完成");
                } else {
                    JOptionPane.showMessageDialog(null, "資料刪除失敗");
                }
            }
        });
        contentPane.add(btnNewButton_2);

        panel = new JPanel();
        panel.setBounds(297, 213, 290, 29);
        panel.setBackground(new Color(128, 128, 255));
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel_2 = new JLabel("訂單刪除");
        lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel_2.setBounds(6, 6, 52, 16);
        panel.add(lblNewLabel_2);

        panel_1 = new JPanel();
        panel_1.setBounds(0, 211, 293, 29);
        panel_1.setBackground(new Color(128, 128, 255));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("訂單修改");
        lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel_1.setBounds(6, 6, 52, 16);
        panel_1.add(lblNewLabel_1);

        panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 587, 29);
        panel_2.setBackground(new Color(128, 128, 255));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("訂單查詢");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 12));
        lblNewLabel.setBounds(6, 6, 52, 16);
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
        //model.setColumnIdentifiers(new String[]{"訂單編號", "收件人", "鼓", "吉他", "貝斯", "送貨日期"});
        table.setModel(model);

        JLabel lblNewLabel_3_2 = new JLabel("收件人");
        lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_2.setBounds(0, 271, 46, 15);
        contentPane.add(lblNewLabel_3_2);

        recipient = new JTextField();
        recipient.setColumns(10);
        recipient.setBounds(59, 269, 233, 21);
        contentPane.add(recipient);

        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	BackendOrderManagement bomui = new BackendOrderManagement();
            	bomui.setVisible(true);
                dispose();
            }
        });
    }

    // Update the JTable with order data
    private void updateTable(String[][] orderData) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        for (String[] order : orderData) {
            model.addRow(order); // Add new rows
        }
    }
    private void updateTableWithOrders(List<Porder> orders) {
        // Assuming `tableModel` is a DefaultTableModel object linked to your JTable
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0); // Clear existing rows
        tableModel.setColumnIdentifiers(new String[]{"訂單編號","客戶名稱", "收件人","訂單日期","送貨日期", "吉他", "貝斯", "鼓"});
        for (Porder order : orders) {
            tableModel.addRow(new Object[]{
                order.getOrder_no(),
                order.getName(),
                order.getRecipient(),
                order.getOrder_date(),
                order.getDelivery_date(),
                order.getLavender(),
                order.getBabysbreath(),
                order.getRose(),
                (order.getLavender() * 99 + order.getBabysbreath() * 199 + order.getRose() * 299)
            });
        }
    }
}
