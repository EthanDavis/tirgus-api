package com.tirgusapi.inventory;


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
public class InventoryControllerTest {

   @InjectMocks
   InventoryController target;

   @Mock
   private InventoryManager inventoryManager;

   @BeforeEach
   public void setUp() {
      target = new InventoryController();
      MockitoAnnotations.initMocks(this);
   }

   @Test
   public void should_call_getInventory_manager_function() {
      target.getInventory();

      Mockito.verify(inventoryManager, Mockito.times(1)).getInventory();
   }

   @Test
   public void should_call_createInventoryItem_manager_function() {
      InventoryItem testItem = new InventoryItem();

      target.createInventoryItem(testItem);

      Mockito.verify(inventoryManager, Mockito.times(1)).createInventoryItem(testItem);
   }

   @Test
   public void should_call_getInventoryItemById_manager_function() throws NotFoundException {
      long testId = 1l;

      target.getInventoryItemById(testId);

      Mockito.verify(inventoryManager, Mockito.times(1)).getInventoryItemById(testId);
   }

   @Test
   public void should_call_getInventoryItemById_and_throw_exception() throws NotFoundException {
      long testId = 1l;

      target.getInventoryItemById(testId);
      Mockito.when(inventoryManager.getInventoryItemById(testId)).thenThrow(new NotFoundException("Not Found"));

      Assertions.assertThrows(NotFoundException.class, () -> {
         target.getInventoryItemById(testId);
      });
   }
}
