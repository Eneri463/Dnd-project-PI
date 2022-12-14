package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharacterInfo;
import com.dnd_project.dnd.model.CharacterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterTable, Long> {
    List<Object[]> findByName(String name);

    @Query("select t.id as id, t.name as name, t.age as age, " +
            "t.classtable.classname as classname, t.genders.gender as gender, t.ideology.ideologiesName as ideology, " +
            "t.race.raceName as race, t.background.background as background, t.level as level, t.strength as strength," +
            "t.dexterity as dexterity, t.constitution as constitution, t.intelligence as intelligence, t.wisdom as wisdom, " +
            "t.charisma as charisma " +
            "from CharacterTable t where t.id = :id")
    //@Query(value = "select t.name, t.classtable.name from charactetable t where t.name = :name ", nativeQuery = true)
    List<CharacterInfo> searchCustom(Long id);

}
