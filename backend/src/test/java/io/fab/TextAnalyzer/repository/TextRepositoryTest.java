package io.fab.TextAnalyzer.repository;

import io.fab.TextAnalyzer.entity.Text;
import io.fab.TextAnalyzer.repository.TextRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class TextRepositoryTest {

    @Autowired
    private TextRepository textRepository;

    @BeforeEach
    public void setUp() {
        // Initialize test data or setup steps can go here
    }

    @Test
    public void testDeleteById() {
        Text text = new Text("Example text");
        text = textRepository.save(text);

        textRepository.deleteById(text.getId());

        Optional<Text> deletedText = textRepository.findTextById(text.getId());
        assertFalse(deletedText.isPresent());
    }

    @Test
    public void testFindTextById() {
        Text text = new Text("Example text");
        text = textRepository.save(text);

        Optional<Text> foundText = textRepository.findTextById(text.getId());

        assertTrue(foundText.isPresent());
        assertThat(foundText.get().getContent()).isEqualTo("Example text");
    }
}
