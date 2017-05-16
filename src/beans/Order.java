package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable{

	private List<OrderLine> orderlines;
	private int id;
	private Customer customer;
	private boolean paid;
	private Payment payment;
	
	/**
	 * 
	 */
	public Order() {}
	
	public Order(int attr_id, Customer attr_customer, boolean attr_paid, Payment attr_payment) {
		super();
		this.id = attr_id;
		this.customer = attr_customer;
		this.paid = attr_paid;
		this.payment = attr_payment;
	}
	
	public Order(int attr_id, Customer attr_customer, boolean attr_paid) {
		super();
		this.id = attr_id;
		this.customer = attr_customer;
		this.paid = attr_paid;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public boolean is_paid() {
		return paid;
	}

	public List<OrderLine> getOrderLines() {
		return orderlines;
	}

	public void setOrderLines(List<OrderLine> lignes) {
		this.orderlines = lignes;
	}
	
	public double getTotal(){
		double total = 0;
	
		for (OrderLine lc : orderlines){
			total+=lc.getTotal();
		}
		return Math.floor(total * 100) / 100;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
