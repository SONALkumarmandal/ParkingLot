package factory;

import enums.VehicleType;
import model.*;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType type, String license) {

        switch (type) {
            case BIKE:
                return new Bike(license);

            case CAR:
                return new Car(license);

            case TRUCK:
                return new Truck(license);

            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}