package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.UsersWorlds;
import com.dnd_project.dnd.model.WorldsLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorldsListRepository extends JpaRepository<WorldsLinks, Long> {

    @Query("select t.worlds.name as name, t.worlds.id as id, t.worlds.description as description " +
            "from WorldsLinks t where t.userID = :id")
    List<UsersWorlds> searchWorlds(Long id);

}
