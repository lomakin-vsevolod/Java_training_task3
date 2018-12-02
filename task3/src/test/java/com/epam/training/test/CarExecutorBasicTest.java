package com.epam.training.test;

import com.epam.training.executor.CarExecutor;
import org.testng.annotations.BeforeMethod;

public abstract class CarExecutorBasicTest {

    protected CarExecutor carExecutor;

    @BeforeMethod
    protected void initializeExecutor(){
        carExecutor= new CarExecutor();
    }
}
