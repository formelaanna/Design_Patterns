package com.company;

public class Answer {

    private final String content;
    private final boolean correct;

    public Answer(String content, boolean correct) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Answer need content");
        }
        this.content = content;
        this.correct = correct;
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }

}
