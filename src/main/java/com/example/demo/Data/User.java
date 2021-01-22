package com.example.demo.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("name")
    String name;

    @JsonProperty("age")
    int age;

    @JsonProperty("place")
    String place;

    public User(String name, int age, String place) {
        this.name = name;
        this.age = age;
        this.place = place;
    }
}
