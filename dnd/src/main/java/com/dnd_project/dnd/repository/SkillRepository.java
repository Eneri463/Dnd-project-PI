package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.SkillList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<SkillList, Long> {

    @Query("select t from SkillList t where t.id = :id")
    Optional<SkillList> searchSkill(Long id);
}
