package com.epam.training.model;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class ParkingSpace {

    private final static Logger logger = Logger.getLogger(ParkingSpace.class);

    private int id;
    private volatile boolean isUsed;

    public ParkingSpace() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public void useParkingSpace(int useTimeMillis){
        try {
            TimeUnit.MILLISECONDS.sleep(useTimeMillis);
        } catch (InterruptedException e) {
            logger.error("InterruptedException! ParkingSpace id is "+ getId());
        }
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "id=" + id +
                ", isUsed=" + isUsed +
                '}';
    }
}
