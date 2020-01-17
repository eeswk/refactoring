package com.swan.obj.commandqeury;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class RecurringSchedule {
    private String subject;
    private DayOfWeek dayOfWeek;
    private LocalDateTime from;
    private Duration duration;

    public RecurringSchedule(String subject, DayOfWeek dayOfWeek, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.duration = duration;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public Duration getDuration() {
        return duration;
    }
}
