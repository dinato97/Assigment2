////////////////////////////////////////////////////////////////////
// [Davide] [Dinato] [1142198]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

<<<<<<<HEAD

public class RestaurantBillException extends Throwable {

    private String message;

    public RestaurantBillException(String message) {
        // TODO Auto-generated constructor stub
        this.message = message;
    }

    public String getMessage() {
=======
        public class RestaurantBillException extends Throwable {
            private String message;

            public RestaurantBillException(String message) {
                // TODO Auto-generated constructor stub
                this.message = message;
            }

            public String getMessage() {
>>>>>>>5d 7ed 2 bbe3a7d4cb64eeb4d62a466e3bc5db8832
                return message;
            }

        }
