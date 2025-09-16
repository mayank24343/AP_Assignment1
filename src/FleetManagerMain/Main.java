package FleetManagerMain;

import Vehicles.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static FleetManager FM = new FleetManager();

    public static void main(String[] args) {
        CLI();
    }

    public static void CLI(){
        String menu = "MENU\n1. Add Vehicle\n2. Remove Vehicle\n3. Start Journey\n4. Refuel All\n5. Perform Maintenance\n6. Generate Report\n7. Save Fleet\n8. Load Fleet\n9. Search by Type\n10. List Vehicles Needing Maintenance\n11.Exit\nPlease Enter Your Choice Number: ";
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println(menu);
            if (input.hasNextInt()){
                int i = input.nextInt();
                input.nextLine();
                if (i >= 1 && i<= 11){
                    //these simply return
                    if (i == 11){
                        System.out.println("Program Exited.\n");
                        break;
                    }
                    else if (i == 5){
                        System.out.println("PERFORM MAINTENANCE\n");
                        FM.maintainAll();
                        System.out.println("Maintenance Complete.\n");
                    }
                    else if (i == 6){
                        System.out.println("GENERATE REPORT\n");
                        String report = FM.generateReport();
                        System.out.println("Report Generated:\n");
                        System.out.println(report);
                    }
                    else if (i == 10){
                        System.out.println("VEHICLES NEEDING MAINTENANCE:\n");
                        List<Vehicle> list =  FM.getVehiclesNeedingMaintenance();
                        for (Vehicle v : list){
                            v.displayInfo();
                        }
                    }
                    //these require checking of input
                    else if (i == 1){
                        System.out.println("ADD VEHICLE\nVehicle Type:\n1. Car\n2. Truck\n3. Bus\n4. Airplane\n5. Cargoship\nEnter Vehicle Type Number: ");
                        if (input.hasNextInt()){
                            int j = input.nextInt();
                            input.nextLine();
                            if (j >= 1 && j <= 6){
                                System.out.println("Enter Vehicle ID: ");
                                String id =  input.nextLine();
                                System.out.println("Enter Vehicle Model: ");
                                String model = input.nextLine();
                                System.out.println("Enter Vehicle Max Speed: ");
                                double maxSpeed = 0;
                                if (input.hasNextDouble()){
                                    maxSpeed = input.nextDouble();
                                    input.nextLine();
                                }
                                else{
                                    System.out.println("Invalid Input!\n");
                                    input.nextLine();
                                }
                                System.out.println("Enter Vehicle Current Mileage: ");
                                double currentMileage = 0;
                                if (input.hasNextDouble()){
                                    currentMileage = input.nextDouble();
                                    input.nextLine();
                                }
                                else{
                                    System.out.println("Invalid Input!\n");
                                    input.nextLine();
                                }

                                if (id.isEmpty() || model.isEmpty() || maxSpeed <= 0 || currentMileage < 0){
                                    System.out.println("Invalid Input(s)\n");
                                }
                                else {
                                    Vehicle v = null;
                                    if (j == 1 || j == 2 || j == 3) {//land vehicles
                                        System.out.println("Enter Vehicle Fuel Level: ");
                                        double fuelLevel = 0;
                                        if (input.hasNextDouble()){
                                            fuelLevel = input.nextDouble();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }

                                        System.out.println("Enter Vehicle Number of Wheels: ");
                                        int numWheels = 0;
                                        if (input.hasNextInt()){
                                            numWheels = input.nextInt();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }
                                        if (j == 1) {
                                            System.out.println("Enter Vehicle Passenger Capacity: ");
                                            int passengerCapacity = 0;
                                            if (input.hasNextInt()){
                                                passengerCapacity = input.nextInt();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                            System.out.println("Enter Vehicle Current Passengers: ");
                                            int currentPassengers = 0;
                                            if (input.hasNextInt()){
                                                currentPassengers = input.nextInt();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                            if (fuelLevel < 0 || currentPassengers < 0 || numWheels < 4 || passengerCapacity <= 0) {
                                                System.out.println("Invalid Input(s): 1 or more given inputs were null!!\n");
                                            } else {
                                                v = new Car(id, model, maxSpeed, currentMileage, numWheels, fuelLevel, passengerCapacity, currentPassengers);
                                            }
                                        } else if (j == 2) {
                                            System.out.println("Enter Vehicle Cargo Capacity: ");
                                            double cargoCapacity = 0;
                                            if (input.hasNextDouble()){
                                                cargoCapacity = input.nextDouble();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                            System.out.println("Enter Vehicle Current Cargo: ");
                                            double currentCargo = 0;
                                            if (input.hasNextDouble()){
                                                currentCargo = input.nextDouble();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                            if (fuelLevel < 0 || currentCargo < 0 || numWheels < 4 || cargoCapacity <= 0) {
                                                System.out.println("Invalid Input(s): 1 or more given inputs were null!!\n");
                                            } else {
                                                v = new Truck(id, model, maxSpeed, currentMileage, numWheels, fuelLevel, cargoCapacity, currentCargo);
                                            }
                                        } else {
                                            System.out.println("Enter Vehicle Passenger Capacity: ");
                                            int passengerCapacity = 0;
                                            if (input.hasNextInt()){
                                                passengerCapacity = input.nextInt();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                            System.out.println("Enter Vehicle Current Passengers: ");
                                            int currentPassengers = 0;
                                            if (input.hasNextInt()){
                                                currentPassengers = input.nextInt();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                            System.out.println("Enter Vehicle Cargo Capacity: ");
                                            double cargoCapacity = 0;
                                            if (input.hasNextDouble()){
                                                cargoCapacity = input.nextDouble();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                            System.out.println("Enter Vehicle Current Cargo: ");
                                            double currentCargo = 0;
                                            if (input.hasNextDouble()){
                                                currentCargo = input.nextDouble();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                            if (fuelLevel < 0 || currentPassengers < 0 || numWheels < 4 || passengerCapacity <= 0 || currentCargo < 0 || cargoCapacity <= 0) {
                                                System.out.println("Invalid Input(s): 1 or more given inputs were null!!\n");
                                            } else {
                                                v = new Bus(id, model, maxSpeed, currentMileage, numWheels, fuelLevel, cargoCapacity, currentCargo, passengerCapacity, currentPassengers);
                                            }
                                        }

                                    } else if (j == 4) {
                                        System.out.println("Enter Vehicle Fuel Level: ");
                                        double fuelLevel = 0;
                                        if (input.hasNextDouble()){
                                            fuelLevel = input.nextDouble();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }

                                        System.out.println("Enter Vehicle Max Altitude: ");
                                        double maxAltitude = 0;
                                        if (input.hasNextDouble()){
                                            maxAltitude = input.nextDouble();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }
                                        System.out.println("Enter Vehicle Passenger Capacity: ");
                                        int passengerCapacity = 0;
                                        if (input.hasNextInt()){
                                            passengerCapacity = input.nextInt();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }
                                        System.out.println("Enter Vehicle Current Passengers: ");
                                        int currentPassengers = 0;
                                        if (input.hasNextInt()){
                                            currentPassengers = input.nextInt();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }
                                        System.out.println("Enter Vehicle Cargo Capacity: ");
                                        double cargoCapacity = 0;
                                        if (input.hasNextDouble()){
                                            cargoCapacity = input.nextDouble();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }
                                        System.out.println("Enter Vehicle Current Cargo: ");
                                        double currentCargo = 0;
                                        if (input.hasNextDouble()){
                                            currentCargo = input.nextDouble();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }
                                        if (fuelLevel < 0 || currentPassengers < 0 || maxAltitude <= 0 || passengerCapacity <= 0 || currentCargo < 0 || cargoCapacity <= 0) {
                                            System.out.println("Invalid Input(s): 1 or more given inputs were null!!\n");
                                        } else {
                                            v = new Airplane(id, model, maxSpeed, currentMileage, maxAltitude, fuelLevel, cargoCapacity, currentCargo, passengerCapacity, currentPassengers);
                                        }
                                    } else {
                                        System.out.println("Enter If Vehicle Has Sail (Y/N): ");
                                        boolean hasSail;
                                        String answer = input.nextLine();
                                        if (answer.equalsIgnoreCase("Y")) {
                                            hasSail = true;
                                        } else if (answer.equalsIgnoreCase("N")) {
                                            hasSail = false;
                                        } else {
                                            System.out.println("Invalid Input\n");
                                            continue;
                                        }
                                        double fuelLevel = 0;
                                        if (!hasSail) {
                                            System.out.println("Enter Vehicle Fuel Level: ");
                                            if (input.hasNextDouble()){
                                                fuelLevel = input.nextDouble();
                                                input.nextLine();
                                            }
                                            else{
                                                System.out.println("Invalid Input!\n");
                                                input.nextLine();
                                            }
                                        }

                                        System.out.println("Enter Vehicle Cargo Capacity: ");
                                        double cargoCapacity = 0;
                                        if (input.hasNextDouble()){
                                            cargoCapacity = input.nextDouble();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }
                                        System.out.println("Enter Vehicle Current Cargo: ");
                                        double currentCargo = 0;
                                        if (input.hasNextDouble()){
                                            currentCargo = input.nextDouble();
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Invalid Input!\n");
                                            input.nextLine();
                                        }
                                        if (currentCargo < 0 || cargoCapacity <= 0 || (!hasSail && fuelLevel < 0)) {
                                            System.out.println("Invalid Input(s): 1 or more given inputs were null!!\n");
                                        } else {
                                            v = new CargoShip(id, model, maxSpeed, currentMileage, hasSail, fuelLevel, cargoCapacity, currentCargo);
                                        }

                                    }

                                    if (v != null) {
                                        try {
                                            FM.addVehicle(v);
                                            System.out.println("Vehicle added successfully!\n");
                                        } catch (Exception e) {
                                            System.out.println("Vehicle could not be added!\nError:" + e + "\n");
                                        }
                                    }
                                }
                                    

                            }
                            else{
                                System.out.println("Invalid Input\n");
                            }

                        }
                        else{
                            System.out.println("Invalid Input.\n");
                        }
                    }
                    else if (i == 2){
                        System.out.println("REMOVING VEHICLE\nEnter Vehicle ID: ");
                        if (input.hasNextLine()){
                            String id = input.nextLine();
                            try {
                                FM.removeVehicle(id);
                                System.out.println("Removed Vehicle ID: " + id);
                            }
                            catch (Exception e){
                                System.out.println("Could not remove vehicle!\nError:"+e+"\n");
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                        }
                    }

                    else if (i == 3){
                        System.out.println("START JOURNEY\nEnter Distance: ");
                        if (input.hasNextDouble()){
                            double x = input.nextDouble();
                            input.nextLine();
                            try {
                                FM.startAllJourneys(x);
                            }
                            catch (Exception e){
                                System.out.println("Could not move all vehicles by distance %d!\nError:"+e+"\n");
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                            input.nextLine();
                        }

                    }
                    else if (i == 4){
                        System.out.println("REFUELING ALL\nEnter Refuel Amount: ");
                        if (input.hasNextDouble()){
                            double amount = input.nextDouble();
                            input.nextLine();
                            try {
                                FM.refuelAll(amount);
                            }
                            catch (Exception e){
                                System.out.println("Could not refuel all!\nError:"+e+"\n");
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                            input.nextLine();
                        }

                    }
                    else if (i == 7){
                        System.out.println("SAVE FLEET\nEnter Filename To Save At: ");
                        if (input.hasNextLine()){
                            String filename = input.nextLine();
                            filename = filename.trim();
                            try {
                                FM.saveToFile(filename);
                            }
                            catch (Exception e){
                                System.out.println("Could not save to file!\nError:"+e+"\n");
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                        }
                    }
                    else if (i == 8){
                        System.out.println("LOAD FLEET\nEnter Filename To Load From: ");
                        if (input.hasNextLine()){
                            String filename = input.nextLine();
                            filename = filename.trim();
                            try {
                                FM.loadFromFile(filename);
                            }
                            catch (Exception e){
                                System.out.println("Could not load from file!\nError:"+e+"\n");
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                        }
                    }
                    else if (i == 9){
                        System.out.println("SEARCH BY TYPE:\nVehicle Type:\n1. Car\n2. Truck\n3. Bus\n4. Airplane\n5. Cargoship\nEnter Vehicle Type Number: ");
                        if (input.hasNextInt()){
                            int j =  input.nextInt();
                            input.nextLine();
                            List<Vehicle> list;
                            if (j == 1){
                                list = FM.searchByType(Car.class);
                            }
                            else if (j == 2){
                                list =  FM.searchByType(Truck.class);
                            }
                            else if (j == 3){
                                list = FM.searchByType(Bus.class);
                            }
                            else if (j == 4){
                                list = FM.searchByType(Airplane.class);
                            }
                            else if (j == 5){
                                list = FM.searchByType(CargoShip.class);
                            }
                            else{
                                System.out.println("Invalid Input.\n");
                                continue;
                            }
                            System.out.println("Vehicles of required class:\n");
                            for (Vehicle v : list) {
                                v.displayInfo();
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                            input.nextLine();
                        }
                    }
                }
                else{
                    System.out.println("Invalid Input Choice.\n");
                }
            }
            else{
                System.out.println("Invalid Input. Please Enter A Choice Number.\n");
                input.nextLine();
            }

        }
    }
}