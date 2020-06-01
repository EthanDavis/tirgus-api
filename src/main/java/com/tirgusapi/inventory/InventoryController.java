package com.tirgusapi.inventory;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

   @Autowired
   InventoryManager inventoryManager;

   @GetMapping("/inventory/items")
   @ResponseBody
   public List<InventoryItem> getInventory() {
      return inventoryManager.getInventory();
   }

   @PostMapping("/inventory/items")
   @ResponseBody
   public InventoryItem createInventoryItem(@RequestBody InventoryItem item) {
      return inventoryManager.createInventoryItem(item);
   }

   @GetMapping("/inventory/items/{id}")
   @ResponseBody
   public InventoryItem getInventoryItemById(@PathVariable("id") Long id) throws NotFoundException {
      try {
         return inventoryManager.getInventoryItemById(id);
      } catch (NotFoundException e) {
         e.printStackTrace();
         throw new NotFoundException("Could not find item with id " + id);
      }
   }
}