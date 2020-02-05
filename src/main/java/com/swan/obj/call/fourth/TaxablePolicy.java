package com.swan.obj.call.fourth;

public class TaxablePolicy extends AdditionalRatePolicy {
    private double taxRate;

    public TaxablePolicy(RatePolicy next, double taxRate) {
        super(next);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculate(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
