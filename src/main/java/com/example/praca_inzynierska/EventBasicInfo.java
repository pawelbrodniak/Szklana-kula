package com.example.praca_inzynierska;

import java.time.LocalDateTime;

public class EventBasicInfo {
    private Integer id;
    private String teamA;
    private String teamB;
    private Integer rate;
    private LocalDateTime dateAdded;
    private String author;
    private int voteCount;



    public EventBasicInfo(
            Integer id,
            String teamA,
            String teamB,
            Integer rate,
            LocalDateTime dateAdded,
            String author,
            int voteCount) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
        this.rate = rate;
        this.dateAdded = dateAdded;
        this.author = author;
        this.voteCount = voteCount;


    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}