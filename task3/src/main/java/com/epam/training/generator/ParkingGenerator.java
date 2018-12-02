package com.epam.training.generator;

import com.epam.training.model.Parking;
import org.apache.log4j.Logger;

public class ParkingGenerator {

    private final static Logger logger = Logger.getLogger(ParkingGenerator.class);

    private static int idCount = 0;
    private static final int MAX_SPACES_COUNT = 50;

    private ParkingSpacePoolGenerator parkingSpacePoolGenerator = new ParkingSpacePoolGenerator();

    public ParkingGenerator(){
    }

    public Parking generateParking(int spacePoolSize){
        Parking parking = new Parking();
        parking.setId(generateId());
        parking.setSpacePool(parkingSpacePoolGenerator.generateParkingSpacePool(spacePoolSize));
        logger.info("Generated parking!");
        return parking;
    }

    public Parking generateParking(){
        return generateParking(MAX_SPACES_COUNT);
    }

    private int generateId(){
        return ++idCount;
    }


}
