package com.microservice.consumer.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.consumer.model.dto.TempSensorDTO;
import com.microservice.consumer.service.TempSensorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

    private static final String topicName = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final TempSensorService tempSensorService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, TempSensorService tempSensorService) {
        this.objectMapper = objectMapper;
        this.tempSensorService = tempSensorService;
    }

    @KafkaListener(topics = topicName)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        TempSensorDTO tempSensorDTO = objectMapper.readValue(message, TempSensorDTO.class);
        tempSensorService.persistTempSensor(tempSensorDTO);
    }

}
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//  
//@Component
//  
//// Class
//public class Consumer {
//  
//    @KafkaListener(topics = "NewTopic",
//                   groupId = "group_id")
//  
//    // Method
//    public void
//    consume(String message)
//    {
//        // Print statement
//        System.out.println("message = " + message);
//    }
//}