package com.example.praca_inzynierska;

import java.time.LocalDateTime;

public class Vote {
    private Integer userId;
    private Integer eventId;
    private Type type;
    private LocalDateTime dateAdded;

    public Vote(Integer userId, Integer eventId, Type type, LocalDateTime dateAdded) {
        this.userId = userId;
        this.eventId = eventId;
        this.type = type;
        this.dateAdded = dateAdded;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public enum Type {
        TEAMA, DRAW, TEAMB;
    }
}