package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.ObjectsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ObjectRepository extends JpaRepository<ObjectsList, Long> {

    @Query("select t from ObjectsList t where t.id = :id")
    Optional<ObjectsList> searchObject(Long id);
}
