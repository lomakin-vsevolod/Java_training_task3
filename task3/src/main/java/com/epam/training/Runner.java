package com.epam.training;

import com.epam.training.executor.CarExecutor;
import com.epam.training.generator.CarGenerator;
import com.epam.training.generator.ParkingGenerator;
import com.epam.training.model.Car;
import com.epam.training.model.Parking;

import java.util.List;

public class Runner {

    public static void main(String[] args){
        Parking parking = new ParkingGenerator().generateParking();
        List<Car> carsList = new CarGenerator(parking).generateCars(20);
        CarExecutor carExecutor = new CarExecutor();
        carExecutor.execute(carsList);
    }
}
