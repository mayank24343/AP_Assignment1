public class CargoShip extends WaterVehicle implements CargoCarrier, Maintainable, FuelConsumable{
    private double currentCargo;
    private double cargoCapacity = 50000;
    private boolean maintenanceNeeded = false;
    private double fuelLevel = 0;

    //constructor
    CargoShip(String id, String model, double maxspeed, double currentMileage, boolean hasSail, double cargoCapacity, double currentCargo, double fuelLevel) {
        super(id,model,maxspeed,currentMileage,hasSail);
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = currentCargo;
        if (currentMileage > 10000) {
            maintenanceNeeded = true;
        }
        this.fuelLevel = fuelLevel;
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
        if  (weight > currentCargo) {
            throw new InvalidOperationException("cant unload more than load.");
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
    public void refuel(double amount) throws InsufficientFuelException, InvalidOperationException {
        if (!hasSail()){
            if (amount <= 0){
                throw new InsufficientFuelException("Amount must be greater than 0.");
            }
            fuelLevel += amount;
        }
        else{
            throw new InvalidOperationException("Can't refuel ship which uses sail.");
        }
    }

    @Override
    public double getFuelLevel() throws InvalidOperationException {
        if (!hasSail()){
            throw new InvalidOperationException("Ship doesn't use fuel. Uses sail.");
        }
        return fuelLevel;
    }

    @Override
    public double consumeFuel(double distance) throws InsufficientFuelException, InvalidOperationException {
        if (!hasSail()){
            throw new InvalidOperationException("Ship doesn't use fuel. Uses sail.");
        }

        double amount = distance/calculateFuelEfficiency();
        if (amount > fuelLevel){
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
    void move(double distance) throws InvalidOperationException {
        if (distance < 0){
            throw new InvalidOperationException("Distance must be greater than 0.");
        }
        if (!hasSail()){
            consumeFuel(distance);
        }

        setCurrentMileage(getCurrentMileage() + distance);
        System.out.println("Sailing with cargo.");
    }

    @Override
    double calculateFuelEfficiency() {
        if (hasSail()){
            return 0;
        }
        return 4.0;
    }
}
