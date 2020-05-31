package com.tirgusapi.payment;

import org.apache.http.HttpException;

public class PaymentFailureException extends HttpException {

   public PaymentFailureException() {
      super();
   }

   public PaymentFailureException(String msg) {
      super(msg);
   }

}
