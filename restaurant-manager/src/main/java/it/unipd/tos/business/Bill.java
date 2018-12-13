////////////////////////////////////////////////////////////////////
// [Davide] [Dinato] [1142198]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public class Bill implements RestaurantBill {
	
	public double getOrderPrice(List<MenuItem> pezzi) throws RestaurantBillException {
		
		double totale = 0;
		
		

		for(MenuItem m : pezzi) {
				totale += m.GetPrezzo();
			}
		
		if(totale > 100)
			totale *= 0.95;
		
		return totale;
		
	}
}
