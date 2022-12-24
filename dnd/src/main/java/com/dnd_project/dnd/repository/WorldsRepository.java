package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.UsersCharacters;
import com.dnd_project.dnd.model.UsersWorld;
import com.dnd_project.dnd.model.Worlds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface WorldsRepository extends JpaRepository<Worlds, Long> {
    @Transactional
    @Modifying
    @Query("delete from Worlds where id = :id")
    void deleteByWorldId(Long id);

    @Query("select t.name as name, t.description as description " +
            "from Worlds t where t.id = :id")
    UsersWorld searchWorldInfo(Long id);
}
