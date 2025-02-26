package service.impl;

import java.util.List;

import dao.impl.CustomerDaoImpl;
import model.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private static CustomerDaoImpl memberdaoimpl=new CustomerDaoImpl();
	
	public static void main(String[] args) {
		
	}

	@Override
	public void addMember(Customer member) {
		memberdaoimpl.add(member);
		
	}

	@Override
	public Customer login(String username, String password) {
		Customer member=null;
		List<Customer> l=memberdaoimpl.selectUsernameAndPassword(username, password);
		if(l.size()!=0)
		{
			member=l.get(0);
		}		
		
		return member;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		
		return !memberdaoimpl.selectByUsername(username).isEmpty();
		
	}
}
