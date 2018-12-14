////////////////////////////////////////////////////////////////////
// [Davide] [Dinato] [1142198]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable {
    private String message;

    public RestaurantBillException(String message) {
        // TODO Auto-generated constructor stub
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
