package com.example.praca_inzynierska.category;

public class CategoryNameDto {
    private Integer id;
    private String name;

    public CategoryNameDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryNameDto(String name, Integer points) {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}