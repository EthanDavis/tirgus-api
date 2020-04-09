package com.tirgusapi.inventory;


import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryItemEntity, Long> {
}
