package controller.customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer;
import service.impl.CustomerServiceImpl;
import util.Verification;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 434, 38);
		panel.setBackground(new Color(128, 128, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員註冊");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 38);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("回登入頁面");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI login = new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(320, 15, 114, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(127, 77, 62, 15);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(199, 74, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("會員帳號");
		lblNewLabel_1_1.setBounds(127, 105, 62, 15);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(199, 102, 96, 21);
		username.setColumns(10);
		contentPane.add(username);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼");
		lblNewLabel_1_2.setBounds(127, 134, 62, 15);
		contentPane.add(lblNewLabel_1_2);
		
		password = new JTextField();
		password.setBounds(199, 131, 96, 21);
		password.setColumns(10);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址");
		lblNewLabel_1_3.setBounds(127, 162, 62, 15);
		contentPane.add(lblNewLabel_1_3);
		
		address = new JTextField();
		address.setBounds(199, 159, 96, 21);
		address.setColumns(10);
		contentPane.add(address);
		
		JLabel lblNewLabel_1_5 = new JLabel("手機");
		lblNewLabel_1_5.setBounds(127, 192, 62, 15);
		contentPane.add(lblNewLabel_1_5);
		
		mobile = new JTextField();
		mobile.setBounds(199, 189, 96, 21);
		mobile.setColumns(10);
		contentPane.add(mobile);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Verification v = new Verification();
				boolean CheckReg = v.checkReg(username.getText(), mobile.getText());
				if(CheckReg) {
					String Username = username.getText();

					if(new CustomerServiceImpl().isUsernameBeenUse(Username))
					{
						JOptionPane.showMessageDialog(null, "帳號重複，請重新註冊!!");
					}
					else
					{
						//String Id=id.getText();
						String Name=name.getText();
						String Password=password.getText();
						String Address=address.getText();
						String Mobile=mobile.getText();
						
						Customer member=new Customer(Name,Username,Password,Address,Mobile);
						
						new CustomerServiceImpl().addMember(member);
						JOptionPane.showMessageDialog(null, "註冊成功!!");
						LoginUI loginui=new LoginUI();
						loginui.setVisible(true);
						dispose();
					}
				}
				
				
				
			}
		});
		btnNewButton.setBounds(210, 222, 85, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("需全為英文");
		lblNewLabel_2.setBounds(305, 105, 120, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("提示：09xx...");
		lblNewLabel_2_1.setBounds(305, 192, 120, 15);
		contentPane.add(lblNewLabel_2_1);
	}
}
