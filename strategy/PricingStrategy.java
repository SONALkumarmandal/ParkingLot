package strategy;

import model.ParkingTicket;

public interface PricingStrategy {

    double calculatePrice(ParkingTicket ticket);
}