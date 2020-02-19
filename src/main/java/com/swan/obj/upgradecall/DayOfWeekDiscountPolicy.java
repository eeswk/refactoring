package com.swan.obj.upgradecall;

import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy {
    private List<DayOfWeekDiscountRule> rules  = new ArrayList<>();

    public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> rules) {
        this.rules = rules;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;

        for (DateTimeInterval interval : call.splitByDay()) {
            for (DayOfWeekDiscountRule rule: rules) {
                Money sum = result.plus(rule.calculate(interval));
                result = sum;
            }
        }

        return result;
    }
}
