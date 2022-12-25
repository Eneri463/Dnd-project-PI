package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharCondition;
import com.dnd_project.dnd.model.CharSpells;
import com.dnd_project.dnd.model.ConditionListChar;
import com.dnd_project.dnd.model.SpellListChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ConditionListRepository extends JpaRepository<ConditionListChar, Long> {
    @Transactional
    @Modifying
    @Query("delete from ConditionListChar where CharId = :id")
    void deleteByCharID(Long id);

    @Query("select t.conditionList.id as id, t.conditionList.name as name, t.conditionList.description as description from ConditionListChar t where t.charId = :id")
    List<CharCondition> searchCondition(Long id);

    @Query("select t from ConditionListChar t where t.charId = :charID AND t.conditionList.id = :conditionID")
    Optional<ConditionListChar> searchCombination(Long charID, Long conditionID);

    @Transactional
    @Modifying
    @Query("delete from ConditionListChar t where t.charId = :charID AND t.conditionList.id = :conditionID")
    void deleteCondition(Long charID, Long conditionID);
}
