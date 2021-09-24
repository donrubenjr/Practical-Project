package view;

import controller.DataAccessController;
import model.Location;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int option = 0;
        boolean isInputValid = true;
        String country = "", region = "", city = "";
        double latitude = 0.0, longitude = 0.0;
        String retrieveCity = "";
        Location location = null;

        do {
            System.out.println();
            System.out.println("\t  Simple Weather Services");
            System.out.println("\t===========================");
            System.out.println("\t[1] Add location");
            System.out.println("\t[2] Display added location");
            System.out.println("\t[3] Download weather values");
            System.out.println("\t[4] Exit");
            System.out.println("\t===========================");

            do {
                System.out.print("\n\tChoose a Transaction: ");
                if (keyboard.hasNextInt()) {
                    option = keyboard.nextInt();
                    keyboard.nextLine();
                    isInputValid = true;
                } else {
                    System.out.println("\n\tError! Invalid options");
                    isInputValid = false;
                    keyboard.next();
                }
            } while (!(isInputValid));

            if (option == 1) {      //insert new location
                System.out.println("\n\tAdd location:");

                do {
                    System.out.print("\tEnter country name: ");
                    country = keyboard.nextLine();
                } while ((!country.matches("[a-zA-Z,]+")) || (country.isEmpty()) || (country.isBlank()));

                do {
                    System.out.print("\tEnter region: ");
                    region = keyboard.nextLine();
                } while ((!region.matches("[a-zA-Z,]+")) || (region.isEmpty()) || (region.isBlank()));

                do {
                    System.out.print("\tEnter city: ");
                    city = keyboard.nextLine();

                    boolean isExist = false;
                    if (isExist = DataAccessController.checkDuplicateCity(city)) {
                        System.out.println("\tThe city name you entered is already exist!");
                        isExist = true;

                    } else {
                        isExist = false;
                    }
                } while ((!city.matches("[a-zA-Z,]+")) || (city.isEmpty()) || (city.isBlank())
                        || DataAccessController.checkDuplicateCity(city));

                do {
                    System.out.print("\tEnter latitude: ");
                    if (keyboard.hasNextDouble()) {
                        latitude = keyboard.nextDouble();
                        if (latitude < -90 || latitude > 90) {
                            System.out.println("\tLatitude Error! Input out of bounds.");
                        } else {
                            break;
                        }
                        isInputValid = true;
                    } else {
                        System.out.println("\tLatitude error! Please enter numeric value.");
                        isInputValid = false;
                        keyboard.next();
                    }
                } while (!(isInputValid) || (latitude < -90) || (latitude > 90));

                do {
                    System.out.print("\tEnter longitude: ");
                    if (keyboard.hasNextDouble()) {
                        longitude = keyboard.nextDouble();
                        if (longitude < -180 || longitude > 180) {
                            System.out.println("\tLongitude Error! Input out of bounds.");
                        } else {
                            break;
                        }
                        isInputValid = true;

                    } else {
                        System.out.println("\tLongitude error! Please enter numeric value.");
                        isInputValid = false;
                        keyboard.next();
                    }
                } while (!(isInputValid) || (longitude < -180) || (longitude > 180));

                //new location added
                location = new Location(country, region, city, latitude, longitude);
                boolean answer = DataAccessController.insertDataToLocation(location);
                if (answer) {
                    System.out.println("\n\tLocation successfully added!");
                } else {
                    System.out.println("Adding location failed!");
                }

            } else if (option == 2) {
                DataAccessController.displayLocation();

            } else if (option == 3) {
                do {
                    System.out.print("\tEnter city: ");
                    try {
                        retrieveCity = keyboard.nextLine();

                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                    }
                } while ((!retrieveCity.matches("[a-zA-Z,]+")) || (retrieveCity.isEmpty()) || (retrieveCity.isBlank()));

            } else if (option == 4) {
                System.out.println("\n\tApplication close!");
                System.out.println("\tThanks for watching, see you all on the next project! Bye!");
                System.exit(0);

            } else if (option < 1 || option > 4) {
                System.out.println("\tPlease enter correct options.");

            } else {
                System.out.println("\nInvalid option!");
            }

        } while (option != 4);

    }

}
