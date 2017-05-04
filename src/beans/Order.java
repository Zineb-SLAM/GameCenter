package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable{

	private List<OrderLine> lignes;
	private int id;
	private Customer customer;
	private boolean paid;
	private Payment payment;
	
	/**
	 * 
	 */
	public Order() {
		lignes = new ArrayList<OrderLine>();
	}
	
	public Order(int attr_id, Customer attr_customer, boolean attr_paid, Payment attr_payment) {
		super();
		this.id = attr_id;
		customer = attr_customer;
		paid = attr_paid;
		payment = attr_payment;
		lignes = new ArrayList<OrderLine>();
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

	public List<OrderLine> getLignes() {
		return lignes;
	}

	public void setLignes(List<OrderLine> lignes) {
		this.lignes = lignes;
	}
	
	public double getTotal(){
		double total = 0;
	
		for (OrderLine lc : lignes){
			total+=lc.getTotal();
		}
		//for(int i=0;i<lignes.size();i++){
		//	total = total + lignes.get(i).getTotal();
		//}
		return total;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
