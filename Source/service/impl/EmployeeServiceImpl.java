package service.impl;

import java.util.List;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import model.Porder;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static EmployeeDaoImpl employeedaoimpl = new EmployeeDaoImpl();
	
	@Override
	public void addEmployee(Employee emp) {
		
		employeedaoimpl.add(emp);
	}

	@Override
	public Employee login(String username, String password) {
		Employee emp = null;
		List<Employee> e = employeedaoimpl.selectUsernameAndPassword(username, password);
		
		if(e.size()!=0)
		{
			emp=e.get(0);
		}
		return emp;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeedaoimpl.selectAll();
	}

	@Override
	public void deleteEmployeeById(int id) {
		if (id>0) {
			employeedaoimpl.delete(id);
		}
		
	}

	@Override
	public void updateEmployee(String name, String emp_username, String emp_password, String role, int id) {
		Employee e = findByEmpId(id);
		e.setEmp_name(name);
		e.setEmp_username(emp_username);
		e.setEmp_password(emp_password);
		e.setRole(role);
		employeedaoimpl.update(e);
	}

	@Override
	public Employee findByEmpId(int id) {
		
		Employee employee = null;
		if (id>0) {
			List<Employee> l = employeedaoimpl.selectByEmpId(id);
			if (l.size() > 0) {
				employee = l.get(0);
			}
		}
		return employee;
	}

}
