package com.epam.training.test;

import com.epam.training.generator.ParkingGenerator;
import com.epam.training.generator.ParkingSpacePoolGenerator;
import org.testng.annotations.BeforeMethod;

public abstract class ParkingGeneratorBasicTest {

    protected ParkingGenerator parkingGenerator;

    @BeforeMethod
    protected void initializeGenerator(){
        parkingGenerator= new ParkingGenerator();
    }
}
