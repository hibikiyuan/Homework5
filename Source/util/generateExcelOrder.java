package util;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Porder;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class generateExcelOrder {
	int qtyTotal, sum;
	public void generateExcelOrder(Porder porder) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Order");
	    
	    // 創建邊框樣式
        CellStyle style = workbook.createCellStyle();
        BorderStyle borderStyle = BorderStyle.THIN; // 邊框樣式：細邊框
        // 設定文字置中樣式
        style.setAlignment(HorizontalAlignment.CENTER);
	    style.setVerticalAlignment(VerticalAlignment.CENTER);
	    
        // 設置單元格四個邊的邊框
        //style.setBorderTop(borderStyle);
        style.setBorderBottom(borderStyle);
        //style.setBorderLeft(borderStyle);
        //style.setBorderRight(borderStyle);
        
        
        // 標題 合併儲存格 (起始列, 結束列, 起始行, 結束行)
	    CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 3);
	    sheet.addMergedRegion(cellRangeAddress);
	    // Create header row
	    Row title = sheet.createRow(0);
	    title.createCell(0).setCellStyle(style);
	    title.createCell(0).setCellValue("========樂器行訂單明細========");
	    Row name = sheet.createRow(1);
	    name.createCell(0).setCellValue("客戶名稱");
	    name.createCell(1).setCellValue(porder.getName());
	    Row orderdate = sheet.createRow(2);
	    orderdate.createCell(0).setCellValue("訂購日期");
	    orderdate.createCell(1).setCellValue(timeStamp);
	    Row orderrecipient = sheet.createRow(3);
	    orderrecipient.createCell(0).setCellValue("收件人");
	    orderrecipient.createCell(1).setCellValue(porder.getRecipient());
	    Row getdate = sheet.createRow(4);
	    getdate.createCell(0).setCellValue("送達日期");
	    getdate.createCell(1).setCellValue(porder.getDelivery_date());
	    
	    Row header = sheet.createRow(5);
	    Cell cell = header.createCell(0);
	    header.createCell(0).setCellValue("項目");
	    cell.setCellStyle(style);
	    Cell cell1 = header.createCell(1);
	    header.createCell(1).setCellValue("數量");
	    cell1.setCellStyle(style);
	    Cell cell2 = header.createCell(2);
	    header.createCell(2).setCellValue("價格");
	    cell2.setCellStyle(style);
	    Cell cell3 = header.createCell(3);
	    header.createCell(3).setCellValue("小計");
	    cell3.setCellStyle(style);
	    
	    // Add the order items to the sheet
	    int rowIndex = 6;
	    createOrderRow(sheet, rowIndex++, "吉他", porder.getLavender(), 99);
	    createOrderRow(sheet, rowIndex++, "貝斯", porder.getBabysbreath(), 199);
	    createOrderRow(sheet, rowIndex++, "鼓", porder.getRose(), 299);
	    
	    Row total = sheet.createRow(9);
	    total.createCell(0).setCellValue("總計");
	    total.createCell(1).setCellValue(qtyTotal);
	    total.createCell(3).setCellValue(sum);

	    // Write to a file
	    FileOutputStream fileOut = new FileOutputStream(new File("Order_" + porder.getName() + ".xlsx"));
	    workbook.write(fileOut);
	    fileOut.close();
	    workbook.close();
	}

	private void createOrderRow(Sheet sheet, int rowIndex, String item, int quantity, int price) {
	    Row row = sheet.createRow(rowIndex);
	    row.createCell(0).setCellValue(item);
	    row.createCell(1).setCellValue(quantity);
	    qtyTotal+=quantity;
	    row.createCell(2).setCellValue(price);
	    row.createCell(3).setCellValue(quantity * price);
	    sum+=quantity * price;
	}
}
