package io.fab.TextAnalyzer.service;

import io.fab.TextAnalyzer.entity.CharacterMap;
import io.fab.TextAnalyzer.entity.CharacterType;
import io.fab.TextAnalyzer.entity.Text;
import io.fab.TextAnalyzer.repository.CharacterMapRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CharacterMapServiceTest {

    @InjectMocks
    private CharacterMapService characterMapService;

    @Mock
    private CharacterMapRepository characterMapRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCharacterOccurrences() {
        String sentence = "Example. sentence.";

        Map<Character, Integer> characterOccurrences = characterMapService.getCharacterOccurrences(sentence);

        assertThat(characterOccurrences).hasSize(10); // 10 unique characters
        assertThat(characterOccurrences.get('e')).isEqualTo(5);
        assertThat(characterOccurrences.get('x')).isEqualTo(1);
    }

    @Test
    public void testSaveCharacterOccurrences() {
        Text text = new Text("Example text");
        Map<Character, Integer> characterOccurrences = new HashMap<>();
        characterOccurrences.put('e', 3);
        characterOccurrences.put('x', 1);
        characterOccurrences.put('y', 0);

        characterMapService.save(characterOccurrences, text);

        verify(characterMapRepository, times(3)).save(any(CharacterMap.class));
    }

    @Test
    public void testGetCharacterType() {
        assertThat(characterMapService.getCharacterType('a')).isEqualTo(CharacterType.VOWEL);
        assertThat(characterMapService.getCharacterType('b')).isEqualTo(CharacterType.CONSONANT);
        assertThat(characterMapService.getCharacterType('1')).isEqualTo(CharacterType.OTHER);
    }

    @Test
    public void testGetCharacterMapsForText() {
        Text text = new Text("Example text");
        CharacterType characterType = CharacterType.VOWEL;
        List<CharacterMap> mockCharacterMaps = List.of(new CharacterMap(), new CharacterMap());

        when(characterMapRepository.findCharacterMapsByCharacterTypeAndText(characterType, text))
                .thenReturn(mockCharacterMaps);

        List<CharacterMap> characterMaps = characterMapService.getCharacterMapsForText(characterType, text);

        assertThat(characterMaps).isEqualTo(mockCharacterMaps);
    }

    @Test
    public void testIsVowel() {
        assertTrue(characterMapService.isVowel('a'));
        assertFalse(characterMapService.isVowel('b'));
    }

    @Test
    public void testIsConsonant() {
        assertTrue(characterMapService.isConsonant('b'));
        assertFalse(characterMapService.isConsonant('a'));
    }
}
