package com.epam.training.test;

import com.epam.training.model.Parking;
import com.epam.training.model.ParkingSpacePool;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParkingGeneratorTest extends  ParkingGeneratorBasicTest {

    @Test
    public void testGenerateParking(){
        Parking parking;

        parking = parkingGenerator.generateParking();

        Assert.assertNotNull(parking);
    }

    @DataProvider
    public Object[][] dataGenerateParkingWithParams() {
        return new Object[][]{{20}};
    }

    @Test(dataProvider = "dataGenerateParkingWithParams")
    public void testGenerateCarWithParams(int spacePoolSize){
        Parking parking;

        parking = parkingGenerator.generateParking(spacePoolSize);

        Assert.assertNotNull(parking);
    }

}
