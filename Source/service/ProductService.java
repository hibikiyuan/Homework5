package service;

import java.util.List;

import model.Employee;
import model.Product;

public interface ProductService {
		//Create
		void addProduct(Product product);
		
		//Read
		Product login(String username, String password);
		boolean isUsernameBeenUse(String username);
		List<Product> findAllProduct();
		Product findByProductId(int id);
		
		void updateEmployee(String product_name, int price, int id);
		
		void deleteProductById(int id);
}
