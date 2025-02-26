package model;

public class Porder {
	private String order_no;
	private String name;
	private String recipient;
	private String order_date;
	private String delivery_date;
	private int lavender;
	private int babysbreath;
	private int rose;
	public Porder(String name, String recipient, String delivery_date, int lavender, int babysbreath, int rose) {
		super();
		this.name = name;
		this.recipient = recipient;
		this.delivery_date = delivery_date;
		this.lavender = lavender;
		this.babysbreath = babysbreath;
		this.rose = rose;
	}
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public int getLavender() {
		return lavender;
	}
	public void setLavender(int lavender) {
		this.lavender = lavender;
	}
	public int getBabysbreath() {
		return babysbreath;
	}
	public void setBabysbreath(int babysbreath) {
		this.babysbreath = babysbreath;
	}
	public int getRose() {
		return rose;
	}
	public void setRose(int rose) {
		this.rose = rose;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}	
	
}
