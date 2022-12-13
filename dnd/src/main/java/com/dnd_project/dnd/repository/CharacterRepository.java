package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharacterTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<CharacterTable, Long> {
    List<Object[]> findByName(String name);

}
