package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import model.Porder;

public class WordOrderForm {
	int sum,subTotal;
	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void replaceText(Porder porder) throws InvalidFormatException, IOException {
		XWPFDocument doc = new XWPFDocument(OPCPackage.open("doc1.docx"));
		for (XWPFParagraph p : doc.getParagraphs()) {
			List<XWPFRun> runs = p.getRuns();
			if (runs != null) {
				for (XWPFRun r : runs) {
					String text = r.getText(0);
					
					if (text != null && text.contains("ono")) {
						text = text.replace("ono", porder.getOrder_no());
						r.setText(text, 0);
					}
					
					if (text != null && text.contains("username")) {
						text = text.replace("username", porder.getName());
						r.setText(text, 0);
					}
					if (text != null && text.contains("recipient")) {
						text = text.replace("recipient", porder.getRecipient());
						r.setText(text, 0);
					}
					if (text != null && text.contains("deliverydate")) {
						text = text.replace("deliverydate", porder.getDelivery_date());
						r.setText(text, 0);
					}
					if(porder.getLavender()>0) {
						if (text != null && text.contains("I1")) {
							text = text.replace("I1", "薰衣草");
							r.setText(text, 0);
						}
						if (text != null && text.contains("Qty1")) {
							text = text.replace("Qty1", String.valueOf(porder.getLavender()));
							r.setText(text, 0);
						}
						if (text != null && text.contains("P1")) {
							text = text.replace("P1", "99");
							r.setText(text, 0);
						}
						if (text != null && text.contains("S1")) {
							int subTotal=porder.getLavender()*99;
							text = text.replace("S1", String.valueOf(subTotal));
							r.setText(text, 0);
						}
					}
					
					if(porder.getBabysbreath()>0) {
						if (text != null && text.contains("I2")) {
							text = text.replace("I2", "滿天星");
							r.setText(text, 0);
						}
						if (text != null && text.contains("Qty2")) {
							text = text.replace("Qty2", String.valueOf(porder.getBabysbreath()));
							r.setText(text, 0);
						}
						if (text != null && text.contains("P2")) {
							text = text.replace("P2", "199");
							r.setText(text, 0);
						}
						if (text != null && text.contains("S2")) {
							int subTotal=porder.getBabysbreath()*199;
							text = text.replace("S2", String.valueOf(subTotal));
							r.setText(text, 0);
						}
					}
					
					if(porder.getRose()>0) {
						if (text != null && text.contains("I3")) {
							text = text.replace("I3", "玫瑰花");
							r.setText(text, 0);
						}
						if (text != null && text.contains("Qty3")) {
							text = text.replace("Qty3", String.valueOf(porder.getRose()));
							r.setText(text, 0);
						}
						if (text != null && text.contains("P3")) {
							text = text.replace("P3", "299");
							r.setText(text, 0);
						}
						if (text != null && text.contains("S3")) {
							int subTotal=porder.getRose()*299;
							text = text.replace("S3", String.valueOf(subTotal));
							r.setText(text, 0);
						}
					}
					
				}
			}
		}
		for (XWPFTable tbl : doc.getTables()) {
			for (XWPFTableRow row : tbl.getRows()) {
				for (XWPFTableCell cell : row.getTableCells()) {
					for (XWPFParagraph p : cell.getParagraphs()) {
						for (XWPFRun r : p.getRuns()) {
							String text = r.getText(0);
							
							if (text != null && text.contains("ono")) {
								text = text.replace("ono", porder.getOrder_no());
								r.setText(text, 0);
							}
							
							if (text != null && text.contains("username")) {
								text = text.replace("username", porder.getName());
								r.setText(text, 0);
							}
							if (text != null && text.contains("recipient")) {
								text = text.replace("recipient", porder.getRecipient());
								r.setText(text, 0);
							}
							if (text != null && text.contains("deliverydate")) {
								text = text.replace("deliverydate", porder.getDelivery_date());
								r.setText(text, 0);
							}
							if(porder.getLavender()>0) {
								if (text != null && text.contains("I1")) {
									text = text.replace("I1", "薰衣草");
									r.setText(text, 0);
								}
								if (text != null && text.contains("Qty1")) {
									text = text.replace("Qty1", String.valueOf(porder.getLavender()));
									r.setText(text, 0);
								}
								if (text != null && text.contains("P1")) {
									text = text.replace("P1", "99");
									r.setText(text, 0);
								}
								if (text != null && text.contains("S1")) {
									subTotal=porder.getLavender()*99;
									text = text.replace("S1", String.valueOf(subTotal));
									r.setText(text, 0);
								}
								sum+=subTotal;
							}
							
							if(porder.getBabysbreath()>0) {
								if (text != null && text.contains("I2")) {
									text = text.replace("I2", "滿天星");
									r.setText(text, 0);
								}
								if (text != null && text.contains("Qty2")) {
									text = text.replace("Qty2", String.valueOf(porder.getBabysbreath()));
									r.setText(text, 0);
								}
								if (text != null && text.contains("P2")) {
									text = text.replace("P2", "199");
									r.setText(text, 0);
								}
								if (text != null && text.contains("S2")) {
									subTotal=porder.getBabysbreath()*199;
									text = text.replace("S2", String.valueOf(subTotal));
									r.setText(text, 0);
								}
								sum+=subTotal;
							}
							
							if(porder.getRose()>0) {
								if (text != null && text.contains("I3")) {
									text = text.replace("I3", "玫瑰花");
									r.setText(text, 0);
								}
								if (text != null && text.contains("Qty3")) {
									text = text.replace("Qty3", String.valueOf(porder.getRose()));
									r.setText(text, 0);
								}
								if (text != null && text.contains("P3")) {
									text = text.replace("P3", "299");
									r.setText(text, 0);
								}
								if (text != null && text.contains("S3")) {
									subTotal=porder.getRose()*299;
									text = text.replace("S3", String.valueOf(subTotal));
									r.setText(text, 0);
								}
								sum+=subTotal;
							}
							if (text != null && text.contains("Sum")) {
								text = text.replace("Sum", String.valueOf(sum));
								r.setText(text, 0);
							}
						}
					}
				}
			}
		}
		doc.write(new FileOutputStream("output.docx"));
	}
}
