////////////////////////////////////////////////////////////////////
// [Davide] [Dinato] [1142198]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;
import static org.junit.Assert.assertEquals;

import it.unipd.tos.model.MenuItem;

public class TestMenuItem {

    public void testGetTipo(){
    	MenuItem pasta = new MenuItem(MenuItem.itemType.PRIMO, "pasta alla carbonara", 6);
    	assertEquals(pasta.GetTipo(), MenuItem.itemType.PRIMO);
    	//return pasta.GetTipo().equals(MenuItem.itemType.PRIMO);
    }
    public void testGetNome(){
    	MenuItem pizza = new MenuItem(MenuItem.itemType.PIZZA, "pugliese", 5.5);    
    	assertEquals(pizza.GetNome(), "pugliese");
    	//return pizza.GetNome().equals("pugliese");
    }
    public void testGetPrezzo(){
    	MenuItem pizza = new MenuItem(MenuItem.itemType.PIZZA, "fantasia", 11.5);   
    	assertEquals(pizza.GetPrezzo(), 11.5);
    	//return pizza.GetPrezzo().equals(11.5);
    }
}