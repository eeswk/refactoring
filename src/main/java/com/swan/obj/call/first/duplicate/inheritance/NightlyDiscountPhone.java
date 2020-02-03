package com.swan.obj.call.first.duplicate.inheritance;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 중복코드 제거를 위해 Phone을 상속받음
 */
public class NightlyDiscountPhone extends Phone{
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money amount, Duration seconds, Money nightlyAmount) {
        super(amount, seconds);
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee() {
        Money result = super.calculateFee();

        Money nightlyFee = Money.ZERO;
        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                        getAmount().minus(nightlyAmount).times(
                                call.getDuration().getSeconds() / getSeconds().getSeconds()
                        ));
            }
        }
        // 다른방식의 계산
        return result.minus(nightlyFee);
    }


    public static void main(String[] args) {
        NightlyDiscountPhone phone = new NightlyDiscountPhone(Money.wons(5), Duration.ofSeconds(10), Money.wons(2));
        phone.call(new Call(LocalDateTime.of(2020, 02, 03, 12, 10, 0),
                LocalDateTime.of(2020, 02, 03, 12, 11, 0 )));
        phone.call(new Call(LocalDateTime.of(2020, 02, 04, 22, 10, 0),
                LocalDateTime.of(2020, 02, 04, 22, 11, 0 )));
        System.out.println(phone.calculateFee().getAmount());
    }
}
