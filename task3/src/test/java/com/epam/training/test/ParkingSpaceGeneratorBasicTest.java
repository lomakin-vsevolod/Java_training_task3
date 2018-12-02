package com.epam.training.test;

import com.epam.training.generator.CarGenerator;
import com.epam.training.generator.ParkingSpaceGenerator;
import org.testng.annotations.BeforeMethod;

public abstract class ParkingSpaceGeneratorBasicTest {

    protected ParkingSpaceGenerator parkingSpaceGenerator;

    @BeforeMethod
    protected void initializeGenerator(){
        parkingSpaceGenerator= new ParkingSpaceGenerator();
    }
}
