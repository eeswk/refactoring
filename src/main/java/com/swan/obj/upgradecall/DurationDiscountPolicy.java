package com.swan.obj.upgradecall;

import java.util.List;

public class DurationDiscountPolicy extends BasicRatePolicy {
    private List<DurationDiscountRule> rules;

    public DurationDiscountPolicy(List<DurationDiscountRule> rules) {
        this.rules = rules;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;

        for (DurationDiscountRule rule : rules) {
            Money sum = result.plus(rule.calculate(call));
            System.out.println(sum.getAmount());
            result = sum;
        }
        return result;
    }
}
