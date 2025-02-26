package dao;

import java.util.List;

import model.Porder;

public interface PorderDao {
	void add(Porder porder);
	
	List<Porder> selectAll();
	List<Porder> selectByOrderNo(String orderno);
	List<Porder> selectByName(String name);
	
	void update(Porder porder);
	
	void delete(String orderno);
}
