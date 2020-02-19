package com.swan.obj.school;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

public class GradeLecture extends Lecture {
    private List<Grade> grades;


    public GradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
        super(title, pass, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradeStatistics();
    }

    private String gradeStatistics() {
        return grades.stream()
                .map(grade -> format(grade))
                .collect(joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .count();
    }

    public double avergage(String gradeName) {
        return grades.stream()
                .filter(each -> each.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    @Override
    public String getEvaluationMethod() {
        return "grade";
    }

    public static void main(String[] args) {
        Lecture lecture = new GradeLecture("객체지향 프로그래밍",
                70,
                Arrays.asList(new Grade("A", 100, 95),
                            new Grade("B", 94, 80),
                            new Grade("C", 79, 70),
                            new Grade("D", 69, 50),
                            new Grade("F", 49, 0)),
                Arrays.asList(81, 96, 75, 50, 45, 98));

        System.out.println(lecture.evaluate());
        System.out.println(((GradeLecture) lecture).avergage("A"));

        System.out.println(lecture.stats());
    }

}
