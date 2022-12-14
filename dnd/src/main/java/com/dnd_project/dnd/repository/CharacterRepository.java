package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharacterInfo;
import com.dnd_project.dnd.model.CharacterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterTable, Long> {
    List<Object[]> findByName(String name);

    @Query("select t.id as id, t.name as name, t.age as age, t.classtable.classname as classname from CharacterTable t where t.name = :name")
    //@Query(value = "select t.name, t.classtable.name from charactetable t where t.name = :name ", nativeQuery = true)
    List<CharacterInfo> searchCustom(String name);

}
