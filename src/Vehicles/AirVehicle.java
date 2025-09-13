package Vehicles;
import Exceptions.*;
import Interfaces.*;

abstract public class AirVehicle extends Vehicle {
    private double maxAltitude;

    //constructor
    public AirVehicle(String id, String model, double maxSpeed, double currentMileage, double maxAltitude) {
        super(id,model,maxSpeed,currentMileage);
        this.maxAltitude = maxAltitude;
    }

    public abstract String toCSV();
    public double getMaxAltitude() {
        return maxAltitude;
    }

    @Override
    public double estimateJourneyTime(double distance){
        return 0.95*(distance/super.getMaxSpeed());
    }
}
