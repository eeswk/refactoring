package com.swan.obj.upgradecall;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeOfDayDiscountPolicyTest {

    @Test
    public void TimeOfDayCalculate() {
        DateTimeInterval dateTimeInterval = DateTimeInterval.of(LocalDateTime.of(2020, 02, 18, 18, 50, 00),
                LocalDateTime.of(2020, 02, 18, 19, 10, 00));

        Call call = new Call(dateTimeInterval);

        BasicRatePolicy tiemDiscountPolicy = new FixedFeePolicy(Money.wons(10), Duration.ofSeconds(10));
        System.out.println(tiemDiscountPolicy.calculateCallFee(call).getAmount());

        List<LocalTime> starts = Arrays.asList(LocalTime.of(00,00), LocalTime.of(19,00));
        List<LocalTime> ends = Arrays.asList(LocalTime.of(19,00), LocalTime.of(23,59));
        List<Duration> durations = Arrays.asList(Duration.ofSeconds(10), Duration.ofSeconds(10));
        List<Money> amounts = Arrays.asList(Money.wons(18), Money.wons(15));
        tiemDiscountPolicy = new TimeOfDayDiscountPolicy(starts, ends, durations, amounts);
        System.out.println(tiemDiscountPolicy.calculateCallFee(call).getAmount());

        assertEquals(BigDecimal.valueOf(1980.0), tiemDiscountPolicy.calculateCallFee(call).getAmount());
    }
}
