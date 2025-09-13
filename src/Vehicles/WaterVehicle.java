package Vehicles;
import Exceptions.*;
import Interfaces.*;

public abstract class WaterVehicle extends Vehicle {
    private boolean hasSail;

    //constructor
    public WaterVehicle(String id, String model, double maxSpeed, double currentMileage, boolean hasSail) {
        super(id, model, maxSpeed, currentMileage);
        this.hasSail=hasSail;
    }

    public abstract String toCSV();

    @Override
    public double estimateJourneyTime(double distance){
        return 1.15*(distance/super.getMaxSpeed());
    }

    public boolean hasSail(){
        return hasSail;
    }
}
