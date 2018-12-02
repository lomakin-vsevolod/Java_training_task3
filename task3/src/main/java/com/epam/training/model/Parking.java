package com.epam.training.model;

public class Parking {
    private int id;
    private  ParkingSpacePool spacePool;

    public Parking(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpacePool getSpacePool() {
        return spacePool;
    }

    public void setSpacePool(ParkingSpacePool spacePool) {
        this.spacePool = spacePool;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", spacePool=" + spacePool +
                '}';
    }
}
