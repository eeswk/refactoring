package com.swan.obj.school;

import java.util.Arrays;

public class Professor {
    private String name;
    private Lecture lecture;

    public Professor(String name, Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }

    public String compileStatistics() {
        return String.format("[%s] %s - Avg: %.1f", name, lecture.evaluate(), lecture.average());
    }

    public static void main(String[] args) {
        Professor professor = new Professor("다니엘",
                                                new Lecture("알고리즘",
                                                        70,
                                                        Arrays.asList(81, 95, 75, 50, 45)));

        System.out.println(professor.compileStatistics());

        professor = new Professor("다니엘",
                new GradeLecture("알고리즘",
                        70,
                        Arrays.asList(new Grade("A", 100, 95),
                                new Grade("B", 94, 80),
                                new Grade("C", 79, 70),
                                new Grade("D", 69, 50),
                                new Grade("F", 49, 0)),
                        Arrays.asList(81, 95, 75, 50, 45)));

        System.out.println(professor.compileStatistics());


        FormattedGradeLecture lecture =  new FormattedGradeLecture("알고리즘",
                        70,
                        Arrays.asList(new Grade("A", 100, 95),
                                new Grade("B", 94, 80),
                                new Grade("C", 79, 70),
                                new Grade("D", 69, 50),
                                new Grade("F", 49, 0)),
                        Arrays.asList(81, 95, 75, 50, 45));

        System.out.println(lecture.formatAverage());
    }
}
