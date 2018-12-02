package com.epam.training.generator;

import com.epam.training.model.ParkingSpace;
import com.epam.training.model.ParkingSpacePool;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingSpacePoolGenerator {
    private final static Logger logger = Logger.getLogger(ParkingSpacePoolGenerator.class);

    private static final int MAX_SPACES_COUNT = 50;

    private static final Random random = new Random();

    private ParkingSpaceGenerator parkingSpaceGenerator = new ParkingSpaceGenerator();

    public ParkingSpacePool generateParkingSpacePool(int maxSpacesCount){
        List<ParkingSpace> parkingSpaceList = new ArrayList<ParkingSpace>();
        for (int i=0;i<generateSpaceCount(maxSpacesCount);i++){
            parkingSpaceList.add(parkingSpaceGenerator.generateParkingSpace());
        }
        ParkingSpacePool parkingSpacePool = new ParkingSpacePool(parkingSpaceList);
        logger.info("Generated ParkingSpacePool maxCount=" +maxSpacesCount+" listSize="+parkingSpaceList.size());
        return parkingSpacePool;
    }

    public ParkingSpacePool generateParkingSpacePool(){
        return generateParkingSpacePool(MAX_SPACES_COUNT);
    }

    private int generateSpaceCount(int maxCount){
        return random.nextInt(maxCount);
    }


}
