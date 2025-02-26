package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import model.Employee;
import model.Product;
import util.DbConnection;

public class ProductDaoImpl implements ProductDao{
	private static Connection conn=DbConnection.getDb();
	@Override
	public void add(Product product) {
		String sql="insert into product(product_name,price) "
				+ "values(?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, product.getProductname());
			ps.setInt(2, Integer.valueOf(product.getPrice()));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> selectAll() {
		String sql="select * from product";
		List<Product> l=new ArrayList();
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet resultset=ps.executeQuery();
			while(resultset.next()) {
				Product product = new Product();
				product.setId(resultset.getInt("id"));
				product.setProductname(resultset.getString("product_name"));
				product.setPrice(resultset.getInt("price"));
				
				l.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Product> selectUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product product) {
		String sql="update product set product_name=?,price=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, product.getProductname());
			ps.setInt(2, product.getPrice());
			ps.setInt(3, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from product where id=?";
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
	public List<Product> selectByProductId(int id) {
		String Sql="select * from product where id=?";
		List<Product> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setInt(1, id);
			ResultSet resultset=ps.executeQuery();
			if(resultset.next()) {
				Product product = new Product();
				product.setId(resultset.getInt("id"));
				product.setProductname(resultset.getString("product_name"));
				product.setPrice(resultset.getInt("price"));
				l.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
}
