package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.ConditionList;
import com.dnd_project.dnd.model.SkillList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConditionRepository extends JpaRepository<ConditionList, Long> {

    @Query("select t from ConditionList t where t.id = :id")
    Optional<ConditionList> searchCondition(Long id);
}
