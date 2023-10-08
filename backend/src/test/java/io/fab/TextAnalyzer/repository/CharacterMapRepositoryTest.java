package io.fab.TextAnalyzer.repository;

import io.fab.TextAnalyzer.entity.CharacterMap;
import io.fab.TextAnalyzer.entity.CharacterType;
import io.fab.TextAnalyzer.entity.Text;
import io.fab.TextAnalyzer.repository.CharacterMapRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class CharacterMapRepositoryTest {

    @Autowired
    private CharacterMapRepository characterMapRepository;

    @Autowired
    private TextRepository textRepository;

    @Test
    public void testFindCharacterMapsByCharacterTypeAndText() {
        CharacterType vowel = CharacterType.VOWEL;
        CharacterType consonant = CharacterType.CONSONANT;
        Text text = new Text("example text");
        textRepository.save(text);
        CharacterMap characterMap1 = new CharacterMap();
        characterMap1.setCharacterType(vowel);
        characterMap1.setText(text);
        CharacterMap characterMap2 = new CharacterMap();
        characterMap2.setCharacterType(consonant);
        characterMap2.setText(text);
        characterMapRepository.save(characterMap1);
        characterMapRepository.save(characterMap2);

        List<CharacterMap> foundCharacterMaps = characterMapRepository.findCharacterMapsByCharacterTypeAndText(vowel, text);

        assertThat(foundCharacterMaps).isNotEmpty();
        assertThat(foundCharacterMaps.size()).isEqualTo(1);
    }
}
