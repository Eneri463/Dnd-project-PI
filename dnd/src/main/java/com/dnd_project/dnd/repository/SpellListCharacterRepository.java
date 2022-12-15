package com.dnd_project.dnd.repository;


import com.dnd_project.dnd.model.SpellListCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface SpellListCharacterRepository extends JpaRepository<SpellListCharacter, Long> {
    @Transactional
    @Modifying
    @Query("delete from SpellListCharacter where CharId = :id")
    void deleteByCharID(Long id);
}
