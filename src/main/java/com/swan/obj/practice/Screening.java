package com.swan.obj.practice;


import java.time.LocalDateTime;

/**
 * 5장 책임 주도 설계
 */
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public Money calculateFee(int audienceCount) {
        return  movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    public Movie getMovie() {
        return movie;
    }


    // Screening이 다른 책임을 갖게 된다. 그리고 PeriodCondition의 속성이 변경시 Screening에도 영향이 발생한다
    // 따라서 좋지 않다.
    /*
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        return whenScreened.getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(whenScreened.toLocalTime()) <= 0 &&
                endTime.compareTo(whenScreened.toLocalTime()) >= 0;
    }
    */
}
