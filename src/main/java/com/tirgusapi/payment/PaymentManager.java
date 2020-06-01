package com.tirgusapi.payment;

import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager {

   @Autowired
   private final PaymentProxy paymentProxy;
   @Autowired
   private final PaymentDao paymentDao;

   public PaymentManager(PaymentProxy paymentProxy, PaymentDao paymentDao) {
      this.paymentProxy = paymentProxy;
      this.paymentDao = paymentDao;
   }

   public String createPayment(Payment payment) throws StripeException {
      String paymentId = this.paymentProxy.createPayment(payment);
      payment.setId(paymentId);
      this.paymentDao.createPaymentReceipt(new PaymentEntity(payment));
      return paymentId;
   }
}
