package io.fab.TextAnalyzer.repository;

import io.fab.TextAnalyzer.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TextRepository extends JpaRepository<Text, Long> {
    Optional<Text> findTextById(Long id);
}

