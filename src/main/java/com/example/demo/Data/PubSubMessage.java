package com.example.demo.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Base64;

public class PubSubMessage {
    @JsonProperty("data")
    private String data;

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("message_id")
    private String message_id;

    @JsonProperty("publishTime")
    private String publishTime;

    @JsonProperty("publish_time")
    private String publish_time;

    public String getBase64DecodedData() {
        return new String(Base64.getDecoder().decode(data));
    }
}
