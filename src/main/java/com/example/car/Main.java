package com.example.car;

import com.example.car.service.CarModelService;
import com.example.car.service.CarModelServiceImpl;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final CarModelService carModelService = new CarModelServiceImpl();
        carModelService.load("C:\\Users\\artem\\Downloads\\027_DST_CAR_MODEL (1)(1).csv");
        Map<String, Integer> carsCountByModel = carModelService.getCountCarsGroupByModels();

        for (Map.Entry<String, Integer> entry : carsCountByModel.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + ": " + v);
        }
    }
}
