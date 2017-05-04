package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderLine implements Serializable{

	private Product prod;
	private int qte;
	/**
	 * @param prod
	 * @param qte
	 */
	
	public OrderLine(Product prod, int qte) {
		super();
		this.prod = prod;
		this.qte = qte;
	}
	/**
	 * 
	 */
	public OrderLine() {
		super();
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public double getTotal(){
		//bisogna recuperare il costo di un singolo prodotto
		double prix = prod.getPrice();
		return (prix*this.qte);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prod == null) ? 0 : prod.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (prod == null) {
			if (other.prod != null)
				return false;
		} else if (!prod.equals(other.prod))
			//va a controllare se i due prodotti sono uguali utilizzando
			//l'equals di Product che abbiamo ridefinito in precedenza
			return false;
		return true;
	}
	
	
}
