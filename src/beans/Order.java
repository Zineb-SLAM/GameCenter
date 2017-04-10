package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable{

	private List<LineOrder> lignes;

	/**
	 * 
	 */
	public Order() {
		lignes = new ArrayList<LineOrder>();
	}

	public List<LineOrder> getLignes() {
		return lignes;
	}

	public void setLignes(List<LineOrder> lignes) {
		this.lignes = lignes;
	}
	
	public double getTotal(){
		double total = 0;
	
		for (LineOrder lc : lignes){
			total+=lc.getTotal();
		}
		//for(int i=0;i<lignes.size();i++){
		//	total = total + lignes.get(i).getTotal();
		//}
		return total;
	}
	
}
