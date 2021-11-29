package com.example.praca_inzynierska;

public class EventVote {
    private String username;
    private Integer eventId;
    private String type;

    public EventVote(String username, Integer eventId, String type) {
        this.username = username;
        this.eventId = eventId;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public Integer getEventId() {
        return eventId;
    }

    public String getType() {
        return type;
    }
}