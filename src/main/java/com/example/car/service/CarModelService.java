package com.example.car.service;

import com.example.car.dto.CarModelDto;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarModelService {
    void load(String path);

    List<CarModelDto> getAllCarModels();

    List<CarModelDto> getAllCarModels(String brandName);

    Map<String, Integer> getCountCarsGroupByModels();

    Optional<CarModelDto> findById(Long id);
}
