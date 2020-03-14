package com.tirgusapi.inventory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

   @GetMapping("/items")
   @ResponseBody
   public InventoryItem getItems() {
      return new InventoryItem("testItem", 12.50);
   }

}