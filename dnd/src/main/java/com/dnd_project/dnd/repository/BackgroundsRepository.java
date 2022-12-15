package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.Backgrounds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BackgroundsRepository extends JpaRepository<Backgrounds, Long> {

    @Query("select t from Backgrounds t where t.id = :id")
    Backgrounds findByIdSpecial(Long id);
}
