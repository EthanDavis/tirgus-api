package com.tirgusapi.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryManager {
   @Autowired
   InventoryRepository inventoryRepo;

   public InventoryItem createItem(InventoryItem item) {
      return inventoryRepo.save(item);
   }

   public List<InventoryItem> getInventory() {
      return inventoryRepo.findAll();
   }
}
