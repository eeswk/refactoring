package com.swan.obj.call.seconds.extraction;

import java.util.ArrayList;
import java.util.List;

/**
 * 세금기능 추가 taxRate
 */
public abstract class Phone {
    private List<Call> calls = new ArrayList<>();
    private double taxRate;

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }
        //return result;
        return result.plus(result.times(taxRate));
    }

    abstract protected Money calculateCallFee(Call call);


    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }
}
