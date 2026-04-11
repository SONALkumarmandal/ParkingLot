package strategy;

import model.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(ParkingTicket ticket) {

        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();

        if (hours == 0) hours = 1;

        return hours * 20;
    }
}