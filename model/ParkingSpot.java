package model;

import enums.SpotType;

public class ParkingSpot {

    private int spotId;
    private SpotType type;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, SpotType type) {
        this.spotId = spotId;
        this.type = type;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public SpotType getType() {
        return type;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    public int getSpotId() {
        return spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}