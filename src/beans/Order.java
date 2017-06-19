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
	private int shipping_address_id = 0;
	private int billing_address_id = 0;
	private Address shippingaddress;
	private Address billingaddress;
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
	
	public Order(int attr_id, Customer attr_customer, boolean attr_paid, Payment attr_payment, int shipping_address_id, int billing_address_id) {
		super();
		this.id = attr_id;
		this.customer = attr_customer;
		this.paid = attr_paid;
		this.payment = attr_payment;
		this.shipping_address_id = shipping_address_id;
		this.billing_address_id = billing_address_id;
	}
	
	public Order(int attr_id, Customer attr_customer, boolean attr_paid) {
		super();
		this.id = attr_id;
		this.customer = attr_customer;
		this.paid = attr_paid;
	}
	
	public Order(int attr_id, Customer attr_customer, boolean attr_paid, int shipping_address_id, int billing_address_id) {
		super();
		this.id = attr_id;
		this.customer = attr_customer;
		this.paid = attr_paid;
		this.shipping_address_id = shipping_address_id;
		this.billing_address_id = billing_address_id;
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
	
	public void setShippingaddress(Address sa) {
		this.shippingaddress = sa;
	}
	
	public void setBillingaddress(Address ba) {
		this.billingaddress = ba;
	}
	
	public Address getShippingaddress() {
		return shippingaddress;
	}

	public Address getBillingaddress() {
		return billingaddress;
	}
	
	public double getTotal(){
		double total = 0;
		if(this.orderlines == null || this.orderlines.size() == 0)
			return total;
		for (OrderLine lc : orderlines){
			total+=lc.getTotal();
		}
		return Math.floor(total * 100) / 100;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public int get_shipping_address_id() {
		// TODO Auto-generated method stub
		return this.shipping_address_id;
	}
	
	public int get_billing_address_id() {
		// TODO Auto-generated method stub
		return this.billing_address_id;
	}
	
}
