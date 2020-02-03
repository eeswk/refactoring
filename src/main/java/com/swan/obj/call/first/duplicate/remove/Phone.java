package com.swan.obj.call.first.duplicate.remove;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 중복코드 제거를 위해 PhoneType enum을 추가함
 */
public class Phone {
    private static final int LATE_NIGHT_HOUR = 22;
    enum PhoneType {REGULAR, NIGHTLY}

    private PhoneType type;

    private Money amount;
    private Money regularAmount;
    private Money nightlyAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
       this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public Phone(Money regularAmount, Money nightlyAmount, Duration seconds) {
       this(PhoneType.NIGHTLY, Money.ZERO, regularAmount, nightlyAmount, seconds);
    }

    public Phone(PhoneType type, Money amount, Money regularAmount, Money nightlyAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
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
            if (type == PhoneType.REGULAR) {
                result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                } else {
                    result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2020, 02, 03, 12, 10, 0),
                LocalDateTime.of(2020, 02, 03, 12, 11, 0 )));
        phone.call(new Call(LocalDateTime.of(2020, 02, 04, 12, 10, 0),
                LocalDateTime.of(2020, 02, 04, 12, 11, 0 )));
        System.out.println(phone.calculateFee().getAmount());

        Phone nightlyPhone = new Phone(Money.wons(5), Money.wons(2), Duration.ofSeconds(10));
        nightlyPhone.call(new Call(LocalDateTime.of(2020, 02, 03, 12, 10, 0),
                LocalDateTime.of(2020, 02, 03, 12, 11, 0 )));
        nightlyPhone.call(new Call(LocalDateTime.of(2020, 02, 04, 22, 10, 0),
                LocalDateTime.of(2020, 02, 04, 22, 11, 0 )));
        System.out.println(nightlyPhone.calculateFee().getAmount());
    }
}