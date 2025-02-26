package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Customer;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;
import util.WordOrderForm;
import util.generateExcelOrder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileOutputStream;

public class addOrder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField payment;
	private static Customer member=(Customer)Tool.read("customer.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private Integer LCB, BCB, RCB;
	Tool t=new Tool();
	Porder porder = new Porder();
	private JTextField recipient;
	JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addOrder frame = new addOrder();
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
	public addOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setForeground(new Color(204, 204, 204));
		panel.setBounds(6, 6, 465, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("樂器訂購系統");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 455, 40);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("回主選單");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.gotoPorderMain();
				dispose();
			}
		});
		btnNewButton_3.setBounds(341, 13, 114, 23);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 48, 218, 288);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel showMember = new JLabel("New label");
		showMember.setBounds(6, 5, 206, 16);
		panel_1.add(showMember);
		showMember.setText("客戶名稱： "+ member.getName());
		
		JLabel customerName_1_1 = new JLabel("收件人");
		customerName_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		customerName_1_1.setBounds(6, 32, 72, 16);
		panel_1.add(customerName_1_1);
		
		recipient = new JTextField();
		recipient.setColumns(10);
		recipient.setBounds(82, 27, 130, 26);
		panel_1.add(recipient);
		
		JLabel lblNewLabel_2 = new JLabel("預計送達日期");
		lblNewLabel_2.setBounds(6, 63, 94, 19);
		panel_1.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("y-M-d");
		dateChooser.setBounds(92, 63, 120, 26);
		panel_1.add(dateChooser);
		
		JLabel lblNewLabel_1 = new JLabel("吉他($99)");
		lblNewLabel_1.setBounds(6, 103, 113, 16);
		panel_1.add(lblNewLabel_1);
		
		JComboBox lavander = new JComboBox();
		lavander.setBounds(111, 98, 73, 27);
		DefaultComboBoxModel<String> modelL = new DefaultComboBoxModel<>(t.setStringArray());
		lavander.setModel(modelL);
		panel_1.add(lavander);
		
		JLabel lblNewLabel_1_2 = new JLabel("貝斯($199)");
		lblNewLabel_1_2.setBounds(6, 135, 113, 16);
		panel_1.add(lblNewLabel_1_2);
		
		JComboBox babysbreath = new JComboBox();
		babysbreath.setBounds(111, 130, 73, 27);
		DefaultComboBoxModel<String> modelB = new DefaultComboBoxModel<>(t.setStringArray());
		babysbreath.setModel(modelB);
		panel_1.add(babysbreath);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("鼓($299)");
		lblNewLabel_1_2_1.setBounds(6, 167, 113, 16);
		panel_1.add(lblNewLabel_1_2_1);
		
		JComboBox rose = new JComboBox();
		rose.setBounds(111, 162, 73, 27);
		DefaultComboBoxModel<String> modelR = new DefaultComboBoxModel<>(t.setStringArray());
		rose.setModel(modelR);
		panel_1.add(rose);
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(227, 48, 244, 288);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(6, 0, 238, 282);
		panel_1_1.add(output);
		
		JButton printButton = new JButton("3.列印訂單");
		printButton.setBounds(6, 253, 206, 29);
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(output.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "無資料可供列印");
				}
				else {
					try {
						generateExcelOrder geo = new generateExcelOrder();
						geo.generateExcelOrder(porder);
		                JOptionPane.showMessageDialog(null, "Excel 訂單成功產生");
		            } catch (IOException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "產生Excel訂單失敗");
		            }
				}
			}
		});
		panel_1.add(printButton);
		
		JTextArea makechange = new JTextArea();
		makechange.setBounds(233, 348, 226, 115);
		contentPane.add(makechange);
		
		payment = new JTextField();
		payment.setColumns(10);
		payment.setBounds(88, 348, 130, 26);
		contentPane.add(payment);
		
		JLabel customerName_1 = new JLabel("輸入支付金額");
		customerName_1.setBounds(6, 353, 78, 16);
		contentPane.add(customerName_1);
		
		JButton printButton_1_1 = new JButton("4.找零");
		printButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				makechange.setText(t.calChanges(Integer.parseInt(payment.getText())));
			}
		});
		printButton_1_1.setBounds(6, 386, 218, 29);
		contentPane.add(printButton_1_1);
		
		JButton calButton = new JButton("1.費用計算");
		calButton.setBounds(6, 195, 206, 29);
		calButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date date = dateChooser.getDate();
				
				porder.setName(member.getName());
				porder.setRecipient(recipient.getText());
				porder.setDelivery_date(new SimpleDateFormat("yyyy-MM-dd").format(date));
				porder.setLavender(Integer.parseInt(lavander.getSelectedItem().toString()));
				porder.setBabysbreath(Integer.parseInt(babysbreath.getSelectedItem().toString()));
				porder.setRose(Integer.parseInt(rose.getSelectedItem().toString()));
				output.setText(t.show(porder));
			}
		});
		panel_1.add(calButton);
		
		
		JButton calButton_1 = new JButton("2.新增訂單");
		calButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date date = dateChooser.getDate();
				porder.setName(member.getName());
				porder.setRecipient(recipient.getText());
				porder.setDelivery_date(new SimpleDateFormat("yyyy-MM-dd").format(date));
				porder.setLavender(Integer.parseInt(lavander.getSelectedItem().toString()));
				porder.setBabysbreath(Integer.parseInt(babysbreath.getSelectedItem().toString()));
				porder.setRose(Integer.parseInt(rose.getSelectedItem().toString()));
				porderserviceimpl.addPorder(porder);
				if(porderserviceimpl!=null) {
					JOptionPane.showMessageDialog(null, "訂單新增完成");
				}
				
			}
		});
		calButton_1.setBounds(6, 224, 206, 29);
		panel_1.add(calButton_1);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(227, 462, 232, 40);
		contentPane.add(lblNewLabel_3);
		
		JButton clearButton = new JButton("5.清除全部");
		clearButton.setBounds(6, 427, 218, 29);
		contentPane.add(clearButton);
		
		JButton printButton_1 = new JButton("6.離開");
		printButton_1.setBounds(6, 456, 218, 29);
		contentPane.add(printButton_1);
		printButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dateChooser.setCalendar(null);;
				lavander.setSelectedIndex(0);
				babysbreath.setSelectedIndex(0);
				rose.setSelectedIndex(0);
				recipient.setText("");
				output.setText("");
				makechange.setText("");
				payment.setText("");
			}
		});
		
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
						lblNewLabel_3.setText(formattedNow);
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