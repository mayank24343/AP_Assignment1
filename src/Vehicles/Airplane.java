package Vehicles;
import Exceptions.*;
import Interfaces.*;

public class Airplane extends AirVehicle implements FuelConsumable, PassengerCarrier, CargoCarrier, Maintainable {
    private double fuelLevel;
    private int passengerCapacity = 200;
    private int currentPassengers;
    private double cargoCapacity = 10000;
    private double currentCargo;
    private boolean maintenanceNeeded = false;

    //constructor
    public Airplane(String id, String model, double maxspeed, double currentMileage, double maxAltitude, double fuelLevel, double cargoCapacity, double currentCargo, int passengerCapacity, int currentPassengers) {
        super(id,model,maxspeed,currentMileage,maxAltitude);
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
        if (distance < 0){
            throw new InvalidOperationException("Negative distance.");
        }
        consumeFuel(distance);
        setCurrentMileage(getCurrentMileage() + distance);
        System.out.println("Flying at"+12000+" ...");
    }


    @Override
    public void loadCargo(double weight) throws OverloadException {
        if (weight > cargoCapacity-currentCargo) {
            throw new OverloadException("Weight limit esceeded.");
        }
        currentCargo += weight;
    }

    @Override
    public void unloadCargo(double weight) throws InvalidOperationException {
        if (weight > currentCargo){
            throw new InvalidOperationException("Can't unload more than what was loaded.");
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
        if (amount > fuelLevel) {
            throw new InsufficientFuelException("Insufficient fuel.");
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
        if (count > passengerCapacity - currentPassengers) {
            throw new OverloadException("TOO many passengers.");
        }
        currentPassengers += count;

    }

    @Override
    public void disembarkPassengers(int count) throws InvalidOperationException {
        if (count > currentPassengers) {
            throw new InvalidOperationException("not enough passengers.");
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
    public double calculateFuelEfficiency() {
        return 5.0;
    }

    @Override
    public String toCSV(){
        return String.format("Airplane,%s,%s,%f,%f,%f,%f,%d,%d,%f,%f,%b",super.getId(),super.getModel(),super.getMaxSpeed(),super.getCurrentMileage(),super.getMaxAltitude(),fuelLevel,passengerCapacity,currentPassengers,cargoCapacity,currentCargo,maintenanceNeeded);//id,model,maxspeed,mileage,maxaltitude,fuellevel,passnegercapacity,currentpassengers,cargocapacity,currentcargo,maintenanceneeded
    }
}
