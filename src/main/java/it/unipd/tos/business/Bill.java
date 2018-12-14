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

        if (pezzi.size() > 20) {
            throw new RestaurantBillException("+ di 20 elementi");
        }

        long numPizze = pezzi.stream().filter(a -> a.GetTipo().equals(MenuItem.itemType.PIZZA)).count();

        if (numPizze > 10) {
            double min = pezzi.get(0).GetPrezzo();

            for (MenuItem m : pezzi) {
                totale += m.GetPrezzo();
                if (m.GetPrezzo() < min) {
                    min = m.GetPrezzo();
                }
            }

            totale -= min;

        } else {
            for (MenuItem m : pezzi) {
                totale += m.GetPrezzo();
            }
        }

        if (totale > 100) {
            totale *= 0.95;
        }

        return totale;

    }
}
