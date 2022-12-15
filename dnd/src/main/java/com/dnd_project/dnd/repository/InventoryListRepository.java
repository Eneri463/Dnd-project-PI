package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharInventory;
import com.dnd_project.dnd.model.InventoryListCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface InventoryListRepository extends JpaRepository<InventoryListCharacter, Long> {
    @Transactional
    @Modifying
    @Query("delete from InventoryListCharacter where CharId = :id")
    void deleteByCharID(Long id);

    @Query("select t.objectsList.id as id, t.objectsList.name as name, t.objectsList.description as description from InventoryListCharacter t where t.charId = :id")
    List<CharInventory> searchInventory(Long id);
}
