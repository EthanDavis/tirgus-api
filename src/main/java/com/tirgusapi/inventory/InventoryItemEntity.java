package com.tirgusapi.inventory;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "Inventory")
public class InventoryItemEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @Column(name = "name", nullable = false)
   private String name;
   @Column(name = "price", nullable = false)
   private double price;
   @Column(name = "quantity", nullable = false)
   private int quantity;
   @Lob
   @Column(name = "image", nullable = false)
   private byte[] image;
   @Column(name = "description", nullable = true)
   private String description;

   @Column(name = "createdAt", nullable = false)
   private DateTime createdAt;

   public InventoryItemEntity() {
   }

   public InventoryItemEntity(InventoryItem item) {
      this.id = item.getId();
      this.name = item.getName();
      this.price = item.getPrice();
      this.quantity = item.getQuantity();
      this.image = item.getImage().getBytes();
      this.description = item.getDescription();
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
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
