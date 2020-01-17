package com.swan.obj.commandqeury;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    private boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
            !from.toLocalTime().equals(schedule.getFrom()) ||
            !duration.equals(schedule.getDuration())) {
            reschedule(schedule);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Event meeting = new Event("회의",
                LocalDateTime.of(2019, 5, 8, 10, 30),
                Duration.ofMinutes(30));

        RecurringSchedule schedule = new RecurringSchedule("회의",
                DayOfWeek.WEDNESDAY,
                LocalDateTime.of(2019, 5, 8, 10, 30),
                Duration.ofMinutes(30)
                );

        assert meeting.isSatisfied(schedule) == true;

    }
}
