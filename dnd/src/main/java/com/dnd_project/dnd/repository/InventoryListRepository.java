package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.InventoryListCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface InventoryListRepository extends JpaRepository<InventoryListCharacter, Long> {
    @Transactional
    @Modifying
    @Query("delete from InventoryListCharacter where CharId = :id")
    void deleteByCharID(Long id);
}
