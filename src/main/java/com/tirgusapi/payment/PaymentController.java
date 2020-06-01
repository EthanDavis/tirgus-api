package com.tirgusapi.payment;

import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

   @Autowired
   private final PaymentManager paymentManager;

   public PaymentController(PaymentManager paymentManager) {
      this.paymentManager = paymentManager;
   }

   @PostMapping("/payment")
   @ResponseBody
   public String createPayment(@RequestBody Payment payment) throws PaymentFailureException {
      try {
         return paymentManager.createPayment(payment);
      } catch (StripeException e) {
         e.printStackTrace();
         throw new PaymentFailureException("An error occurred trying to create your payment.");
      }
   }


}
