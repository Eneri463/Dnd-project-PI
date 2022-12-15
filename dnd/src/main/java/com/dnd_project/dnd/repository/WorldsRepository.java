package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.Worlds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface WorldsRepository extends JpaRepository<Worlds, Long> {
    @Transactional
    @Modifying
    @Query("delete from Worlds where id = :id")
    void deleteByWorldId(Long id);
}
