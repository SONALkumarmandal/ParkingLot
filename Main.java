import enums.VehicleType;
import factory.VehicleFactory;
import model.*;
import service.*;
import strategy.HourlyPricingStrategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ParkingLotService lotService = new ParkingLotService();
        TicketService ticketService = new TicketService(new HourlyPricingStrategy());

        while (true) {

            System.out.println("\n===== Parking Lot System =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Exit Program");
            System.out.print("Enter Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter Vehicle Type:");
                    System.out.println("1. Bike");
                    System.out.println("2. Car");
                    System.out.println("3. Truck");

                    int typeInput = scanner.nextInt();
                    VehicleType type = null;

                    if (typeInput == 1) type = VehicleType.BIKE;
                    else if (typeInput == 2) type = VehicleType.CAR;
                    else if (typeInput == 3) type = VehicleType.TRUCK;
                    else {
                        System.out.println("Invalid vehicle type!");
                        break;
                    }

                    System.out.print("Enter License Plate: ");
                    String license = scanner.next();

                    Vehicle vehicle = VehicleFactory.createVehicle(type, license);

                    ParkingSpot spot = lotService.getAvailableSpot(vehicle);

                    if (spot == null) {
                        System.out.println("Parking Lot Full!");
                        break;
                    }

                    ParkingTicket ticket = ticketService.issueTicket(vehicle, spot);

                    System.out.println("\nVehicle Parked Successfully!");
                    System.out.println("Spot Number: " + spot.getSpotId());
                    System.out.println("Ticket ID: " + ticket.getTicketId());

                    break;

                case 2:

                    System.out.print("Enter Ticket ID: ");
                    String ticketId = scanner.next();

                    try {

                        double price = ticketService.closeTicket(ticketId);

                        System.out.println("\nVehicle Exited Successfully!");
                        System.out.println("Parking Fee: " + price);

                    } catch (Exception e) {

                        System.out.println("Invalid Ticket ID!");

                    }

                    break;

                case 3:

                    System.out.println("Exiting Parking Lot System...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}