package io.fab.TextAnalyzer.endpoint;

import io.fab.TextAnalyzer.entity.CharacterMap;
import io.fab.TextAnalyzer.entity.CharacterType;
import io.fab.TextAnalyzer.entity.Text;
import io.fab.TextAnalyzer.service.CharacterMapService;
import io.fab.TextAnalyzer.service.TextService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/texts")
public class TextEndpoint{
    private final TextService textService;
    private final CharacterMapService characterMapService;

    public TextEndpoint(TextService textService, CharacterMapService characterMapService) {
        this.textService = textService;
        this.characterMapService = characterMapService;
    }

    @GetMapping(value = "/all")
    public List<Text> getAllTexts() {
        return textService.getAllTexts();
    }

    @GetMapping(value = "/{character_type}/{id}")
    public List<CharacterMap> getCharacterMapsForText(@PathVariable("id") Long textId, @PathVariable("character_type") String characterType) throws ChangeSetPersister.NotFoundException {
        Text text = textService.getTextById(textId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        if (characterType.equals("vowel")) {
            return characterMapService.getCharacterMapsForText(CharacterType.VOWEL, text);
        };
        return characterMapService.getCharacterMapsForText(CharacterType.CONSONANT, text);
    }

    @PostMapping(value = "/new")
    public void postText(@RequestBody Text text) {
        textService.saveText(text);
    }
}
