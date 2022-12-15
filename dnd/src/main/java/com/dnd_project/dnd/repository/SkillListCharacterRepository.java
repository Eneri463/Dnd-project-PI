package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.SkillListCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface SkillListCharacterRepository extends JpaRepository<SkillListCharacter, Long> {
    @Transactional
    @Modifying
    @Query("delete from SkillListCharacter where CharId = :id")
    void deleteByCharID(Long id);
}
