package com.swan.obj.datadriven.step1;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;
        for (DiscountCondtion condtion : movie.getDiscountCondtions()) {
            if (condtion.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreend().getDayOfWeek().equals(condtion.getDayOfWeek()) &&
                        condtion.getStartTime().compareTo(screening.getWhenScreend()) <=0 &&
                        condtion.getEndTime().compareTo(screening.getWhenScreend()) >= 0;

            } else {
                discountable = condtion.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }

        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }

            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
