package com.microservice.consumer.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class TempSensorDTO {

    private String temp;
    
    @JsonCreator
    public TempSensorDTO(@JsonProperty("temp") String temp) {
        this.temp = temp;
    }
}