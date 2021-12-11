package com.example.praca_inzynierska.event;

import java.time.LocalDateTime;

public class Event {
    private Integer id;
    private String teamA;
    private String teamB;
    private Integer rate;
    private LocalDateTime dateAdded;
    private Integer categoryId;
    private Integer userId;

    public Event(
                 String teamA,
                 String teamB,
                 Integer rate,
                  LocalDateTime dateAdded,
                 Integer categoryId,
                 Integer userId) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.rate = rate;
        this.dateAdded = dateAdded;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Event(Integer id,
                 String teamA,
                 String teamB,
                 Integer rate,
                 LocalDateTime dateAdded,
                 Integer categoryId,
                 Integer userId) {
        this(teamA, teamB, rate, dateAdded, categoryId, userId);
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }



    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}