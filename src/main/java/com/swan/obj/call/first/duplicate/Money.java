package com.swan.obj.call.first.duplicate;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public static final Money ZERO = Money.won(0);

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    private static Money won(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    private static Money won(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(int amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public Money minus(double amount) {
        return new Money(this.amount.subtract(BigDecimal.valueOf(amount)));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }
}
