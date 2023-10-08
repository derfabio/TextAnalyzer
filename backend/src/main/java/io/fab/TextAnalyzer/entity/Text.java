package io.fab.TextAnalyzer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "text")
public class Text {
    @Id
    @GeneratedValue
    private Long id;
    private String content;

    public Text(String content) {
        this.content = content;
    }

    public Text() {
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
