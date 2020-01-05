package com.swan.ticket;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
