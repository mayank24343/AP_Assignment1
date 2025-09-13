package Vehicles;
import Exceptions.*;
import Interfaces.*;

public class Truck extends LandVehicle implements FuelConsumable, CargoCarrier, Maintainable {
    //properties
    private double fuelLevel;
    private double cargoCapacity = 5000;
    private double currentCargo;
    private boolean maintenanceNeeded = false;

    //constructor
    public Truck(String id, String model, double maxSpeed, double currentMileage, int numWheels, double fuelLevel, double cargoCapacity, double currentCargo) {
        super(id, model, maxSpeed, currentMileage, numWheels);
        this.fuelLevel = fuelLevel;
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = currentCargo;
        if (getCurrentMileage() > 10000){
            this.maintenanceNeeded = true;
        }
    }

    @Override
    public void move (double distance) throws InvalidOperationException {
        if (distance < 0){
            throw new InvalidOperationException("Distance cannot be negative.");
        }

        consumeFuel(distance);
        setCurrentMileage(getCurrentMileage()+distance);
        System.out.println("Hauling cargo ...");
    }

    @Override
    public double calculateFuelEfficiency() {
        if (currentCargo/cargoCapacity > 0.5){
            return 8.0 - 0.1*8.0; //reduce efficiency by 10% in case of 50%+ cargo
        }
        return 8.0;
    }

    @Override
    public void loadCargo(double weight) throws OverloadException {
        if (weight > cargoCapacity - currentCargo){
            throw new OverloadException("Capacity exceeded");
        }
        currentCargo += weight;
    }

    @Override
    public void unloadCargo(double weight) throws InvalidOperationException {
        if (weight > currentCargo){
            throw new InvalidOperationException("Cannot unload more than cargo loaded.");
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
        if (amount <= 0) {
            throw new InsufficientFuelException("Amount must be greater than zero.");
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
        if (amount > fuelLevel){
            throw new InsufficientFuelException("Fuel exceeded");
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
        System.out.println("Maintenance scheduled.");
    }

    @Override
    public String toCSV(){
        return String.format("Truck,%s,%s,%f,%f,%d,%f,%f,%f,%b",super.getId(),super.getModel(),super.getMaxSpeed(),super.getCurrentMileage(),super.getNumWheels(),fuelLevel,cargoCapacity,currentCargo,maintenanceNeeded);//id,model,maxspeed,mileage,numwheels,fuellevel,cargocapacity,currentcargo,maintenanceneeded
    }
}
