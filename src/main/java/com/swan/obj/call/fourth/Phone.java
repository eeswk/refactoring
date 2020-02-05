package com.swan.obj.call.fourth;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

    public void call(Call call) {
        calls.add(call);
    }

    public static void main(String[] args) {
        Phone phone = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        phone.call(new Call(LocalDateTime.of(2020, 02, 04, 12, 10, 0),
                LocalDateTime.of(2020, 02, 04, 12, 11, 0 )));
        Money money = phone.calculateFee();
        System.out.println(money.getAmount());

        Phone phone1 = new Phone(new NightlyDiscountPolicy(Money.wons(10), Money.wons(5), Duration.ofSeconds(10)));
        phone1.call(new Call(LocalDateTime.of(2020, 02, 04, 12, 10, 0),
                LocalDateTime.of(2020, 02, 04, 12, 11, 0 )));
        Money money1 = phone1.calculateFee();
        System.out.println(money1.getAmount());

        Phone phone2 = new Phone(new TaxablePolicy(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)), 0.1d));
        phone2.call(new Call(LocalDateTime.of(2020, 02, 04, 12, 10, 0),
                LocalDateTime.of(2020, 02, 04, 12, 11, 0 )));
        Money money2 = phone2.calculateFee();
        System.out.println(money2.getAmount());

        Phone phone3 = new Phone(new RateDiscountablePolicy(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)), Money.wons(10)));
        phone3.call(new Call(LocalDateTime.of(2020, 02, 04, 12, 10, 0),
                LocalDateTime.of(2020, 02, 04, 12, 11, 0 )));
        Money money3 = phone3.calculateFee();
        System.out.println(money3.getAmount());

        Phone phone4 = new Phone(new RateDiscountablePolicy( new TaxablePolicy(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)),  0.1d), Money.wons(10)));
        phone4.call(new Call(LocalDateTime.of(2020, 02, 04, 12, 10, 0),
                LocalDateTime.of(2020, 02, 04, 12, 11, 0 )));
        Money money4 = phone4.calculateFee();
        System.out.println(money4.getAmount());
    }
}