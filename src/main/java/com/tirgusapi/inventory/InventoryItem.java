package com.tirgusapi.inventory;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
public class InventoryItem {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String name;
   private double price;
   private int quantity;
   @Lob
   private byte[] image;
   private String description;
   private DateTime createdAt;

   public InventoryItem() {
   }

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

   public byte[] getImage() {
      return image;
   }

   public void setImage(byte[] image) {
      this.image = image;
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
