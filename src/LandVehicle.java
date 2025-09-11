abstract public class LandVehicle extends Vehicle {
    private int numWheels;

    //constructor
    LandVehicle(String id, String model, double maxSpeed, double currentMileage,int numWheels) {
        super(id, model, maxSpeed, currentMileage);
        this.numWheels = numWheels;
    }

    //abstract methods
    abstract void move(double distance);
    abstract double calculateFuelEfficiency();

    @Override
    double estimateJourneyTime(double distance){
        return 1.1*(distance/super.getMaxSpeed());
    }

}
