package service;

import model.*;
import strategy.PricingStrategy;
import util.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class TicketService {

    private Map<String, ParkingTicket> activeTickets = new HashMap<>();

    private PricingStrategy pricingStrategy;

    public TicketService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public ParkingTicket issueTicket(Vehicle vehicle, ParkingSpot spot) {

        spot.parkVehicle(vehicle);

        String ticketId = IdGenerator.generateId();

        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, spot);

        activeTickets.put(ticketId, ticket);

        return ticket;
    }

    public double closeTicket(String ticketId) {

        ParkingTicket ticket = activeTickets.get(ticketId);

        double price = pricingStrategy.calculatePrice(ticket);

        ticket.getSpot().removeVehicle();

        activeTickets.remove(ticketId);

        return price;
    }
}