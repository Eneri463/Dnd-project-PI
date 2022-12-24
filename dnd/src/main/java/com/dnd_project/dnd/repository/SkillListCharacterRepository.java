package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharSkill;
import com.dnd_project.dnd.model.SkillListChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SkillListCharacterRepository extends JpaRepository<SkillListChar, Long> {
    @Transactional
    @Modifying
    @Query("delete from SkillListChar where CharId = :id")
    void deleteByCharID(Long id);

    @Query("select t.skillList.id as id, t.skillList.skillName as skillName, t.skillList.description as description from SkillListChar t where t.charId = :id")
    List<CharSkill> searchSkill(Long id);
}
