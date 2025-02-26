package model;

import java.io.Serializable;

public class Employee implements Serializable {
	private int id;
	private String emp_name;
	private String emp_username;
	private String emp_password;
	private String role;
	public Employee(String emp_name, String emp_username, String emp_password, String role) {
		super();
		this.emp_name = emp_name;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.role = role;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_username() {
		return emp_username;
	}
	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
