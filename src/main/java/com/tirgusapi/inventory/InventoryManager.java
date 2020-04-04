package com.tirgusapi.inventory;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryManager {
   @Autowired
   InventoryRepository inventoryRepo;

   public InventoryItem createInventoryItem(InventoryItem item) {
      return inventoryRepo.save(item);
   }

   public List<InventoryItem> getInventory() {
      return inventoryRepo.findAll();
   }

   public InventoryItem getInventoryItemById(Long id) throws NotFoundException {
      Optional<InventoryItem> item = inventoryRepo.findById(id);
      if (!item.isPresent()) {
         throw new NotFoundException("Item with id: " + id + "could not be found");
      } else {
         return item.get();
      }
   }
}
