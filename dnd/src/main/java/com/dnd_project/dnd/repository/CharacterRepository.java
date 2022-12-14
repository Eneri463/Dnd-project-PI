package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharactersInfo;
import com.dnd_project.dnd.model.CharacterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterTable, Long> {
    List<Object[]> findByName(String name);

    @Query("select t.id as id, t.name as name, t.age as age, " +
            "t.classtable.className as className, t.genders.gender as gender, t.ideology.ideologiesName as ideology, " +
            "t.race.raceName as race, t.background.background as background, t.level as level, t.strength as strength," +
            "t.dexterity as dexterity, t.constitution as constitution, t.intelligence as intelligence, t.wisdom as wisdom, " +
            "t.charisma as charisma, t.hp as hp, t.addHp as addHp, t.maxHp as maxHp, t.classArmor as classArmor, t.proficiencyBonus as proficiencyBonus " +
            "from CharacterTable t where t.id = :id")
    List<CharactersInfo> searchCharactersInfo(Long id);

}
