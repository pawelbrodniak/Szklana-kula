package com.example.praca_inzynierska.event;

public class EventSaveRequestDto {
    private String teamA;
    private String teamB;
    private Integer rate;
    private Integer categoryId;
    private String author;

    public EventSaveRequestDto(String teamA,
                               String teamB,
                               Integer rate,
                               Integer categoryId,
                               String author) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.rate = rate;
        this.categoryId = categoryId;
        this.author = author;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}