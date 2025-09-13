package Vehicles;
import Exceptions.*;
import Interfaces.*;

public abstract class Vehicle implements Comparable<Vehicle>{
    private String id;
    private String model;
    private double maxSpeed;
    private double currentMileage;

    //constructor
    public Vehicle(String id, String model, double maxSpeed, double currentMileage) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
            this.model = model;
            this.maxSpeed = maxSpeed;
            this.currentMileage = currentMileage;
        }
        else {
            throw new IllegalArgumentException("id is null or empty");
        }


    }

    @Override
    public int compareTo(Vehicle v) {
        if (this.calculateFuelEfficiency() > v.calculateFuelEfficiency()) {
            return 1;
        }
        else if (this.calculateFuelEfficiency() < v.calculateFuelEfficiency()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public abstract void move(double distance) throws InvalidOperationException;
    public abstract double calculateFuelEfficiency();
    public abstract double estimateJourneyTime(double distance);
    public abstract String toCSV();

    //concrete methods
    public void displayInfo(){
        System.out.println();
    }

    public double getCurrentMileage() {
        return currentMileage;
    }

    void setCurrentMileage(double currentMileage) {
        if (currentMileage < 0){
            throw new IllegalArgumentException("currentMileage is negative");
        }
        this.currentMileage = currentMileage;
    }

    public String getId() {
        return id;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }
}
