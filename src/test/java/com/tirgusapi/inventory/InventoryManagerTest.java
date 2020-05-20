package com.tirgusapi.inventory;

import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InventoryManagerTest {
   @InjectMocks
   InventoryManager target;

   @Mock
   private InventoryDao inventoryDao;

   @BeforeEach
   public void setUp() {
      target = new InventoryManager();
      MockitoAnnotations.initMocks(this);
   }


   @Test
   public void should_call_createInventoryItem_dao_function() {
      InventoryItem test = new InventoryItem();

      target.createInventoryItem(test);

      Mockito.verify(inventoryDao, Mockito.times(1)).createInventoryItem(test);
   }


   @Test
   public void should_call_getInventory_dao_function() {
      target.getInventory();

      Mockito.verify(inventoryDao, Mockito.times(1)).getInventory();
   }

   @Test
   public void should_call_getInventoryItemById_dao_function() throws NotFoundException {
      Long testId = 1l;
      target.getInventoryItemById(testId);
      Mockito.verify(inventoryDao, Mockito.times(1)).getInventoryItemById(testId);
   }

   @Test
   public void should_call_getInventoryItemById_and_throw_not_found_exception() throws NotFoundException {
      Long testId = 1l;
      Mockito.when(inventoryDao.getInventoryItemById(testId)).thenThrow(new NotFoundException("Not Found"));
      Assertions.assertThrows(ResourceNotFoundException.class, () -> {
         target.getInventoryItemById(testId);
      });

   }
}
