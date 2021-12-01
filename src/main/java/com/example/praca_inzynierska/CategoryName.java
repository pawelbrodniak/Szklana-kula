package com.example.praca_inzynierska;

public class CategoryName {
    private Integer id;
    private String name;

    public CategoryName(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryName(String name, Integer points) {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}