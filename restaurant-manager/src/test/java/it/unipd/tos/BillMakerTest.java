////////////////////////////////////////////////////////////////////
// [Davide] [Dinato] [1142198]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.TestMenuItem;
import it.unipd.tos.business.Bill;
import java.util.ArrayList;

public class BillMakerTest{
	
	 
	 @org.junit.Test
	 public void getOrderBillNormalMode() {
		 try {
			 List<MenuItem> conto = new ArrayList<MenuItem>();
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"marinara",3.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"capricciosa",6));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"pugliese",6));
			 conto.add(new MenuItem(MenuItem.itemType.PRIMO,"pasta alla carbonara",6));
			 conto.add(new MenuItem(MenuItem.itemType.PRIMO,"pasta alla norma",5));
			 conto.add(new MenuItem(MenuItem.itemType.PRIMO,"gnocchi ai 4 formaggi",4.5));
			 
			 Bill b = new Bill();
			 
			 assertEquals(b.getBill(conto), 31);
		 }
		 catch(RestaurantBillException e){
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 
	 public void getOrderBillOver100Euro() {
		 try {
			 List<MenuItem> conto = new ArrayList<MenuItem>();
			 
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"4 formaggi",6.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"diavola",5.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"parmigiana",6.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"misto mare",11));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"gourmet",20));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"gourmet",20));
			 conto.add(new MenuItem(MenuItem.itemType.PRIMO,"paella",15));
			 conto.add(new MenuItem(MenuItem.itemType.PRIMO,"paella",15));
			 conto.add(new MenuItem(MenuItem.itemType.PRIMO,"pasta allo scoglio",15));
			 conto.add(new MenuItem(MenuItem.itemType.PRIMO,"pasta allo scoglio",15));
			 
			 Bill b = new Bill();
			 
			 assertEquals(b.getBill(conto), 123.025);
		 }
		 catch(RestaurantBillException e){
			 System.out.println(e.getMessage());
		 }
	 }
	
	
}