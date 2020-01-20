package com.swan.obj.datadriven.step2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondtion> discountCondtions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;


    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondtion> getDiscountCondtions() {
        return discountCondtions;
    }

    public void setDiscountCondtions(List<DiscountCondtion> discountCondtions) {
        this.discountCondtions = discountCondtions;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreend, int sequecne) {
        for (DiscountCondtion condtion : discountCondtions) {
            if (condtion.getType() == DiscountConditionType.PERIOD) {
                if (condtion.isDiscountable(whenScreend.getDayOfWeek(), whenScreend.toLocalTime())) {
                    return true;
                }
            } else {
                if (condtion.isDiscountable(sequecne)) {
                    return true;
                }
            }
        }
        return false;
    }
}
