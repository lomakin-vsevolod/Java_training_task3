package com.epam.training.generator;

import com.epam.training.model.Car;
import com.epam.training.model.Parking;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGenerator {

    private static final Logger logger = Logger.getLogger(CarGenerator.class);

    private static final int MAX_WAIT_TIME_MILLIS = 2000;
    private static final int MAX_PARKING_TIME_MILLIS = 400;
    private static final int MAX_CAR_COUNT = 20;

    private static final Random random = new Random();
    private static int idCount = 0;

    private Parking parking;

    public CarGenerator(Parking parking){
        this.parking=parking;
    }

    public Car generateCar(int maxWaitTime, int maxParkingTime){
        Car car = new Car();
        car.setId(generateId());
        car.setMaxWaitTimeMillis(generateMaxWaitTime(maxWaitTime));
        car.setParkTimeMillis(generateParkTime(maxParkingTime));
        car.setParking(getParking());
        return car;
    }

    public Car generateCar(){
        return generateCar(MAX_WAIT_TIME_MILLIS,MAX_PARKING_TIME_MILLIS);
    }

    public List<Car> generateCars(int carMaxCount){
        List<Car> carList = new ArrayList<Car>();
        for (int i=0; i<carMaxCount; i++){
            carList.add(generateCar());
        }
        logger.info("Cars was generated, number of cars=" + carMaxCount);
        return carList;
    }

    public List<Car> generateCars(){
        return generateCars(MAX_CAR_COUNT);
    }

    private int generateId(){
        return ++idCount;
    }

    private Parking getParking(){
        return parking;
    }

    private int generateMaxWaitTime(int maxWaitTime){
        return random.nextInt(maxWaitTime);
    }

    private int generateParkTime(int maxParkingTime){
        return random.nextInt(maxParkingTime);
    }
}
