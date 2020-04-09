package com.tirgusapi.inventory;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryDao {

   @Autowired
   InventoryRepository inventoryRepo;

   public InventoryItem createInventoryItem(InventoryItem item) {
      InventoryItemEntity itemEntity = inventoryRepo.save(new InventoryItemEntity(item));
      return new InventoryItem(itemEntity);
   }

   public List<InventoryItem> getInventory() {
      List<InventoryItemEntity> items = inventoryRepo.findAll();
      return items.stream().map(InventoryItem::new).collect(Collectors.toList());
   }

   public InventoryItem getInventoryItemById(Long id) throws NotFoundException {
      Optional<InventoryItemEntity> item = inventoryRepo.findById(id);
      if (!item.isPresent()) {
         throw new NotFoundException("Item with id: " + id + "could not be found");
      } else {
          return new InventoryItem(item.get());
      }
   }
}
