package com.example.car.service;

import com.example.car.dto.CarModelDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
public class CarModelServiceImpl implements CarModelService {
    private final List<CarModelDto> carModels = new ArrayList<>();
    private Long id = 0L;

    @Override
    public void load(String p) {
        Path path = Paths.get(p);
        try (CSVParser parser = CSVFormat.DEFAULT.withDelimiter(';').parse(new FileReader(path.toFile()))) {
            Iterator<CSVRecord> iterator = parser.iterator();
            if (iterator.hasNext()) {
                iterator.next();
            }

            for (CSVRecord record : parser) {
                CarModelDto carModel = new CarModelDto(id++, record.get(0), record.get(1), record.get(2), record.get(3));
                carModels.add(carModel);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<CarModelDto> getAllCarModels() {
        return carModels;
    }

    @Override
    public Map<String, Integer> getCountCarsGroupByModels() {
        Map<String, Integer> countCarsGroupByModels = new HashMap<>();
        for (CarModelDto carModel : carModels) {
            String model = carModel.getModel();
            countCarsGroupByModels.put(model, countCarsGroupByModels.getOrDefault(model, 0) + 1);
        }
        return countCarsGroupByModels;
    }
}
