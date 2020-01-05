package com.swan.ticket;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
