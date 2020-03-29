package com.tirgusapi.inventory;

import org.joda.time.DateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class InventoryItem {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String name;
   private double price;
   private int quantity;
   private String description;
   private DateTime createdAt;

   public InventoryItem(String name, double price) {
      this.name = name;
      this.price = price;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String getName() {
      return this.name;
   }

   public double getPrice() {
      return this.price;
   }

   public DateTime getCreatedAt() {
      return this.createdAt;
   }

   public String getDescription() {
      return this.description;
   }
}
