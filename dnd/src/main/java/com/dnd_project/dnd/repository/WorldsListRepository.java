package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.UsersWorlds;
import com.dnd_project.dnd.model.WorldsLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface WorldsListRepository extends JpaRepository<WorldsLinks, Long> {

    @Query("select t.worlds.worldName as worldName, t.worlds.id as id, t.worlds.description as description " +
            "from WorldsLinks t where t.userId = :id")
    List<UsersWorlds> searchWorlds(Long id);

    @Transactional
    @Modifying
    @Query("delete from WorldsLinks where worldId = :id")
    void deleteByWorldId(Long id);

}
