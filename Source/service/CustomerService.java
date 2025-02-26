package service;

import model.Customer;

public interface CustomerService {
		//Create
		void addMember(Customer member);
		
		//Read
		Customer login(String username, String password);
		boolean isUsernameBeenUse(String username);
}
