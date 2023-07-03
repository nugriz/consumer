package com.microservice.consumer.repository;

import com.microservice.consumer.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempSensorRepository extends JpaRepository<TempSensor, Long> {
}