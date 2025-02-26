package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
		//create
		void add(Customer member);
		
		//read
		List<Customer> selectAll();
		List<Customer> selectUsernameAndPassword(String username,String password);
		List<Customer> selectById(String id);
		List<Customer> selectByUsername(String username);
		
		//update
		void update(Customer member);
		
		//delete
		void delete(String id);
}
