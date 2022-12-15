package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClassTableRepository extends JpaRepository<ClassTable, Long> {
    Optional<ClassTable> findById(Long id);

    @Query("select t from ClassTable t where t.id = :id")
    ClassTable findByIdSpecial(Long id);
}
