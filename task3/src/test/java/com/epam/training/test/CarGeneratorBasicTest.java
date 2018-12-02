package com.epam.training.test;

import com.epam.training.generator.CarGenerator;
import org.testng.annotations.BeforeMethod;

public abstract class CarGeneratorBasicTest {

    protected CarGenerator carGenerator;

    @BeforeMethod
    protected void initializeGenerator(){
        carGenerator= new CarGenerator();
    }
}
