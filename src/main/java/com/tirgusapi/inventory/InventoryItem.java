package com.tirgusapi.inventory;

import org.joda.time.DateTime;


public class InventoryItem {

   private Long id;
   private String name;
   private double price;
   private int quantity;
   private String image;
   private String description;
   private DateTime createdAt;


   public InventoryItem() {
   }

   public InventoryItem(InventoryItemEntity itemEntity) {
      this.id = itemEntity.getId();
      this.name = itemEntity.getName();
      this.price = itemEntity.getPrice();
      this.quantity = itemEntity.getQuantity();
      this.description = itemEntity.getDescription();
      this.createdAt = itemEntity.getCreatedAt();
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public DateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(DateTime createdAt) {
      this.createdAt = createdAt;
   }
}
