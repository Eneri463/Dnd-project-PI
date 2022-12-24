package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharSkill;
import com.dnd_project.dnd.model.SkillListChar;
import com.dnd_project.dnd.model.SpellListChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SkillListCharacterRepository extends JpaRepository<SkillListChar, Long> {
    @Transactional
    @Modifying
    @Query("delete from SkillListChar where CharId = :id")
    void deleteByCharID(Long id);

    @Query("select t.skillList.id as id, t.skillList.name as name, t.skillList.description as description from SkillListChar t where t.charId = :id")
    List<CharSkill> searchSkills(Long id);

    @Query("select t from SkillListChar t where t.charId = :charID AND t.skillList.id = :skillID")
    Optional<SkillListChar> searchCombination(Long charID, Long skillID);

    @Transactional
    @Modifying
    @Query("delete from SkillListChar t where t.charId = :charID AND t.skillList.id = :skillID")
    void deleteSkill(Long charID, Long skillID);


}
