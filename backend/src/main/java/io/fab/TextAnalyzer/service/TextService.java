package io.fab.TextAnalyzer.service;

import io.fab.TextAnalyzer.entity.Text;
import io.fab.TextAnalyzer.repository.TextRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TextService {
    private final TextRepository textRepository;
    private final CharacterMapService characterMapService;

    public TextService(TextRepository textRepository, CharacterMapService characterMapService) {
        this.textRepository = textRepository;
        this.characterMapService = characterMapService;
    }

    public List<Text> getAllTexts() {
        return textRepository.findAll();
    }

    public Optional<Text> getTextById(Long id) {
        return textRepository.findTextById(id);
    }

    public Text saveText(Text text) {
        textRepository.save(text);
        saveCharacterOccurrencesForText(text);
        return text;
    }

    public void saveCharacterOccurrencesForText(Text text) {
        Map<Character, Integer> characterOccurrences = characterMapService.getCharacterOccurrences(text.getContent());
        characterMapService.save(characterOccurrences, text);
    }
}
