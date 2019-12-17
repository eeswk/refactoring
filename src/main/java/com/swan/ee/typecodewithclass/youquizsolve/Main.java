package com.swan.ee.typecodewithclass.youquizsolve;

public class Main {
    public static void main(String[] args) {
        LunchSet lunchSet = new LunchSet(LunchType.A, DrinkType.COFFEE);
        System.out.println(lunchSet.toString());
    }
}
