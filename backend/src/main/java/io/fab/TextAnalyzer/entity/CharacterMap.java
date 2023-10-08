package io.fab.TextAnalyzer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "character_map")
public class CharacterMap {
    @Id
    @GeneratedValue
    private Long id;
    private char character;
    private int occurrence;
    @Enumerated(EnumType.STRING)
    CharacterType characterType;
    @ManyToOne
    private Text text;

    public CharacterMap() {

    }

    public Long getId() {
        return id;
    }

    public char getCharacter() {
        return character;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public Text getText() {
        return text;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
