package com.example.car.service;

import com.example.car.dto.CarModelDto;
import java.util.List;
import java.util.Map;

public interface CarModelService {
    void load(String path);

    List<CarModelDto> getAllCarModels();

    Map<String, Integer> getCountCarsGroupByModels();
}
