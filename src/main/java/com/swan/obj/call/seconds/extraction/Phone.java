package com.swan.obj.call.seconds.extraction;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Phone extends AbstractPhone{
    private Money amount;
    private Duration seconds;


    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }

    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2020, 02, 03, 12, 10, 0),
                LocalDateTime.of(2020, 02, 03, 12, 11, 0 )));
        phone.call(new Call(LocalDateTime.of(2020, 02, 04, 12, 10, 0),
                LocalDateTime.of(2020, 02, 04, 12, 11, 0 )));
        System.out.println(phone.calculateFee().getAmount());
    }
}