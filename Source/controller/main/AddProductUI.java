package controller.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Product;
import service.impl.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AddProductUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productname;
	private JTextField price;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductUI frame = new AddProductUI();
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
	public AddProductUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("產品名稱");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(119, 127, 82, 15);
		contentPane.add(lblNewLabel);
		
		productname = new JTextField();
		productname.setBounds(216, 124, 96, 21);
		contentPane.add(productname);
		productname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("價格");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(119, 155, 82, 15);
		contentPane.add(lblNewLabel_1);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(216, 152, 96, 21);
		contentPane.add(price);
		
		btnNewButton = new JButton("加入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String ProductName = productname.getText();
				int Price = Integer.valueOf(price.getText());
				
				Product product = new Product(ProductName, Price);
				new ProductServiceImpl().addProduct(product);
				JOptionPane.showMessageDialog(null, "產品新增成功!!");
				//StaffLoginUI staffloginUI = new StaffLoginUI();
				//staffloginUI.setVisible(true);
				//dispose();
			}
		});
		btnNewButton.setBounds(226, 183, 85, 23);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 20, 426, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("產品新增");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 10, 426, 38);
		panel.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BackendAdmUI baui = new BackendAdmUI();
				baui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(341, 35, 85, 23);
		panel.add(btnNewButton_1);
	}
}
