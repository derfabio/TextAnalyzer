package io.fab.TextAnalyzer.repository;

import io.fab.TextAnalyzer.entity.CharacterMap;
import io.fab.TextAnalyzer.entity.CharacterType;
import io.fab.TextAnalyzer.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterMapRepository extends JpaRepository<CharacterMap, Long> {
    List <CharacterMap> findCharacterMapsByCharacterTypeAndText(CharacterType characterType, Text text);
}
