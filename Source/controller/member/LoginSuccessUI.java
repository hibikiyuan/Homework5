package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.AddPorderUI;
import model.Customer;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LoginSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	
	private static Customer member=(Customer)Tool.read("member.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI();
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
	public LoginSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel showMember = new JLabel("New label");
		showMember.setBounds(6, 6, 183, 15);
		contentPane.add(showMember);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(298, 250, 146, 16);
		contentPane.add(lblNewLabel);
		
		showMember.setText(member.getName()+"  歡迎您!");
		
		JButton btnNewButton = new JButton("新增訂單");
		btnNewButton.setBounds(137, 69, 85, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderUI addorder = new AddPorderUI();
				addorder.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改訂單");
		btnNewButton_1.setBounds(137, 104, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("刪除訂單");
		btnNewButton_1_1.setBounds(137, 139, 85, 23);
		contentPane.add(btnNewButton_1_1);
		
		clock();
	}
	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar cal = new GregorianCalendar();
						LocalDateTime now = LocalDateTime.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						String formattedNow = now.format(formatter);
						lblNewLabel.setText(formattedNow);
						sleep(1000);
					}
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		clock.start();
	}
}
