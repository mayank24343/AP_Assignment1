package Vehicles;
import Exceptions.*;
import Interfaces.*;
abstract public class LandVehicle extends Vehicle {
    private int numWheels;

    //constructor
    public LandVehicle(String id, String model, double maxSpeed, double currentMileage,int numWheels) {
        super(id, model, maxSpeed, currentMileage);
        this.numWheels = numWheels;
    }

    //abstract methods
    public abstract void move(double distance);
    public abstract double calculateFuelEfficiency();
    public abstract String toCSV();

    public int getNumWheels() {
        return numWheels;
    }

    @Override
    public double estimateJourneyTime(double distance){
        return 1.1*(distance/super.getMaxSpeed());
    }

}
