package com.swan.obj.datadriven.step1;

import java.time.Duration;
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
}
