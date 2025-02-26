package model;

public class Product {
	private int id;
	private String productname;
	private int price;
	public Product(String productname, int price) {
		super();
		this.productname = productname;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
