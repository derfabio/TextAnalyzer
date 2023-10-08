package io.fab.TextAnalyzer.service;

import io.fab.TextAnalyzer.entity.CharacterMap;
import io.fab.TextAnalyzer.entity.CharacterType;
import io.fab.TextAnalyzer.entity.Text;
import io.fab.TextAnalyzer.repository.CharacterMapRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CharacterMapService {
    CharacterMapRepository characterMapRepository;

    public CharacterMapService(CharacterMapRepository characterMapRepository) {
        this.characterMapRepository = characterMapRepository;
    }

    public Map<Character, Integer> getCharacterOccurrences(String sentence) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        String lowercaseInput = sentence.toLowerCase();
        for (char character : lowercaseInput.toCharArray()) {
            if (Character.isLetter(character)) {
                characterCountMap.put(character, characterCountMap.getOrDefault(character, 0) + 1);
            }
        }
        return characterCountMap;
    }

    public void save(Map<Character, Integer> characterOccurrences, Text text) {
        for (Map.Entry<Character, Integer> entry : characterOccurrences.entrySet()) {
            Character character = entry.getKey();
            Integer occurrences = entry.getValue();
            CharacterMap characterMap = new CharacterMap();
            characterMap.setCharacter(character);
            characterMap.setOccurrence(occurrences);
            characterMap.setCharacterType(getCharacterType(character));
            characterMap.setText(text);
            characterMapRepository.save(characterMap);
        }
    }

    public CharacterType getCharacterType(char character) {
        CharacterType characterType = CharacterType.OTHER;
        if (isVowel(character)) {
            characterType = CharacterType.VOWEL;
        }
        if (isConsonant(character)) {
            characterType = CharacterType.CONSONANT;
        }
        return characterType;
    }

    public List<CharacterMap> getCharacterMapsForText(CharacterType characterType, Text text) {
        return characterMapRepository.findCharacterMapsByCharacterTypeAndText(characterType, text);
    }

    public boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
    public boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1;
    }
}
