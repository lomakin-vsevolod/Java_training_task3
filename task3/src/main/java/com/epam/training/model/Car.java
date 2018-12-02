package com.epam.training.model;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeoutException;

public class Car implements Runnable {

    private final static Logger logger = Logger.getLogger(Car.class);

    private int id;
    private int maxWaitTimeMillis;
    private int parkTimeMillis;
    private Parking parking;

    public Car(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxWaitTimeMillis() {
        return maxWaitTimeMillis;
    }

    public void setMaxWaitTimeMillis(int maxWaitTimeMillis) {
        this.maxWaitTimeMillis = maxWaitTimeMillis;
    }

    public int getParkTimeMillis() {
        return parkTimeMillis;
    }

    public void setParkTimeMillis(int parkTimeMillis) {
        this.parkTimeMillis = parkTimeMillis;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    private ParkingSpace take(Parking parking) throws TimeoutException {
        ParkingSpace space = null;
        space = parking.getSpacePool().getParkingSpace(getMaxWaitTimeMillis());
        logger.info(toString() + " take " + space);
        return space;
    }

    private void leave(Parking parking,ParkingSpace space){
        parking.getSpacePool().returnParkingSpace(space);
        logger.info(toString() + " leave " + space);

    }

    private void using(ParkingSpace space){
        space.useParkingSpace(getParkTimeMillis());
    }

    public void run() {
        ParkingSpace parkingSpace = null;
        logger.info(toString() + "trying to park " + getParking());
        try {
            parkingSpace = take(getParking());
            using(parkingSpace);
        } catch (TimeoutException e) {
            logger.error(toString() +" Parking failed, timeout! ");
        } finally {
            if (parkingSpace != null){
                leave(getParking(),parkingSpace);
            }
        }
        if (parkingSpace == null){
            logger.info(toString() + "not parked!");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", maxWaitTimeMillis=" + maxWaitTimeMillis +
                ", parkTimeMillis=" + parkTimeMillis +
                '}';
    }
}
