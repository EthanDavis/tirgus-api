package com.tirgusapi.payment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentProxy {

   @Value("${stripe.keys.secret}")
   private String API_SECRET_KEY;

   public PaymentProxy() {
      Stripe.apiKey = API_SECRET_KEY;
   }


   public String createPayment(Payment payment) throws StripeException {
      PaymentIntentCreateParams params =
          PaymentIntentCreateParams.builder()
              .setAmount(payment.getAmount())
              .setSource(payment.getToken())
              .setCurrency("usd")
              .setDescription(payment.getDescription())
              .addPaymentMethodType("card")
              .setReceiptEmail(payment.getEmail())
              .build();

      PaymentIntent completePayment = PaymentIntent.create(params);
      return completePayment.getId();
   }

}
