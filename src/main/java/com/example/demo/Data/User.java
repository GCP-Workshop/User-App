package com.example.demo.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_db")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @JsonProperty("id")
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    @Column(name = "name", nullable = false)
    private String name;

    @JsonProperty("age")
    @Column(name = "age", nullable = false)
    private int age;

    @JsonProperty("place")
    @Column(name = "place", nullable = false)
    private String place;
}
