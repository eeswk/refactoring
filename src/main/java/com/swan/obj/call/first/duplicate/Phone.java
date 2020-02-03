package com.swan.obj.call.first.duplicate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 세율 추가 double taxRate
 */
public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    private double taxRate; //세금비율

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = 10;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        //세율적용
        return result.plus(result.times(taxRate));
    }

    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10), 0.1d);
        phone.call(new Call(LocalDateTime.of(2020, 02, 03, 12, 10, 0),
                LocalDateTime.of(2020, 02, 03, 12, 11, 0 )));
        phone.call(new Call(LocalDateTime.of(2020, 02, 04, 12, 10, 0),
                LocalDateTime.of(2020, 02, 04, 12, 11, 0 )));
        System.out.println(phone.calculateFee().getAmount());
    }
}