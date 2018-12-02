package com.epam.training.test;

import com.epam.training.generator.ParkingSpaceGenerator;
import com.epam.training.generator.ParkingSpacePoolGenerator;
import org.testng.annotations.BeforeMethod;

public abstract class ParkingSpacePoolGeneratorBasicTest {

    protected ParkingSpacePoolGenerator parkingSpacePoolGenerator;

    @BeforeMethod
    protected void initializeGenerator(){
        parkingSpacePoolGenerator= new ParkingSpacePoolGenerator();
    }
}
