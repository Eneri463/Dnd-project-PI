package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.Backgrounds;
import com.dnd_project.dnd.model.Ideologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IdeologiesRepository extends JpaRepository<Ideologies, Long> {
    Optional<Ideologies> findById(Long id);

    @Query("select t from Ideologies t where t.id = :id")
    Ideologies findByIdSpecial(Long id);
}
