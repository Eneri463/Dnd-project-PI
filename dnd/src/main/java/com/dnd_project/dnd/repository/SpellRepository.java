package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.SpellList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SpellRepository extends JpaRepository<SpellList, Long> {

    @Query("select t from SpellList t where t.id = :id")
    Optional<SpellList> searchSpell(Long id);

}
