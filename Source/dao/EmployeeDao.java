package dao;

import java.util.List;

import model.Employee;
import model.Porder;

public interface EmployeeDao {
	//create
			void add(Employee emp);
			
			//read
			List<Employee> selectAll();
			List<Employee> selectUsernameAndPassword(String username,String password);
			List<Employee> selectById(String id);
			List<Employee> selectByUsername(String username);
			List<Employee> selectByEmpId(int id);
			//update
			void update(Employee emp);
			
			//delete
			void delete(int id);
}
