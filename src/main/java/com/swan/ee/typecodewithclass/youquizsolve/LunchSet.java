package com.swan.ee.typecodewithclass.youquizsolve;

public class LunchSet {

    private final LunchType lunchType;
    private final DrinkType drinkType;

    public LunchSet(LunchType lunchType, DrinkType drinkType) {
        this.lunchType = lunchType;
        this.drinkType = drinkType;
    }

    @Override
    public String toString() {
        return "LunchSet{" +
                "lunchType=" + lunchType +
                ", drinkType=" + drinkType +
                '}';
    }
}
