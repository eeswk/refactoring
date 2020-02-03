package com.swan.obj.call.seconds.extraction;

import java.time.Duration;
import java.time.LocalDateTime;

public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;


    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
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

    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        } else {
            return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
    }

    public static void main(String[] args) {
        NightlyDiscountPhone phone = new NightlyDiscountPhone(Money.wons(2), Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2020, 02, 03, 12, 10, 0),
                LocalDateTime.of(2020, 02, 03, 12, 11, 0 )));
        phone.call(new Call(LocalDateTime.of(2020, 02, 04, 22, 10, 0),
                LocalDateTime.of(2020, 02, 04, 22, 11, 0 )));
        System.out.println(phone.calculateFee().getAmount());
    }
}
