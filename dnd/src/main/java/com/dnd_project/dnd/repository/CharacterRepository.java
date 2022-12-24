package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharactersInfo;
import com.dnd_project.dnd.model.CharacterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CharacterRepository extends JpaRepository<CharacterTable, Long> {
    @Query("select t.id as id, t.name as name, t.age as age, " +
            "t.classTable.name as className, t.genders.name as genderName, t.ideology.name as ideologyName, " +
            "t.race.name as raceName, t.background.name as backgroundName, t.level as level, t.strength as strength," +
            "t.dexterity as dexterity, t.constitution as constitution, t.intelligence as intelligence, t.wisdom as wisdom, " +
            "t.charisma as charisma, t.hp as hp, t.addHp as addHp, t.maxHp as maxHp, t.classArmor as classArmor, t.proficiencyBonus as proficiencyBonus " +
            "from CharacterTable t where t.id = :id")
    CharactersInfo searchCharactersInfo(Long id);

    @Transactional
    @Modifying
    @Query("delete from CharacterTable where id = :id")
    void deleteByCharID(Long id);

}
