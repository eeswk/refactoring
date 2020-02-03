package com.swan.obj.call.first.duplicate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    private List<Call> calls = new ArrayList<>();

    private double taxRate;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getNightlyAmount() {
        return nightlyAmount;
    }

    public Money getRegularAmount() {
        return regularAmount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }

        return result.plus(result.times(taxRate));
    }

    public static void main(String[] args) {
        NightlyDiscountPhone phone = new NightlyDiscountPhone(Money.wons(2), Money.wons(5), Duration.ofSeconds(10), 0.1d);
        phone.call(new Call(LocalDateTime.of(2020, 02, 03, 12, 10, 0),
                LocalDateTime.of(2020, 02, 03, 12, 11, 0 )));
        phone.call(new Call(LocalDateTime.of(2020, 02, 04, 22, 10, 0),
                LocalDateTime.of(2020, 02, 04, 22, 11, 0 )));
        System.out.println(phone.calculateFee().getAmount());
    }
}
