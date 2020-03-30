package com.tirgusapi.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

   @Autowired
   InventoryManager inventoryManager;

   @GetMapping("/items")
   @ResponseBody
   public List<InventoryItem> getInventory() {
      return inventoryManager.getInventory();
   }

   @PostMapping("/items")
   @ResponseBody
   public InventoryItem createItem(@RequestBody InventoryItem item) {
      return inventoryManager.createItem(item);
   }
}