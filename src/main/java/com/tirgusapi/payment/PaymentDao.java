package com.tirgusapi.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentDao {
   private final PaymentRepository paymentRepository;

   public PaymentDao(PaymentRepository paymentRepository) {
      this.paymentRepository = paymentRepository;
   }

   public void createPaymentReceipt(PaymentEntity payment) {
      this.paymentRepository.save(payment);
   }
}
