abstract public class AirVehicle extends Vehicle {
    private double maxAltitude;

    //constructor
    AirVehicle(String id, String model, double maxSpeed, double currentMileage, int maxAltitude) {
        super(id,model,maxSpeed,currentMileage);
        this.maxAltitude = maxAltitude;
    }

    @Override
    public double estimateJourneyTime(double distance){
        return 0.95*(distance/super.getMaxSpeed());
    }
}
