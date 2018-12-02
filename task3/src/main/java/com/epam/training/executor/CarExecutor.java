package com.epam.training.executor;

import com.epam.training.model.Car;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarExecutor {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public CarExecutor(){
    }

    public void execute(List<Car> carList){
        for (Car car : carList){
            executorService.execute(car);
        }
    }

    public void execute(Car car){
        executorService.execute(car);
    }

    public void shutdown(){
        executorService.shutdown();
    }
}
