package controller.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Employee;
import service.impl.EmployeeServiceImpl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class AddEmpUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmpUI frame = new AddEmpUI();
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
	public AddEmpUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(203, 76, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(147, 79, 46, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("使用者帳號");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(107, 110, 86, 15);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(203, 107, 96, 21);
		contentPane.add(username);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(147, 146, 46, 15);
		contentPane.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(203, 143, 96, 21);
		contentPane.add(password);
		
		JLabel lblRulnk = new JLabel("角色");
		lblRulnk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRulnk.setBounds(147, 182, 46, 15);
		contentPane.add(lblRulnk);
		
		JComboBox role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {"admin", "staff"}));
		role.setBounds(203, 174, 96, 23);
		contentPane.add(role);
		
		JButton btnNewButton = new JButton("加入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name = name.getText();
				String Username = username.getText();
				String Password = password.getText();
				String Role = role.getSelectedItem().toString();
				Employee employee = new Employee(Name, Username, Password, Role);
				new EmployeeServiceImpl().addEmployee(employee);
				JOptionPane.showMessageDialog(null, "註冊成功!!");
				StaffLoginUI staffloginUI = new StaffLoginUI();
				staffloginUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(214, 207, 85, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 10, 416, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("新增員工");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 10, 416, 29);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BackendAdmUI baui = new BackendAdmUI();
				baui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(331, 26, 85, 23);
		panel.add(btnNewButton_1);
	}
}
