package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao {
	
	private static Connection conn=DbConnection.getDb();
	
	Porder p = new Porder();

	public static void main(String[] args) {
		
		List<Porder> l = new PorderDaoImpl().selectByName("Yui PPP");
		for(Porder p:l) {
			System.out.println(p.getName()+"\t"+p.getLavender()+"\t"+p.getBabysbreath()+"\t"+p.getRose());
		}
		
	}

	@Override
	public void add(Porder porder) {
		
		String sql="INSERT INTO porder\r\n"
				+ "	(order_no, order_date, name, recipient, delivery_date, guitar, bass, drum)\r\n"
				+ "VALUES\r\n"
				+ "(\r\n"
				+ "	CONCAT('OD-',(select date_format(CURRENT_TIMESTAMP(),'%Y%m%d%H%i%s'))),CURRENT_DATE(),?,?,?,?,?,?\r\n"
				+ ")";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, porder.getName());
			ps.setString(2, porder.getRecipient());
			ps.setString(3, porder.getDelivery_date());
			ps.setInt(4, porder.getLavender());
			ps.setInt(5, porder.getBabysbreath());
			ps.setInt(6, porder.getRose());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet resultset=ps.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setOrder_no(resultset.getNString("order_no"));
				porder.setName(resultset.getString("name"));
				porder.setRecipient(resultset.getString("recipient"));
				porder.setOrder_date(resultset.getString("order_date"));
				porder.setDelivery_date(resultset.getString("delivery_date"));
				porder.setLavender(resultset.getInt("guitar"));
				porder.setBabysbreath(resultset.getInt("bass"));
				porder.setRose(resultset.getInt("drum"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}

	@Override
	public List<Porder> selectByOrderNo(String orderno) {
		String Sql="select * from porder where order_no=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, orderno);			
			ResultSet resultset=ps.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setOrder_no(resultset.getNString("order_no"));
				porder.setName(resultset.getString("name"));
				porder.setRecipient(resultset.getString("recipient"));
				porder.setOrder_date(resultset.getString("order_date"));
				porder.setDelivery_date(resultset.getString("delivery_date"));
				porder.setLavender(resultset.getInt("guitar"));
				porder.setBabysbreath(resultset.getInt("bass"));
				porder.setRose(resultset.getInt("drum"));
				
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set recipient=?,delivery_date=?,guitar=?,bass=?,drum=? where order_no=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, porder.getRecipient());
			ps.setString(2, porder.getDelivery_date());
			ps.setInt(3, porder.getLavender());
			ps.setInt(4, porder.getBabysbreath());
			ps.setInt(5, porder.getRose());
			ps.setString(6, porder.getOrder_no());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String orderno) {
		String sql="delete from porder where order_no=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, orderno);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectByName(String name) {
		String Sql="select * from porder where name=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, name);
			ResultSet resultset=ps.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setOrder_no(resultset.getNString("order_no"));
				porder.setName(resultset.getString("name"));
				porder.setRecipient(resultset.getString("recipient"));
				porder.setOrder_date(resultset.getString("order_date"));
				porder.setDelivery_date(resultset.getString("delivery_date"));
				porder.setLavender(resultset.getInt("guitar"));
				porder.setBabysbreath(resultset.getInt("bass"));
				porder.setRose(resultset.getInt("drum"));
				
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
