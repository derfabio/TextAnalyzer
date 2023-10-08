package io.fab.TextAnalyzer.service;

import io.fab.TextAnalyzer.entity.Text;
import io.fab.TextAnalyzer.repository.TextRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TextServiceTest {

    @InjectMocks
    private TextService textService;

    @Mock
    private TextRepository textRepository;

    @Mock
    private CharacterMapService characterMapService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTexts() {
        List<Text> mockTexts = new ArrayList<>();
        when(textRepository.findAll()).thenReturn(mockTexts);

        List<Text> result = textService.getAllTexts();

        assertThat(result).isEqualTo(mockTexts);
    }

    @Test
    public void testGetTextById() {
        Long textId = 1L;
        Text mockText = new Text("Example text");
        when(textRepository.findTextById(textId)).thenReturn(Optional.of(mockText));

        Optional<Text> result = textService.getTextById(textId);

        assertThat(result).isEqualTo(Optional.of(mockText));
    }

    @Test
    public void testSaveText() {
        Text textToSave = new Text("Example text");

        textService.saveText(textToSave);

        verify(textRepository).save(textToSave);
    }
}
