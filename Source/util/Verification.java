package util;

import java.util.regex.*;

import javax.swing.JOptionPane;

import model.Customer;
import util.Tool;

public class Verification {
	Customer m= null;
	boolean status=false;
	public boolean checkLogin(String username, String password) {
		m=(Customer)Tool.read("member.txt");
		if(!((username.equals(m.getUsername())) && password.equals(m.getPassword()))) {
			JOptionPane.showMessageDialog(null, "無此帳號，請重新輸入");
		} else {
			status=true;
		}
		return status;
	}
	
	public boolean checkReg(String username, String mobile) {
		Pattern usernamePattern = Pattern.compile("^[a-zA-Z]{3,}+$");
		Matcher usernameMatcher = usernamePattern.matcher(username);
		Pattern mobilePattern = Pattern.compile("^09[0-9]{2}[0-9]{6}$");
		Matcher mobileMatcher = mobilePattern.matcher(mobile);
		if(!usernameMatcher.matches()) {
			JOptionPane.showMessageDialog(null, "帳號只能是英文，至少3個字以上，請重新輸入!!");
			return false;
		}
		else if(!mobileMatcher.matches()) {
			JOptionPane.showMessageDialog(null, "手機輸入格式錯誤，請重新輸入!!");
			return false;
		}
		else {
			return true;
		}
	}
}
