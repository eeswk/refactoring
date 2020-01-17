package com.swan.obj.commandqeury;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }
    /* 명령과 쿼리가 함께 있음 reschedule() */
    private boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
            !from.toLocalTime().equals(schedule.getFrom()) ||
            !duration.equals(schedule.getDuration())) {
            //reschedule(schedule);
            return false;
        }
        return true;
    }


    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule)),
                schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long dayDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }

    public static void main(String[] args) {
        RecurringSchedule schedule = new RecurringSchedule("회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30)
        );

        Event meeting = new Event("회의",
                LocalDateTime.of(2019, 5, 9, 10, 30),
                Duration.ofMinutes(30));


        System.out.println(meeting.isSatisfied(schedule));
        System.out.println(meeting.isSatisfied(schedule));
        assert meeting.isSatisfied(schedule) == true;
        assert meeting.isSatisfied(schedule) == false;

    }
}
