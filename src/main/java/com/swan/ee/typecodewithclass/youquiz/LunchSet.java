package com.swan.ee.typecodewithclass.youquiz;

public class LunchSet {
    public static final int LUNCH_TYPE_A = 0;
    public static final int LUNCH_TYPE_B = 1;
    public static final int LUNCH_TYPE_C = 2;
    public static final int LUNCH_TYPE_COFFEE = 0;
    public static final int LUNCH_TYPE_JUICE = 1;
    public static final int LUNCH_TYPE_TEA = 2;

    private final int _lunchType;
    private final int _drinkType;

    public LunchSet(int lunchType, int drinkType) {
        this._lunchType = lunchType;
        this._drinkType = drinkType;
    }
}
