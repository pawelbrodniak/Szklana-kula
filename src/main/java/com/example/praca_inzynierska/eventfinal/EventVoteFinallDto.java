package com.example.praca_inzynierska.eventfinal;

public class EventVoteFinallDto {
    private String username;
    private Integer eventId;
    private String type;

    public EventVoteFinallDto(String username, Integer eventId, String type) {
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