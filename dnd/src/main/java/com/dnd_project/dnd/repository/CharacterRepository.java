package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharacterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterTable, Long> {
    List<Object[]> findByName(String name);

    @Query("select t.id, t.name, t.age, t.classtable.name from CharacterTable t where t.name = :name")
    //@Query(value = "select t.name, t.classtable.name from charactetable t where t.name = :name ", nativeQuery = true)
    List<Object[]> searchCustom(String name);

}
