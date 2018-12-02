package com.epam.training.test;

import com.epam.training.model.Car;
import com.epam.training.model.ParkingSpacePool;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParkingSpacePoolGeneratorTest extends ParkingSpacePoolGeneratorBasicTest {

    @Test
    public void testGenerateParkingSpacePool(){
        ParkingSpacePool parkingSpacePool;

        parkingSpacePool = parkingSpacePoolGenerator.generateParkingSpacePool();

        Assert.assertNotNull(parkingSpacePool);
    }

    @DataProvider
    public Object[][] dataGenerateParkingSpacePoolWithParams() {
        return new Object[][]{{20}};
    }

    @Test(dataProvider = "dataGenerateParkingSpacePoolWithParams")
    public void testGenerateCarWithParams(int maxSpacesCount){
        ParkingSpacePool parkingSpacePool;

        parkingSpacePool = parkingSpacePoolGenerator.generateParkingSpacePool(maxSpacesCount);

        Assert.assertNotNull(parkingSpacePool);
    }
}
