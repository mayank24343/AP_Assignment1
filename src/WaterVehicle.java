public abstract class WaterVehicle extends Vehicle {
    private boolean hasSail;

    //constructor
    WaterVehicle(String id, String model, double maxSpeed, double currentMileage, boolean hasSail) {
        super(id, model, maxSpeed, currentMileage);
        this.hasSail=hasSail;
    }

    @Override
    public double estimateJourneyTime(double distance){
        return 1.15*(distance/super.getMaxSpeed());
    }

}
