package edu.neiu.flashcardmaker.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class FlashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "Topic is required")
    @Column(unique = true, length = 100)
    private String topic;

    @NotBlank(message = "Term is required")
    private String term;
    @NotBlank(message = "Definition is required")
    @Size(min = 6, message = "Definition must be at least 6 characters ")
    private String definition;


    private LocalDateTime created;
    private LocalDateTime updated;

    public FlashCard() {
        this.topic = "";
        this.term = "";
        this.definition = "";
    }

    public FlashCard(String topic, String term, String definition) {
        this.topic = topic;
        this.term = term;
        this.definition = definition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDefinition() {
        return definition;
    }

    public String getTerm() {
        return term;
    }

    public String getTopic() {
        return topic;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @PrePersist
    public void onCreate() {
        this.setCreated(LocalDateTime.now());
        this.setUpdated(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.setUpdated(LocalDateTime.now());
    }


}
