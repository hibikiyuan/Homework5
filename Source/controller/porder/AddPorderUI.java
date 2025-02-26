package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Color;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lavender;
	private JTextField babysbreath;
	private JTextField rose;
	private JButton btnNewButton_1;
	private JPanel panel;
	JDateChooser dateChooser;
	private static Customer member=(Customer)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JTextField delivery_date;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_3;
	private JTextField recipient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("薰衣草");
		lblNewLabel.setBounds(57, 148, 46, 15);
		contentPane.add(lblNewLabel);
		
		lavender = new JTextField();
		lavender.setBounds(118, 145, 96, 21);
		contentPane.add(lavender);
		lavender.setColumns(10);
		
		JLabel lblRam = new JLabel("滿天星");
		lblRam.setBounds(57, 179, 46, 15);
		contentPane.add(lblRam);
		
		babysbreath = new JTextField();
		babysbreath.setColumns(10);
		babysbreath.setBounds(118, 176, 96, 21);
		contentPane.add(babysbreath);
		
		JLabel lblMouse = new JLabel("玫瑰");
		lblMouse.setBounds(225, 148, 46, 15);
		contentPane.add(lblMouse);
		
		rose = new JTextField();
		rose.setColumns(10);
		rose.setBounds(286, 145, 96, 21);
		contentPane.add(rose);
		
		
		btnNewButton_1 = new JButton("回訂單功能頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoPorderMain();
				dispose();
			}
		});
		btnNewButton_1.setBounds(322, 55, 114, 23);
		contentPane.add(btnNewButton_1);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 10, 450, 42);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("新增訂單");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 0, 438, 42);
		panel.add(lblNewLabel_1);
		
		delivery_date = new JTextField();
		delivery_date.setColumns(10);
		delivery_date.setBounds(118, 115, 96, 21);
		contentPane.add(delivery_date);
		
		lblNewLabel_3 = new JLabel("收件人");
		lblNewLabel_3.setBounds(225, 118, 66, 15);
		contentPane.add(lblNewLabel_3);
		
		recipient = new JTextField();
		recipient.setColumns(10);
		recipient.setBounds(286, 115, 96, 21);
		contentPane.add(recipient);
		
		lblNewLabel_2 = new JLabel("送花日期");
		lblNewLabel_2.setBounds(57, 118, 66, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(304, 250, 146, 16);
		contentPane.add(lblNewLabel_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("y-M-d");
		dateChooser.setBounds(0, 84, 214, 26);
		contentPane.add(dateChooser);
		
		JLabel testLabel = new JLabel("New label");
		testLabel.setBounds(62, 215, 197, 16);
		contentPane.add(testLabel);
		
		
		clock();
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Date date = dateChooser.getDate();
				testLabel.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
				
				String Name=member.getName();
				String Delivery_date=delivery_date.getText();
				String Recipient = recipient.getText();
				int Lavander = Integer.parseInt(lavender.getText());
				int Babysbreath = Integer.parseInt(babysbreath.getText());
				int Rose = Integer.parseInt(rose.getText());
				
				Porder p=new Porder(Name,Recipient,Delivery_date,Lavander,Babysbreath,Rose);
				
				porderserviceimpl.addPorder(p);
				
				if(porderserviceimpl!=null) {
					JOptionPane.showMessageDialog(null, "訂單新增完成~");
					Tool.gotoPorderMain();
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(286, 208, 96, 23);
		contentPane.add(btnNewButton);
		
		
		
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
						lblNewLabel_4.setText(formattedNow);
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
