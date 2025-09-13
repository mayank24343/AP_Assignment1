package FleetManagerMain;

import Vehicles.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static FleetManager FM = new FleetManager();

    public static void main(String[] args) {
        Vehicle x = new Car("C102","Hyundai",40,500,4,50,4,0);
        System.out.println(x.toString());
        System.out.println(x.toCSV());
        //FM.loadFromFile("abc.csv");
        CLI();

    }

    public static void CLI(){
        String menu = "MENU\n1. Add Vehicle\n2. Remove Vehicle\n3. Start Journey\n4. Refuel All\n5. Perform Maintenance\n6. Generate Report\n7. Save Fleet\n8. Load Fleet\n9. Search by Type\n10. List Vehicles Needing Maintenance\n11.Exit\nPlease Enter Your Choice Number: ";
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println(menu);
            if (input.hasNextInt()){
                int i = input.nextInt();
                if (i >= 1 && i<= 11){
                    if (i == 11){
                        System.out.println("Program Exited.");
                        break;
                    }
                    else if (i == 1){
                        System.out.println("ADD VEHICLE\nVehicles.Vehicle Type:\n1. Car\n2. Truck\n3. Bus\n4. Airplane\n5. Cargoship\nEnter Vehicles.Vehicle Type Number: ");
                        if (input.hasNextInt()){
                            int j = input.nextInt();
                            if (j >= 1 && j <= 6){
                                input.nextLine();
                                System.out.println("Enter Vehicle ID: ");
                                String id =  input.nextLine();
                                System.out.println("Enter Vehicle Model: ");
                                String model = input.nextLine();
                                System.out.println("Enter Vehicle Max Speed: ");
                                double maxSpeed =  input.nextDouble();
                                System.out.println("Enter Vehicle Current Mileage: ");
                                double currentMileage = input.nextDouble();
                                if (id.isEmpty() || model.isEmpty() || maxSpeed <= 0 || currentMileage < 0){
                                    System.out.println("Invalid Input(s)\n");
                                }
                                else{
                                    Vehicle v = null;
                                    if (j == 1 || j == 2 || j == 3){
                                        System.out.println("Enter Vehicle Fuel Level: ");
                                        double fuelLevel =  input.nextDouble();
                                        System.out.println("Enter Vehicle Number of Wheels: ");
                                        int numWheels = input.nextInt();
                                        if (j == 1){
                                            System.out.println("Enter Vehicle Passenger Capacity: ");
                                            int passengerCapacity = input.nextInt();
                                            System.out.println("Enter Vehicle Current Passengers: ");
                                            int currentPassengers = input.nextInt();
                                            if (fuelLevel < 0 || currentPassengers < 0 || numWheels < 4 || passengerCapacity <= 0){
                                                System.out.println("Invalid Input(s)\n");
                                            }
                                            else{
                                                v = new Car(id,model,maxSpeed,currentMileage,numWheels,fuelLevel,passengerCapacity,currentPassengers);
                                            }
                                        }
                                        else if (j == 2){
                                            System.out.println("Enter Vehicle Cargo Capacity: ");
                                            double cargoCapacity = input.nextDouble();
                                            System.out.println("Enter Vehicle Current Cargo: ");
                                            double currentCargo = input.nextDouble();
                                            if (fuelLevel < 0 || currentCargo < 0 || numWheels < 4 || cargoCapacity <= 0){
                                                System.out.println("Invalid Input(s)\n");
                                            }
                                            else{
                                                v = new Truck(id,model,maxSpeed,currentMileage,numWheels,fuelLevel,cargoCapacity,currentCargo);
                                            }
                                        }
                                        else{
                                            System.out.println("Enter Vehicle Passenger Capacity: ");
                                            int passengerCapacity = input.nextInt();
                                            System.out.println("Enter Vehicle Current Passengers: ");
                                            int currentPassengers = input.nextInt();
                                            System.out.println("Enter Vehicle Cargo Capacity: ");
                                            double cargoCapacity = input.nextDouble();
                                            System.out.println("Enter Vehicle Current Cargo: ");
                                            double currentCargo = input.nextDouble();
                                            if (fuelLevel < 0 || currentPassengers < 0 || numWheels < 4 || passengerCapacity <= 0 || currentCargo < 0 || cargoCapacity <= 0){
                                                System.out.println("Invalid Input(s)\n");
                                            }
                                            else{
                                                v = new Bus(id,model,maxSpeed,currentMileage,numWheels,fuelLevel,cargoCapacity,currentCargo,passengerCapacity,currentPassengers);
                                            }
                                        }
                                        
                                    }
                                    else if (j == 4){
                                        System.out.println("Enter Vehicle Fuel Level: ");
                                        double fuelLevel =  input.nextDouble();
                                        System.out.println("Enter Vehicle Max Altitude: ");
                                        double maxAltitude =  input.nextDouble();
                                        System.out.println("Enter Vehicle Passenger Capacity: ");
                                        int passengerCapacity = input.nextInt();
                                        System.out.println("Enter Vehicle Current Passengers: ");
                                        int currentPassengers = input.nextInt();
                                        System.out.println("Enter Vehicle Cargo Capacity: ");
                                        double cargoCapacity = input.nextDouble();
                                        System.out.println("Enter Vehicle Current Cargo: ");
                                        double currentCargo = input.nextDouble();
                                        if (fuelLevel < 0 || currentPassengers < 0 || maxAltitude <= 0 || passengerCapacity <= 0 || currentCargo < 0 || cargoCapacity <= 0){
                                            System.out.println("Invalid Input(s)\n");
                                        }
                                        else{
                                            v = new Airplane(id,model,maxSpeed,currentMileage,maxAltitude,fuelLevel,cargoCapacity,currentCargo,passengerCapacity,currentPassengers);
                                        }
                                    }
                                    else{
                                        System.out.println("Enter If Vehicle Has Sail (Y/N): ");
                                        boolean hasSail;
                                        String answer = input.nextLine();
                                        if (answer.equalsIgnoreCase("Y")){
                                            hasSail = true;
                                        }
                                        else if (answer.equalsIgnoreCase("N")){
                                            hasSail = false;
                                        }
                                        else{
                                            System.out.println("Invalid Input\n");
                                            continue;
                                        }
                                        double fuelLevel = 0;
                                        if (!hasSail){
                                            System.out.println("Enter Vehicle Fuel Level: ");
                                            fuelLevel =  input.nextDouble();
                                        }
                                        System.out.println("Enter Vehicle Cargo Capacity: ");
                                        double cargoCapacity = input.nextDouble();
                                        System.out.println("Enter Vehicle Current Cargo: ");
                                        double currentCargo = input.nextDouble();
                                        if (currentCargo < 0 || cargoCapacity <= 0 || (!hasSail && fuelLevel <0)){
                                            System.out.println("Invalid Input(s)\n");
                                        }
                                        else{
                                            v = new CargoShip(id,model,maxSpeed,currentMileage,hasSail,fuelLevel,cargoCapacity,currentCargo);
                                        }

                                    }
                                    
                                    if (v != null){
                                        FM.addVehicle(v);
                                        System.out.println("Vehicle added successfully.\n");
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
                        System.out.println("REMOVING VEHICLE\nEnter Vehicles.Vehicle ID: ");
                        input.nextLine();
                        if (input.hasNextLine()){
                            String id = input.nextLine();
                            try {
                                FM.removeVehicle(id);
                                System.out.println("Removed Vehicle ID: " + id);
                            }
                            catch (Exception e){
                                System.out.println("Invalid Vehicle ID.\n");
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                        }
                    }
                    else if (i == 3){
                        System.out.println("START JOURNEY\nEnter Distance: ");
                        input.nextLine();
                        if (input.hasNextDouble()){
                            double x = input.nextDouble();
                            try {
                                FM.startAllJourneys(x);
                            }
                            catch (Exception e){
                                System.out.println("Invalid Distance.\n");
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                        }

                    }
                    else if (i == 4){
                        System.out.println("REFUELING ALL\nEnter Refuel Amount: ");
                        input.nextLine();
                        if (input.hasNextDouble()){
                            double amount = input.nextDouble();
                            try {
                                FM.refuelAll(amount);
                            }
                            catch (Exception e){
                                System.out.println("Invalid Refuel Amount.\n");
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                        }

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
                    else if (i == 7){
                        System.out.println("SAVE FLEET\nEnter Filename To Save At: ");
                        input.nextLine();
                        if (input.hasNextLine()){
                            String filename = input.nextLine();
                            filename = filename.trim();
                            FM.saveToFile(filename);
                        }
                        else{
                            System.out.println("Invalid Input.");
                        }
                    }
                    else if (i == 8){
                        System.out.println("LOAD FLEET\nEnter Filename To Load From: ");
                        input.nextLine();
                        if (input.hasNextLine()){
                            String filename = input.nextLine();
                            filename = filename.trim();
                            FM.loadFromFile(filename);
                        }
                        else{
                            System.out.println("Invalid Input.");
                        }
                    }
                    else if (i == 9){
                        System.out.println("SEARCH BY TYPE:\nVehicle Type:\n1. Car\n2. Truck\n3. Bus\n4. Airplane\n5. Cargoship\nEnter Vehicle Type Number: ");
                        if (input.hasNextInt()){
                            int j =  input.nextInt();
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
                                System.out.println(v.toCSV());
                            }
                        }
                        else{
                            System.out.println("Invalid Input.\n");
                        }
                    }
                    else {
                        System.out.println("VEHICLES NEEDING MAINTENANCE:\n");
                        List<Vehicle> list =  FM.getVehiclesNeedingMaintenance();
                        for (Vehicle v : list){
                            System.out.println(v.toString());
                        }
                    }
                }
                else{
                    System.out.println("Invalid Input Choice");
                }
            }
            else{
                System.out.println("Invalid Input. Please Enter A Choice Number.");
            }

        }
    }
}