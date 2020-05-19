package com.tirgusapi.inventory;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryManager {

   @Autowired
   InventoryDao inventoryDao = new InventoryDao();

   public InventoryItem createInventoryItem(InventoryItem item) {
      return inventoryDao.createInventoryItem(item);
   }

   public List<InventoryItem> getInventory() {
    return inventoryDao.getInventory();
   }

   public InventoryItem getInventoryItemById(Long id) throws NotFoundException {
      return inventoryDao.getInventoryItemById(id);
   }
}
