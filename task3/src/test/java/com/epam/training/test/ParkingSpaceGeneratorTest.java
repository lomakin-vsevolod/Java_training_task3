package com.epam.training.test;

import com.epam.training.model.Car;
import com.epam.training.model.ParkingSpace;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingSpaceGeneratorTest extends  ParkingSpaceGeneratorBasicTest {

    @Test
    public void testGenerateParkingSpace(){
        ParkingSpace parkingSpace;

        parkingSpace= parkingSpaceGenerator.generateParkingSpace();

        Assert.assertNotNull(parkingSpace);
    }
}
