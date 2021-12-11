package com.example.praca_inzynierska.vote;

public class EventVoteDto {
    private String username;
    private Integer eventId;
    private String type;

    public EventVoteDto(String username, Integer eventId, String type) {
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