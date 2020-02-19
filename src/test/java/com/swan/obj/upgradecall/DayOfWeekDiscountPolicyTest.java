package com.swan.obj.upgradecall;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekDiscountPolicyTest {


    @Test
    public void calculateCallFeeTest() {
        DateTimeInterval dateTimeInterval = DateTimeInterval.of(LocalDateTime.of(2020, 02, 18, 18, 50, 00),
                LocalDateTime.of(2020, 02, 18, 19, 10, 00));
        Call call = new Call(dateTimeInterval);

        DayOfWeekDiscountRule weekdayRule = new DayOfWeekDiscountRule(Arrays.asList(DayOfWeek.of(1),DayOfWeek.of(2),DayOfWeek.of(3),
                DayOfWeek.of(4),DayOfWeek.of(5)), Duration.ofSeconds(10), Money.wons(38));
        DayOfWeekDiscountRule weekendRule = new DayOfWeekDiscountRule(Arrays.asList(DayOfWeek.of(6),DayOfWeek.of(7)), Duration.ofSeconds(10), Money.wons(19));

        List<DayOfWeekDiscountRule> rule = Arrays.asList(weekdayRule, weekendRule);
        BasicRatePolicy dayOfWeekDiscountPolicy = new DayOfWeekDiscountPolicy(rule);
        Money money = dayOfWeekDiscountPolicy.calculateCallFee(call);

        assertEquals(BigDecimal.valueOf(4560.0), money.getAmount());

    }
}