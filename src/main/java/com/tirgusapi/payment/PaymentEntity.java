package com.tirgusapi.payment;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payments")
public class PaymentEntity {

   @Id()
   String id;
   @Column(name = "amount", nullable = false)
   long amount;
   @Column(name = "description", nullable = false)
   String description;
   @Column(name = "email", nullable = false)
   String email;
   @Column(name = "createdAt", nullable = false)
   DateTime createdAt;

   public PaymentEntity(Payment payment) {
      this.setId(payment.getId());
      this.setDescription(payment.getDescription());
      this.setAmount(payment.getAmount());
      this.setEmail(payment.getEmail());
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public long getAmount() {
      return amount;
   }

   public void setAmount(Long amount) {
      this.amount = amount;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public DateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(DateTime createdAt) {
      this.createdAt = createdAt;
   }
}
