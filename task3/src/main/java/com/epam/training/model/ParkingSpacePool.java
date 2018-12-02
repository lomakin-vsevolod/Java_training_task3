package com.epam.training.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpacePool {

    private final static Logger logger = Logger.getLogger(ParkingSpacePool.class);

    private final int SIZE;
    private final List<ParkingSpace> SPACES = new ArrayList<ParkingSpace>();
    private final Semaphore SEMAPHORE;
    private final Lock LOCK = new ReentrantLock();

    public ParkingSpacePool(List<ParkingSpace> spaces){
        this.SIZE=spaces.size();
        this.SEMAPHORE = new Semaphore(SIZE);
        this.SPACES.addAll(spaces);
    }

    public ParkingSpace getParkingSpace(long maxWaitMillis) throws TimeoutException {
        try {
            if (SEMAPHORE.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)){
                return getItem();
            }
        } catch (InterruptedException e) {
            logger.error("InterruptedException! ParkingSpacePool");
        }
        logger.info("Acquire Timeout exception");
        throw new TimeoutException("Timeout");
    }

    public void returnParkingSpace(ParkingSpace space){
        if(releaseItem(space)){
            SEMAPHORE.release();
        }
    }

    private ParkingSpace getItem() {
        ParkingSpace space = null;
        LOCK.lock();
        try {
            for(int i=0;i<SIZE;i++){
                space = SPACES.get(i);
                if (!space.isUsed()){
                    space.setUsed(true);
                    return space;
                }
            }
        } finally {
            LOCK.unlock();
        }
        return space;
    }

    private  boolean releaseItem(ParkingSpace space){
        LOCK.lock();
        try{
            int index = SPACES.indexOf(space);
            if (index == -1){
                return false;
            }
            if (SPACES.get(index).isUsed()){
                space.setUsed(false);
                return true;
            }
        } finally {
            LOCK.unlock();
        }
        return false;
    }
}
