package com.epam.training.test;

import com.epam.training.generator.CarGenerator;
import com.epam.training.model.Car;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CarGeneratorTest extends CarGeneratorBasicTest {

    @Test
    public void testGenerateCar(){
        Car car;

        car=carGenerator.generateCar();

        Assert.assertNotNull(car);
    }


    @DataProvider
    public Object[][] dataGenerateCarWithParams() {
        return new Object[][]{{2000,200}};
    }

    @Test(dataProvider = "dataGenerateCarWithParams")
    public void testGenerateCarWithParams(int maxWaitTime,int maxParkingTime){
        Car car;

        car=carGenerator.generateCar(maxWaitTime,maxParkingTime);

        Assert.assertNotNull(car);
    }

    @Test
    public void testGenerateCars(){
        List<Car> carList;

        carList = carGenerator.generateCars();

        Assert.assertNotNull(carList);
    }

    @DataProvider
    public Object[][] dataGenerateCarsWithParams() {
        return new Object[][]{{10}};
    }

    @Test(dataProvider = "dataGenerateCarsWithParams")
    public void testGenerateCarsWithParams(int carMaxCount){
        List<Car> carList;

        carList = carGenerator.generateCars(carMaxCount);

        Assert.assertNotNull(carList);
    }

}
