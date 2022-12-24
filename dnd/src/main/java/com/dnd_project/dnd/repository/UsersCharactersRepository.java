package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharacterListTable;
import com.dnd_project.dnd.model.UsersCharacters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UsersCharactersRepository extends JpaRepository<CharacterListTable, Long> {

    @Query("select t.charTable.charName as charName, t.charTable.charId as charId,  t.charTable.classTable.className as className," +
            " t.charTable.level as level " +
            "from CharacterListTable t where t.userId = :id")
    List<UsersCharacters> searchCharacters(Long id);

    @Transactional
    @Modifying
    @Query("delete from CharacterListTable where CharId = :id")
    void deleteByCharID(Long id);

}
