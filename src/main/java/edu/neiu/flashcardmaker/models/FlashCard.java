package edu.neiu.flashcardmaker.models;

public class FlashCard {
    private String topic;
    private String term;
    private String definition;

    public FlashCard(){
        this.topic = "";
        this.term = "";
        this.definition = "";
    }

    public FlashCard(String topic , String term , String definition) {
        this.topic = topic;
        this.term = term;
        this.definition = definition;
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


}
