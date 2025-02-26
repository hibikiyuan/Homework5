package controller.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.main.LoginMain;
import controller.porder.PorderMainUI;
import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class StaffLoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffLoginUI frame = new StaffLoginUI();
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
	public StaffLoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(6, 26, 438, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("樂器行員工登入");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 428, 34);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("回上一頁");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginMain lm = new LoginMain();
				lm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(341, 21, 87, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(142, 120, 79, 15);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(233, 117, 96, 21);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(233, 148, 96, 21);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(142, 151, 79, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				Employee emp = new EmployeeServiceImpl().login(Username, Password);
				
				if(emp != null) {
					String role = emp.getRole();
					JOptionPane.showMessageDialog(null, "Hi~\n"+emp.getEmp_name()+" 歡迎您\n您的登入角色是: "+role);
					Tool.save(emp, "employee.txt");
					if(role.equals("admin")) {
						BackendAdmUI admUI = new BackendAdmUI();
						admUI.setVisible(true);
					}
					else {
						BackendOrderManagement empUI = new BackendOrderManagement();
						empUI.setVisible(true);
					}
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "無此帳號，請聯繫系統管理員");
					
				}
			}
		});
		btnNewButton.setBounds(233, 188, 96, 23);
		contentPane.add(btnNewButton);
	}
}