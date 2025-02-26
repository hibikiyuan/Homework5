package controller.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.AllPorderManagerUI;
import controller.porder.PorderManagerUI;
import util.OrderAnalysisChart;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BackendOrderManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackendOrderManagement frame = new BackendOrderManagement();
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
	public BackendOrderManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("訂單管理");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllPorderManagerUI allpmui = new AllPorderManagerUI();
				allpmui.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(105, 96, 219, 59);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("產生訂單分析圖表");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				OrderAnalysisChart oac = new OrderAnalysisChart();
				oac.salesOrderAnalysis();
			}
		});
		btnNewButton_1.setBounds(105, 165, 219, 59);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 10, 416, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("訂單管理");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 416, 43);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("回上一頁");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StaffLoginUI stfui = new StaffLoginUI();
				stfui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(331, 40, 85, 23);
		panel.add(btnNewButton_2);
	}
}
