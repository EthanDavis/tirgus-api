package com.tirgusapi.inventory;

import org.joda.time.DateTime;

public class InventoryItem {
   private String name;
   private double price;
   private DateTime createdAt;
   private String description;

   public InventoryItem(String name, double price) {
      this.name = name;
      this.price = price;
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
