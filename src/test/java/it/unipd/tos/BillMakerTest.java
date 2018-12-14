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
import org.junit.rules.ExpectedException;

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
             double tot = b.getOrderPrice(conto);
             assertEquals(31, tot, 0.0);
		 }
		 catch(RestaurantBillException e){
			 System.out.println(e.getMessage());
		 }
	 }

	@org.junit.Test
	 public void getOrderBillOver10Pizze() {
		 try {
			 List<MenuItem> conto = new ArrayList<MenuItem>();
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"marinara",3.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"capricciosa",6));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"pugliese",6));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"capricciosa",6));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"misto funghi",7.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"patatine",6));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"margherita",4));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"4 formaggi",6.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"diavola",5.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"parmigiana",6.5));
			 conto.add(new MenuItem(MenuItem.itemType.PIZZA,"misto mare",11));
			 
			 Bill b = new Bill();
             double tot = b.getOrderPrice(conto);
             assertEquals(65, tot, 0.0);
		 }
		 catch(RestaurantBillException e){
			 System.out.println(e.getMessage());
		 }
	 }

	@org.junit.Test
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
             double tot = b.getOrderPrice(conto);
			 assertEquals(123.025, tot, 0.0);
		 }
		 catch(RestaurantBillException e){
			 System.out.println(e.getMessage());
		 }
	 }

	@org.junit.Rule
	public ExpectedException exception = ExpectedException.none();

	@org.junit.Test
	public void getOrderBillOver20Element() {
		try {
			List<MenuItem> conto = new ArrayList<MenuItem>();

			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"marinara",3.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"capricciosa",6));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"pugliese",6));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"capricciosa",6));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"misto funghi",7.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"patatine",6));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"margherita",4));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"4 formaggi",6.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"diavola",5.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"parmigiana",6.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"marinara",3.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"capricciosa",6));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"pugliese",6));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"capricciosa",6));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"misto funghi",7.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"patatine",6));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"margherita",4));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"margherita",4));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"4 formaggi",6.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"diavola",5.5));
			conto.add(new MenuItem(MenuItem.itemType.PIZZA,"parmigiana",6.5));

			Bill b = new Bill();
			double tot = b.getOrderPrice(conto);
			exception.expect(RestaurantBillException.class);
			exception.expectMessage("+ di 20 elementi");
		}
		catch(RestaurantBillException e){
			System.out.println(e.getMessage());
		}
	}
	
}