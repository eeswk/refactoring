package com.swan.obj.datadriven;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;

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

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }
}
