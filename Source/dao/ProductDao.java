package dao;

import java.util.List;
import model.Product;

public interface ProductDao {
		//create
		void add(Product product);
		
		//read
		List<Product> selectAll();
		List<Product> selectUsernameAndPassword(String username,String password);
		List<Product> selectById(String id);
		List<Product> selectByUsername(String username);
		List<Product> selectByProductId(int id);
		
		//update
		void update(Product product);
		
		//delete
		void delete(int id);
}
