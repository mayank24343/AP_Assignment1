public abstract class Vehicle {
    private String id;
    private String model;
    private double maxSpeed;
    private double currentMileage;

    //constructor
    Vehicle(String id, String model, double maxSpeed, double currentMileage) {
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

    //abstract methods
    /*
    abstract void move(double distance) throws InvalidOperationException{
        if (distance < 0){
            throw new InvalidOperationException;
        }
    };
     */

    abstract double calculateFuelEfficiency();
    abstract double estimateJourneyTime(double distance);

    //concrete methods
    void displayInfo(){
        System.out.println();
    }

    double getCurrentMileage() {
        return currentMileage;
    }

    void setCurrentMileage(double currentMileage) {
        if (currentMileage < 0){
            throw new IllegalArgumentException("currentMileage is negative");
        }
        this.currentMileage = currentMileage;
    }

    String getId() {
        return id;
    }

    double getMaxSpeed() {
        return maxSpeed;
    }
}
