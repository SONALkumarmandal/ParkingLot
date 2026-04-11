package service;

import enums.SpotType;
import enums.VehicleType;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {

    private List<ParkingSpot> spots = new ArrayList<>();

    public ParkingLotService() {

        for (int i = 1; i <= 5; i++)
            spots.add(new ParkingSpot(i, SpotType.SMALL));

        for (int i = 6; i <= 10; i++)
            spots.add(new ParkingSpot(i, SpotType.MEDIUM));

        for (int i = 11; i <= 15; i++)
            spots.add(new ParkingSpot(i, SpotType.LARGE));
    }

    public ParkingSpot getAvailableSpot(Vehicle vehicle) {

        for (ParkingSpot spot : spots) {

            if (!spot.isOccupied()) {

                if (vehicle.getType() == VehicleType.BIKE && spot.getType() == SpotType.SMALL)
                    return spot;

                if (vehicle.getType() == VehicleType.CAR && spot.getType() == SpotType.MEDIUM)
                    return spot;

                if (vehicle.getType() == VehicleType.TRUCK && spot.getType() == SpotType.LARGE)
                    return spot;
            }
        }

        return null;
    }
}