package util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class OrderAnalysisChart {
	
	private static Connection conn=DbConnection.getDb();
	
    public static void main(String[] args) {
        
    }
    
    public void salesOrderAnalysis() {
    	SwingUtilities.invokeLater(() -> {
            try {
                // Query data from the `porder` table
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT NAME, SUM(GUITAR) AS GUITAR, SUM(BASS) AS BASS, SUM(DRUM) AS DRUM FROM porder GROUP BY NAME");

                // Create a dataset for the chart
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                // Process the data and populate the dataset
                while (resultSet.next()) {
                    //String orderNo = resultSet.getString("order_no");
                	String name = resultSet.getString("name");
                    int guitarCount = resultSet.getInt("guitar");
                    int bassCount = resultSet.getInt("bass");
                    int drumCount = resultSet.getInt("drum");

                    // Add data to dataset
                    dataset.addValue(guitarCount, "Guitar", name);
                    dataset.addValue(bassCount, "Bass", name);
                    dataset.addValue(drumCount, "Drum", name);
                }

                // Close the database connection
                conn.close();

                // Create the chart
                JFreeChart barChart = ChartFactory.createBarChart(
                        "Instrument Order Analysis",  // Chart title
                        "Order No",                  // X-axis label
                        "Quantity",                  // Y-axis label
                        dataset,                     // Dataset
                        PlotOrientation.VERTICAL,    // Orientation
                        true,                        // Include legend
                        true,                        // Tooltips
                        false                        // URLs
                );

                // Display the chart in a panel
                ChartPanel chartPanel = new ChartPanel(barChart);
                chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(chartPanel);
                frame.pack();
                frame.setVisible(true);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}

