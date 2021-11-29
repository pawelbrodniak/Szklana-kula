package com.example.praca_inzynierska;

public class CategoryFullInfo {
    private Integer id;
    private String name;


    public CategoryFullInfo(Integer id, String name) {
        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}