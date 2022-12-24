package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.Tracker;
import com.dnd_project.dnd.model.TrackerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface TrackerRepository extends JpaRepository<Tracker, Long> {

    @Query("select t.name as name, t.initiative as initiative, t.color as color " +
            "from Tracker t where t.worldId = :id")
    List<TrackerInfo> showInitiative(Long id);

    @Transactional
    @Modifying
    @Query("delete from Tracker where worldId = :id")
    void deleteByWorldID(Long id);


}
