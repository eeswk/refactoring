package com.swan.obj.datadriven.step2;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreend;


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public LocalDateTime getWhenScreend() {
        return whenScreend;
    }

    public void setWhenScreend(LocalDateTime whenScreend) {
        this.whenScreend = whenScreend;
    }

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                if (movie.isDiscountable(whenScreend, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
                break;
            case PERCENT_DISCOUNT:
                if (movie.isDiscountable(whenScreend, sequence)) {
                    return movie.calculatePercentDiscountFee().times(audienceCount);
                }
                break;
            case NONE_DISCOUNT:
                return movie.calculateNoneDiscountFee().times(audienceCount);
        }

        return movie.calculateNoneDiscountFee().times(audienceCount);
    }
}
