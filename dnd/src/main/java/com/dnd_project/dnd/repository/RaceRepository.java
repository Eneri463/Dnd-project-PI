package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.ClassTable;
import com.dnd_project.dnd.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Optional<Race> findById(Long id);

    @Query("select t from Race t where t.id = :id")
    Race findByIdSpecial(Long id);
}
