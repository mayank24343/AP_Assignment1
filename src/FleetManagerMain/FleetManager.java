package FleetManagerMain;

import Exceptions.*;
import Interfaces.*;
import Vehicles.*;

import java.io.*;
import java.util.*;

public class FleetManager {
    private ArrayList<Vehicle> fleet = new ArrayList<>();

    //constructor
    public FleetManager() {}

    public void addVehicle(Vehicle v) throws InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(v.getId()) == 0){
                throw new InvalidOperationException("Vehicle with this ID already exists.");
            }
        }
        fleet.add(v);
    }

    public void removeVehicle(String id) throws InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                fleet.remove(vehicle);
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public void maintainAll(){
        for (Vehicle v : fleet) {
            if (((Maintainable) v).needsMaintenance()){
                ((Maintainable) v).performMaintenance();
            }
        }
    }

    public void startAllJourneys(double distance){
        for (Vehicle v : fleet) {
            v.move(distance);
        }
    }

    public double getTotalFuelConsumption(double distance){
        double totalFuelConsumption = 0;
        for (Vehicle v : fleet) {
            if ((v instanceof CargoShip) && ((CargoShip) v).getHasSail()) {
                continue;
            }
            totalFuelConsumption += ((FuelConsumable) v).consumeFuel(distance);
        }

        return totalFuelConsumption;
    }

    public List<Vehicle> searchByType( Class<?> type){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (type.isInstance(v)){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public void sortFleetByEfficiency(){
        Collections.sort(fleet);
        System.out.print("Fleet Sorted By Efficiency!");
    }

    public String generateReport(){
        String report = "";
        int totalvehicles = fleet.size();
        int totalCars=0, totalTrucks=0, totalBusses=0, totalAirplanes=0, totalCargoships=0;
        double totalMileage=0, efficiencySum=0;
        int needMaintenance=0;
        for (Vehicle v : fleet) {
            if (v instanceof CargoShip){
                totalCargoships++;
            }
            else if  (v instanceof Airplane){
                totalAirplanes++;
            }
            else if (v instanceof Bus){
                totalBusses++;
            }
            else if (v instanceof Truck){
                totalTrucks++;
            }
            else if (v instanceof Car){
                totalCars++;
            }

            totalMileage+= v.getCurrentMileage();
            efficiencySum+= v.calculateFuelEfficiency();
            if (((Maintainable) v).needsMaintenance()){
                needMaintenance++;
            }
        }

        report = String.format("Total Vehicles: %d\nTotal Cars: %d\nTotal Trucks: %d\nTotal Busses: %d\nTotal Airplanes: %d\nTotal Cargo Ships: %d\nAverage Fuel Efficiency: %f\nTotal Mileage: %f\nTotal Vehicles Needing Maintenance: %d", totalvehicles, totalCars, totalTrucks, totalBusses, totalAirplanes, totalCargoships, efficiencySum/totalvehicles, totalMileage,  needMaintenance);

        return report;
    }

    public List<Vehicle> getVehiclesNeedingMaintenance(){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (((Maintainable) v).needsMaintenance()){
                vehicles.add(v);
            }
        }

        return vehicles;
    }

    public void saveToFile(String filename){
        try (FileWriter fw = new FileWriter(filename)){
            for (Vehicle v : fleet) {
                fw.write(v.toCSV());
            }
            System.out.printf("Saved Fleet Information to File %s%n",filename);
        }
        catch (IOException e){
            System.out.println("Error writing to file");
        }

    }

    public void loadFromFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String l = br.readLine();
            while (l != null){
                System.out.println(l);
                //create vehicle using factory method
                try {
                    Vehicle v = VehicleFactory.createFromCSV(l);
                    addVehicle(v);
                    l = br.readLine();
                }
                catch (Exception e){
                    l = br.readLine();
                    System.out.println("Error reading from file-Data incorrect/not arranged as expected.\nError: "+e+"\n");
                }
            }
        }
        catch (IOException e){
            System.out.println("Error in loading file");
        }
    }

    public void refuelAll(double amount){
        for (Vehicle v : fleet) {
            if (v instanceof FuelConsumable){
                ((FuelConsumable) v).refuel(amount);
            }
        }
    }

    public void boardPassengers(String id, int passengers) throws InvalidOperationException, OverloadException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                if (vehicle instanceof PassengerCarrier){
                    if (passengers >= 0) {
                        ((PassengerCarrier) vehicle).boardPassengers(passengers);
                    }
                    else{
                        throw new InvalidOperationException("Cannot have negative passengers.");
                    }
                }
                else{
                    throw new  InvalidOperationException("Vehicle does not support passengers.");
                };
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public void disembarkPassengers(String id, int passengers) throws InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                if (vehicle instanceof PassengerCarrier){
                    if (passengers >= 0) {
                        ((PassengerCarrier) vehicle).disembarkPassengers(passengers);
                    }
                    else{
                        throw new InvalidOperationException("Cannot have negative passengers.");
                    }
                }
                else{
                    throw new  InvalidOperationException("Vehicle does not support passengers.");
                };
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public void loadCargo(String id, double cargo) throws  InvalidOperationException, OverloadException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                if (vehicle instanceof CargoCarrier){
                    if (cargo >= 0) {
                        ((CargoCarrier) vehicle).loadCargo(cargo);
                    }
                    else{
                        throw new InvalidOperationException("Cannot have negative cargo.");
                    }
                }
                else{
                    throw new  InvalidOperationException("Vehicle does not support cargo.");
                };
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public void unloadCargo(String id, double cargo) throws  InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                if (vehicle instanceof CargoCarrier){
                    if (cargo >= 0) {
                        ((CargoCarrier) vehicle).unloadCargo(cargo);
                    }
                    else{
                        throw new InvalidOperationException("Cannot have negative cargo.");
                    }
                }
                else{
                    throw new  InvalidOperationException("Vehicle does not support cargo.");
                };
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public double estimateJourneyTime(String id, double distance) throws InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                return vehicle.estimateJourneyTime(distance);
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");


    }

}
