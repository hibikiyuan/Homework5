package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controller.porder.PorderMainUI;
import model.Porder;

//import controller.porder.PorderMainUI;

public class Tool {
	private int sum, subLavendar, subBabysbreath, subRose;
	public static void save(Object s,String filename)
	{
		
		try {
			
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(s);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object read(String filename)
	{
		Object o=null;
		
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return o;
	}

	public static void gotoPorderMain() {
		PorderMainUI pmui = new PorderMainUI();
		pmui.setVisible(true);
	}
	
	public String calChanges(Integer value) {
		System.out.println(sum);
		int x=0;
		String result ="";
		value-=sum;
		if(value>0) {
			result="應找金額"+value+"元，各種貨幣數量如下:\n";
			int[] banknotes= {1000,500,100,50,10,5,1};
			for(int i=0 ;i<banknotes.length;i++) {
				x=value/banknotes[i];
				value-=x*banknotes[i];
				if(x>0) {
					result+=banknotes[i]+"元 * "+x+"\n";
				}
			}
		} else if(value==0) {
			result ="不用找錢";
		}
		return result;
	}
	
	public String show(Porder porder) {
		String lavendarName = "";
		String babysbreathName = "";
		String roseName = "";
		String msg="";
		if(porder.getLavender()>=0 && porder.getBabysbreath()>=0 && porder.getRose()>=0) {
			subLavendar=porder.getLavender()*99;
			subBabysbreath=porder.getBabysbreath()*199;
			subRose=porder.getRose()*299;
			sum=subLavendar+subBabysbreath+subRose;			
			lavendarName="\n吉他\t"+porder.getLavender()+"\t"+subLavendar;
			babysbreathName="\n貝斯\t"+porder.getBabysbreath()+"\t"+subBabysbreath;
			roseName="\n鼓\t"+porder.getRose()+"\t"+subRose;
			msg+="您的訂購明細如下:\n"+
					"客戶名稱: "+porder.getName()+"\n"+
					"收件人: "+porder.getRecipient()+"\n"+
					"訂購日期: "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"\n"+
					"預計送達日期: "+ porder.getDelivery_date()+"\n"+
					"--------------------------------------------------\n"+
					"品項名稱"+"\t"+"數量"+"\t小計\n"+
					"--------------------------------------------------"+
					lavendarName+
					babysbreathName+
					roseName+
					"\n"+
					"--------------------------------------------------\n"+
					"總金額：\t\t"+sum;
		}
		return msg;
	}
	
	public String[] setStringArray() {
		String[] arr = null;
		List<String> listArr = new ArrayList<String>();
		for(int i=0 ; i<=99 ; i++) {
			listArr.add(String.valueOf(i));
			arr = listArr.toArray(new String[i]);
		}
		
		return arr; 
		
	}
	
	public String[] toStringArray(List<String> s) {
		String[] arr = null;
		List<String> listArr = new ArrayList<String>();
		for(int i=0 ; i<=s.size() ; i++) {
			listArr.add(String.valueOf(s));
			arr = listArr.toArray(new String[i]);
		}
		
		return arr;
		
	}
}
