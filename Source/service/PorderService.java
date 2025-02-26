package service;

import java.util.List;

import model.Porder;

public interface PorderService {
		//create
		void addPorder(Porder porder);
		
		//read-->列印報表
		String AllPorder();
		List<Porder> findAllPorder();
		Porder findByOrderNo(String orderno);
		String findByName(String name);
		
		//update
		void updatePorder(String name,String orderno);
		void updatePorder(String recipient, String delivery_date, int lavender,int babysbreath,int rose, String orderno);
		void updtaePorder(Porder porder);
		
		//delete
		void deletePorderByOrderNo(String orderno);

		void updatePorder(Porder porder);

		List<Porder> findOrdersByName(String name);
}
