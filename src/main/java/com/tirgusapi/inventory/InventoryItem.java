package com.tirgusapi.inventory;

public class InventoryItem {
   private String name;
   private double price;

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
}
