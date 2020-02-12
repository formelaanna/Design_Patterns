package com.company;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        // constant number of questions
        Question q1 = Question.builder()
                .content("Question")
                .correctAnswer("Good answer")
                .wrongAnswer("Incorrect answer 1")
                .wrongAnswer("Incorrect answer 2")
                .build();

        // unstable number of questions
        Stream<Answer> answers = Stream.of(new Answer("Correct answer", true), new Answer("Incorrect answer 1", false), new Answer("Incorrect answer 2", false));
        Question q2 = Question.builder()
                .content("Question")
                .description("Hints")
                .answers(answers)
                .build();



    }
}
