package com.example.demo.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Health {
    @JsonProperty("key")
    String key;

    @JsonProperty("status")
    String status;

    public Health(String key, String status) {
        this.key = key;
        this.status = status;
    }
}
