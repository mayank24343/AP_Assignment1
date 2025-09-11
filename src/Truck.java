public class Truck extends LandVehicle implements FuelConsumable, CargoCarrier, Maintainable{
    //properties
    private double fuelLevel;
    private double cargoCapacity = 5000;
    private double currentCargo;
    private boolean maintenanceNeeded = false;

    //constructor
    Truck(String id, String model, double maxSpeed, double currentMileage, int numWheels, double fuelLevel, double cargoCapacity, double currentCargo, boolean maintenanceNeeded) {
        super(id, model, maxSpeed, currentMileage, numWheels);
        this.fuelLevel = fuelLevel;
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = currentCargo;
        if (getCurrentMileage() > 10000){
            this.maintenanceNeeded = true;
        }
    }

    @Override
    void move (double distance) throws InvalidOperationException {
        if (distance < 0){
            throw new InvalidOperationException("Distance cannot be negative.");
        }

    }

    @Override
    double calculateFuelEfficiency() {
        return 8.0;
    }

    @Override
    public void loadCargo(double weight) throws OverloadException{

    }

    @Override
    public void unloadCargo(double weight) {

    }

    @Override
    public double getCargoCapacity() {
        return 0;
    }

    @Override
    public double getCurrentCargo() {
        return 0;
    }

    @Override
    public void refuel(double amount) throws InsufficientFuelException {

    }

    @Override
    public double getFuelLevel() {
        return 0;
    }

    @Override
    public double consumeFuel(double distance) throws InsufficientFuelException {
        return 0;
    }

    @Override
    public void scheduleMaintenance() {

    }

    @Override
    public boolean needsMaintenance() {
        return false;
    }

    @Override
    public void performMaintenance() {

    }
}
