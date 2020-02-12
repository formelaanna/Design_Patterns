package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Question {

    private final String content;

    private final String description;

    private final List<Answer> answers;

    public Question(String content, String description, List<Answer> answers) {
        this.content = content;
        this.description = description;
        this.answers = answers;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
    static class QuestionBuilder {

        private String content;

        private String description;

        private List<Answer> answers;

        private QuestionBuilder() {
            answers = new LinkedList<>();
        }

        public QuestionBuilder content(String content) {
            this.content = content;
            return this;
        }

        public QuestionBuilder description(String description) {
            this.description = description;
            return this;
        }

        public QuestionBuilder correctAnswer(String answer) {
            answers.add(new Answer(answer, true));
            return this;
        }

        public QuestionBuilder wrongAnswer(String answer) {
            answers.add(new Answer(answer, false));
            return this;
        }

        public QuestionBuilder answers(Stream<Answer> answers) {
            answers.forEach(answer -> this.answers.add(answer));
            return this;
        }

        public Question build() {
            // check if the question is correct
            if (content == null || content.isEmpty()) {
                throw new IllegalArgumentException("Content can't be empty");
            }
            if (description == null) {
                description = "";
            }
            if (answers.size() < 2) {
                throw new IllegalArgumentException("Question must have at least two answers");
            }
            return new Question(content, description, answers);
        }
    }

    public static QuestionBuilder builder() {
        return new QuestionBuilder();
    }



}
