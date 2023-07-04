package com.microservice.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.microservice.consumer.model.TempSensor;
import com.microservice.consumer.model.dto.TempSensorDTO;
import com.microservice.consumer.repository.TempSensorRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TempSensorService {

    private final TempSensorRepository tempSensorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TempSensorService(TempSensorRepository tempSensorRepository, ModelMapper modelMapper) {
        this.tempSensorRepository = tempSensorRepository;
        this.modelMapper = modelMapper;
    }

    public void persistTempSensor(TempSensorDTO tempSensorDTO) {
        TempSensor tempSensor = modelMapper.map(tempSensorDTO, TempSensor.class);
        TempSensor persistedTempSensor = tempSensorRepository.save(tempSensor);

        log.info("temp sensor persisted {}", persistedTempSensor);
    }

}