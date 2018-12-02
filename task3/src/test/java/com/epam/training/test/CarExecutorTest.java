package com.epam.training.test;

import com.epam.training.executor.CarExecutor;
import com.epam.training.generator.CarGenerator;
import com.epam.training.generator.ParkingGenerator;
import com.epam.training.model.Car;
import com.epam.training.model.Parking;
import com.epam.training.model.ParkingSpacePool;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CarExecutorTest extends CarExecutorBasicTest {

    @Test
    public void testExecute(){
        Parking parking = new ParkingGenerator().generateParking();
        List<Car> carsList = new CarGenerator(parking).generateCars();

        carExecutor.execute(carsList);
        carExecutor.shutdown();
        carExecutor.awaitTermination();

        Assert.assertTrue(parking.checkEmptySpaces());
    }

    @DataProvider
    public Object[][] dataTestExecuteWithParams() {
        return new Object[][]{{20,10},{20,20}};
    }

    @Test(dataProvider = "dataTestExecuteWithParams")
    public void testExecuteWithParams(int spacePoolSize,int carMaxCount){
        Parking parking = new ParkingGenerator().generateParking(spacePoolSize);
        List<Car> carsList = new CarGenerator(parking).generateCars(carMaxCount);

        carExecutor.execute(carsList);
        carExecutor.shutdown();
        carExecutor.awaitTermination();

        Assert.assertTrue(parking.checkEmptySpaces());
    }
}
