package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	void addEmployee(Employee emp);
	
	Employee login(String username, String password);
	boolean isUsernameBeenUse(String username);
	
	List<Employee> findAllEmployee();
	Employee findByEmpId(int id);
	
	void updateEmployee(String name, String emp_name, String emp_password, String role, int id);
	
	void deleteEmployeeById(int id);
}
