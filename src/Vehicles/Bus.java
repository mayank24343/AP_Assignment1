package Vehicles;
import Exceptions.*;
import Interfaces.*;

public class Bus extends LandVehicle implements FuelConsumable, PassengerCarrier, CargoCarrier, Maintainable {
    //properties
    private double fuelLevel;
    private int passengerCapacity = 50;
    private int currentPassengers;
    private double cargoCapacity = 500;
    private double currentCargo;
    private boolean maintenanceNeeded = false;

    //constructor
    public Bus(String id, String model, double maxSpeed, double currentMileage, int numWheels, double fuelLevel, double cargoCapacity, double currentCargo, int passengerCapacity, int currentPassengers) {
        super(id, model, maxSpeed, currentMileage, numWheels);
        this.fuelLevel = fuelLevel;
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = currentPassengers;
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = currentCargo;
        if (currentMileage > 10000) {
            this.maintenanceNeeded = true;
        }
    }
    @Override
    public void move(double distance) throws InvalidOperationException {
        if (distance < 0) {
            throw new InvalidOperationException("Negative distance.");
        }

        consumeFuel(distance);
        setCurrentMileage(getCurrentMileage()+distance);
        System.out.println("Transporting passengers and cargo ...");
    }

    @Override
    public double calculateFuelEfficiency() {
        return 10.0;
    }

    @Override
    public void loadCargo(double weight) throws OverloadException {
        if (weight > cargoCapacity-currentCargo) {
            throw new OverloadException("Cargo Limit Exceeded.");
        }
        currentCargo += weight;
    }

    @Override
    public void unloadCargo(double weight) throws InvalidOperationException {
        if (weight > currentCargo) {
            throw new InvalidOperationException("Unloading Cargo Limit Exceeded.");
        }

        currentCargo -= weight;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public double getCurrentCargo() {
        return currentCargo;
    }

    @Override
    public void refuel(double amount) throws InsufficientFuelException {
        if (amount <= 0){
            throw new InsufficientFuelException("Amount must be greater than 0.");
        }

        fuelLevel += amount;
    }

    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public double consumeFuel(double distance) throws InsufficientFuelException {
        double amount = distance/calculateFuelEfficiency();
        if (fuelLevel < amount) {
            throw new InsufficientFuelException("Fuel Limit Exceeded.");
        }

        fuelLevel -= amount;
        return amount;
    }

    @Override
    public void scheduleMaintenance() {
        maintenanceNeeded = true;
        System.out.println("Maintenance scheduled.");
    }

    @Override
    public boolean needsMaintenance() {
        return (getCurrentMileage() > 10000);
    }

    @Override
    public void performMaintenance() {
        maintenanceNeeded = false;
        setCurrentMileage(0);
        System.out.println("Maintenance performed.");
    }

    @Override
    public void boardPassengers(int count) throws OverloadException {
        if (count > passengerCapacity-currentPassengers) {
            throw new OverloadException("Passenger Limit Exceeded.");
        }
        currentPassengers += count;
    }

    @Override
    public void disembarkPassengers(int count) throws InvalidOperationException {
        if (count > currentPassengers) {
            throw new InvalidOperationException("Not enough passengers.");
        }

        currentPassengers -= count;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public int getCurrentPassengers() {
        return currentPassengers;
    }

    @Override
    public String toCSV(){
        return String.format("Bus,%s,%s,%f,%f,%d,%f,%d,%d,%f,%f,%b",super.getId(),super.getModel(),super.getMaxSpeed(),super.getCurrentMileage(),super.getNumWheels(),fuelLevel,passengerCapacity,currentPassengers,cargoCapacity,currentCargo,maintenanceNeeded);//id,model,maxspeed,mileage,numwheels,fuellevel,passnegercapacity,currentpassengers,cargocapacity,currentcargo,maintenanceneeded
    }
}
