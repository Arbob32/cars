package com.example.car;

import com.example.car.dto.CarModelDto;
import com.example.car.service.CarModelService;
import com.example.car.service.CarModelServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final CarModelService carModelService = new CarModelServiceImpl();
        carModelService.load("C:\\Users\\artem\\Downloads\\027_DST_CAR_MODEL (1)(1).csv");
        List<CarModelDto> carList = carModelService.getAllCarModels();
        Map<String, Integer> carsCountByModel = carModelService.getCountCarsGroupByModels();

//        carList.forEach(System.out::println);
        carsCountByModel.forEach((k, v) -> {System.out.println(k + ": " + v);});
    }
}