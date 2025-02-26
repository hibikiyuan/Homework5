package controller.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.employee.EmployeeManagerUI;
import controller.product.ProductManagerUI;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BackendAdmUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackendAdmUI frame = new BackendAdmUI();
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
	public BackendAdmUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("新增員工");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddEmpUI addempUI = new AddEmpUI();
				addempUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(54, 104, 150, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("員工資料維護");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeManagerUI emui = new EmployeeManagerUI();
				emui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(249, 104, 150, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("新增產品");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddProductUI addproductUI = new AddProductUI();
				addproductUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(54, 182, 150, 49);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("產品資料維護");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductManagerUI pdui = new ProductManagerUI();
				pdui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(249, 182, 150, 49);
		contentPane.add(btnNewButton_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 10, 416, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("系統管理員資料維護主頁");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 10, 416, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("回上一頁");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StaffLoginUI sfUI = new StaffLoginUI();
				sfUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(331, 41, 85, 23);
		panel.add(btnNewButton_3);
	}

}
