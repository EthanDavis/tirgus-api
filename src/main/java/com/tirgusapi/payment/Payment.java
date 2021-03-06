package com.tirgusapi.payment;

import org.joda.time.DateTime;

public class Payment {
   String id;
   String description;
   String token;
   long amount;
   String email;
   DateTime createdAt;

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

   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
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
