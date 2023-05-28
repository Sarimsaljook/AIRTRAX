import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<String> passengers = new ArrayList<>();

    public static int indexIDCounter = -1;

    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("WELCOME TO AIRTRAX!");
        System.out.println("The All in one CLI for all standard flight system modifications.");
        System.out.println("If you need it please enter 'Help' for a list of system commands");
        System.out.println("----------------------------------");

        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.next();

        setSwitchCase(userInput);

        setUserInput();
    }

    public static void setSwitchCase(String userInput) {

        Scanner scanner = new Scanner(System.in);

        switch (userInput) {
            case "Help" -> {
                System.out.println("----------------------------------");
                System.out.println("You may enter various commands to help add, update, delete or check in passengers");
                System.out.println("These Commands include 'Add/Update/Remove/Check In' Passenger, +\n 'Get Customers/Customer' ");
                System.out.println("----------------------------------");
            }
            case "addPassenger" -> {
                System.out.println("----------------------------------");
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.println("Email: ");
                String email = scanner.next();
                System.out.println("Phone Number: ");
                String phoneNumber = scanner.next();
                System.out.println("Flight Date: ");
                String date = scanner.next();
                System.out.println("Flight Number: ");
                String flightNumber = scanner.next();
                System.out.println("PNR Number: ");
                String PNR = scanner.next();
                indexIDCounter++;
                String customerRecord = "CUSTOMER ID: " + indexIDCounter + ", Name: " + name + ", Email: " + email + ", Phone Number: " + phoneNumber + ", Flight Date: " + date + ", Flight Number: " + flightNumber + ", Passport Number: " + PNR;
                passengers.add(customerRecord);
                System.out.println("Passenger: " + name + ", " + email + ", " + phoneNumber + ", " + date + ", " + flightNumber + ", " + PNR);
                System.out.println("CUSTOMER ID: " + indexIDCounter + ", " + name + " ADDED AS A PASSENGER TO FLIGHT " + flightNumber + " ON " + date);
                System.out.println("----------------------------------");
            }
            case "getCustomers" -> System.out.println(passengers);
            case "getCustomer" -> {
                System.out.println("----------------------------------");
                System.out.println("Customer ID: ");
                String customerID = scanner.next();
                System.out.println(passengers.get(Integer.parseInt(customerID)));
                System.out.println("----------------------------------");
            }
            case "removeCustomer" -> {
                System.out.println("----------------------------------");
                System.out.println("Customer ID: ");
                String customerID = scanner.next();
                passengers.remove(Integer.parseInt(customerID));
                System.out.println("PASSENGER REMOVED SUCCESSFULLY!");
                System.out.println("----------------------------------");
            }
            case "checkInPassenger" -> {
                System.out.println("----------------------------------");
                System.out.println("Customer ID: ");
                String customerID = scanner.next();

                String customer = passengers.get(Integer.parseInt(customerID));

                passengers.remove(Integer.parseInt(customerID));
                passengers.add(Integer.parseInt(customerID), customer + ", status: CHECKED IN");
            }
            case "updatePassenger" -> {
                System.out.println("----------------------------------");
                System.out.println("Customer ID: ");
                String customerID = scanner.next();

                System.out.println("Updated Name: ");
                String name = scanner.next();
                System.out.println("Updated Email: ");
                String email = scanner.next();
                System.out.println("Updated Phone Number: ");
                String phoneNumber = scanner.next();
                System.out.println("Updated Flight Date: ");
                String date = scanner.next();
                System.out.println("Updated Flight Number: ");
                String flightNumber = scanner.next();
                System.out.println("Updated PNR Number: ");
                String PNR = scanner.next();

                String customerRecord = customerID + ", " + name + ", " + email + ", " + phoneNumber + ", " + date + ", " + flightNumber + ", " + PNR;

                passengers.remove(Integer.parseInt(customerID));
                passengers.add(Integer.parseInt(customerID), customerRecord);
                System.out.println(name + "'s" + " CUSTOMER RECORD UPDATED SUCCESSFULLY!");
            }
            default -> {
                System.out.println("----------------------------------");
                System.out.println("The Following command does not exist");
                System.out.println("----------------------------------");
            }
        }
    }

    public static void setUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        setSwitchCase(userInput);

        setUserInput();
    }
}