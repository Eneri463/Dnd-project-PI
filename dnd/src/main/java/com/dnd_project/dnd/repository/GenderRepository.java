package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.Genders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenderRepository extends JpaRepository<Genders, Long> {
    @Query("select t from Genders t where t.id = :id")
    Genders findByIdSpecial(Long id);
}
