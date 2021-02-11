package com.academy.beerinventory.web.model;

public class BeerDto {
    private String name;
    private String type;

    public BeerDto(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public BeerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
