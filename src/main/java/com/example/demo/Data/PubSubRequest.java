package com.example.demo.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PubSubRequest {
    @JsonProperty("message")
    private PubSubMessage pubSubMessage;

    public PubSubMessage getPubSubMessage() {
        return pubSubMessage;
    }
}
