package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharactersInfo;
import com.dnd_project.dnd.model.CharacterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CharacterRepository extends JpaRepository<CharacterTable, Long> {
    @Query("select t.charId as charId, t.charName as charName, t.age as age, " +
            "t.classTable.className as className, t.genders.genderName as genderName, t.ideology.ideologyName as ideologyName, " +
            "t.race.raceName as raceName, t.background.backgroundName as backgroundName, t.level as level, t.strength as strength," +
            "t.dexterity as dexterity, t.constitution as constitution, t.intelligence as intelligence, t.wisdom as wisdom, " +
            "t.charisma as charisma, t.hp as hp, t.addHp as addHp, t.maxHp as maxHp, t.classArmor as classArmor, t.proficiencyBonus as proficiencyBonus " +
            "from CharacterTable t where t.charId = :id")
    CharactersInfo searchCharactersInfo(Long id);

    @Transactional
    @Modifying
    @Query("delete from CharacterTable where CharId = :id")
    void deleteByCharID(Long id);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO characters (charName, level, age, classId, genderId, raceId, " +
            "backgroundId, ideologyId, strength, dexterity, constitution, intelligence, wisdom, charisma) " +
            "VALUES (:name, :level, :age, :classID, :genderID, :raceID, :backgroundID, :ideologyID, :strength, " +
            ":dexterity, :constitution, :intelligence, :wisdom, :charisma)", nativeQuery = true)
    CharacterTable saveSpecial(String name, Integer level, Integer age, Integer strength, Integer dexterity, Integer constitution,
                               Integer intelligence, Integer wisdom, Integer charisma, Long classID, Long genderID, Long raceID,
                               Long backgroundID, Long ideologyID);

}
