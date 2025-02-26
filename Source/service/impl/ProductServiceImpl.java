package service.impl;

import java.util.List;

import dao.impl.ProductDaoImpl;
import model.Employee;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private static ProductDaoImpl productdaoimpl = new ProductDaoImpl(); 
	
	public static void main(String[] args) {
		
	}

	@Override
	public void addProduct(Product product) {
		
		productdaoimpl.add(product);
	}

	@Override
	public Product login(String username, String password) {
		Product product = null;
		List<Product> e = productdaoimpl.selectUsernameAndPassword(username, password);
		
		if(e.size()!=0)
		{
			product=e.get(0);
		}
		return product;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> findAllProduct() {
		return productdaoimpl.selectAll();
	}

	@Override
	public Product findByProductId(int id) {
		Product product = null;
		if (id>0) {
			List<Product> l = productdaoimpl.selectByProductId(id);
			if (l.size() > 0) {
				product = l.get(0);
			}
		}
		return product;
	}

	@Override
	public void updateEmployee(String product_name, int price, int id) {
		Product p = findByProductId(id);
		p.setProductname(product_name);
		p.setPrice(price);
		productdaoimpl.update(p);
		
	}

	@Override
	public void deleteProductById(int id) {
		if (id>0) {
			productdaoimpl.delete(id);
		}
	}
}
