package com.swan.obj.school;

public class Grade {
    private String name;
    private int uppder, lower;

    public Grade(String name, int uppder, int lower) {
        this.name = name;
        this.uppder = uppder;
        this.lower = lower;
    }

    public String getName() {
        return name;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public boolean include(int score) {
        return score >= lower && score <= uppder;
    }

}
