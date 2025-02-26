package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import model.Employee;
import model.Customer;
import model.Porder;
import util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public static void main(String[] args) {
		System.out.println(new EmployeeDaoImpl().selectByEmpId(5));
	}
	
	private static Connection conn=DbConnection.getDb();

	@Override
	public void add(Employee emp) {
		String sql="insert into musicstore.employee(emp_name,emp_username ,emp_password,role) "
				+ "values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_username());
			ps.setString(3, emp.getEmp_password());
			ps.setString(4, emp.getRole());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> selectAll() {
		String sql="select * from employee";
		List<Employee> l=new ArrayList();
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet resultset=ps.executeQuery();
			while(resultset.next()) {
				Employee emp = new Employee();
				emp.setId(resultset.getInt("id"));
				emp.setEmp_name(resultset.getString("emp_name"));
				emp.setEmp_username(resultset.getString("emp_username"));
				emp.setEmp_password(resultset.getString("emp_password"));
				emp.setRole(resultset.getString("role"));
				l.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Employee> selectUsernameAndPassword(String username, String password) {
		String sql = "select * from employee where emp_username=? and emp_password=?";
		List<Employee> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet resultset=ps.executeQuery();
			
			if(resultset.next()) {
				Employee e=new Employee();
				e.setEmp_name(resultset.getString("emp_name"));
				e.setEmp_username(resultset.getString("emp_username"));
				e.setEmp_password(resultset.getString("emp_password"));
				e.setRole(resultset.getString("role"));
				
				l.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Employee> selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee emp) {
		String sql="update employee set emp_name=?,emp_username=?,emp_password=?,role=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_username());
			ps.setString(3, emp.getEmp_password());
			ps.setString(4, emp.getRole());
			ps.setInt(5, emp.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql="delete from employee where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> selectByEmpId(int id) {
		String Sql="select * from employee where id=?";
		List<Employee> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setInt(1, id);
			ResultSet resultset=ps.executeQuery();
			if(resultset.next()) {
				Employee emp = new Employee();
				emp.setId(resultset.getInt("id"));
				emp.setEmp_name(resultset.getString("emp_name"));
				emp.setEmp_username(resultset.getString("emp_username"));
				emp.setEmp_password(resultset.getString("emp_password"));
				emp.setRole(resultset.getString("emp_password"));
				l.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
