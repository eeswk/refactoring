package com.swan.obj.call.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 세금기능 추가 taxRate
 */
public abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }
        //return result;
        return afterCalculated(result);
    }

    protected abstract  Money calculateCallFee(Call call);

    protected abstract Money afterCalculated(Money fee);


    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }
}
