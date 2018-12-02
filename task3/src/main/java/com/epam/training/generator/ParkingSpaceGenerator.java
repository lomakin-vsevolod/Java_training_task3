package com.epam.training.generator;

import com.epam.training.model.ParkingSpace;

public class ParkingSpaceGenerator {
    private static int idCount = 0;

    public ParkingSpaceGenerator(){
    }

    public ParkingSpace generateParkingSpace(){
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(generateId());
        parkingSpace.setUsed(false);
        return parkingSpace;
    }

    private int generateId(){
        return ++idCount;
    }
}
