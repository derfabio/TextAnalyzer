package io.fab.TextAnalyzer.endpoint;

import io.fab.TextAnalyzer.entity.CharacterMap;
import io.fab.TextAnalyzer.entity.CharacterType;
import io.fab.TextAnalyzer.entity.Text;
import io.fab.TextAnalyzer.service.CharacterMapService;
import io.fab.TextAnalyzer.service.TextService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TextEndpoint.class)
class TextEndpointTest {
    @MockBean
    TextService textService;
    @MockBean
    CharacterMapService characterMapService;
    @Autowired
    MockMvc mockMvc;

    String url = "/api/texts";

    @Test
    void getAllTexts() throws Exception {
        String path = url + "/all";

        mockMvc.perform(MockMvcRequestBuilders.get(path)).andExpect(status().isOk());

        Mockito.verify(textService).getAllTexts();
    }

    @Test
    void getCharacterMapsForText() throws Exception {
        Long textId = 1L;
        String characterType = "vowel";
        Text text = new Text("example text");
        List<CharacterMap> characterMaps = new ArrayList<>();

        when(textService.getTextById(textId)).thenReturn(Optional.of(text));
        when(characterMapService.getCharacterMapsForText(CharacterType.VOWEL, text)).thenReturn(characterMaps);

        mockMvc.perform(MockMvcRequestBuilders.get(url + "/" + characterType + "/" + textId)).andExpect(status().isOk());
    }

    @Test
    public void testPostText() throws Exception {
        String jsonTextToSave = "{\"content\":\"example text\"}";

        mockMvc.perform(post(url + "/new").contentType("application/json").content(jsonTextToSave)).andExpect(status().isOk());

        Mockito.verify(textService, times(1)).saveText(any(Text.class));
    }
}