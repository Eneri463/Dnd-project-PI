package com.dnd_project.dnd.repository;

import com.dnd_project.dnd.model.CharacterListTable;
import com.dnd_project.dnd.model.CharactersInfo;
import com.dnd_project.dnd.model.UsersCharacters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersCharactersRepository extends JpaRepository<CharacterListTable, Long> {

    @Query("select t.charTable.name as name, t.charTable.charID as charID,  t.charTable.classtable.className as className," +
            " t.charTable.level as level " +
            "from CharacterListTable t where t.userID = :id")
    List<UsersCharacters> searchCharacters(Long id);

}
