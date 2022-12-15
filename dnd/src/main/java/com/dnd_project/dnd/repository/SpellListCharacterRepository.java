package com.dnd_project.dnd.repository;


import com.dnd_project.dnd.model.CharSpells;
import com.dnd_project.dnd.model.SpellList;
import com.dnd_project.dnd.model.SpellListChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;

public interface SpellListCharacterRepository extends JpaRepository<SpellListChar, Long> {
    @Transactional
    @Modifying
    @Query("delete from SpellListChar where CharId = :id")
    void deleteByCharID(Long id);

    @Query("select t.spellList.id as id, t.spellList.name as name, t.spellList.description as description, t.spellList.level as level from SpellListChar t where t.charId = :id")
    List<CharSpells> searchSpell(Long id);
}
