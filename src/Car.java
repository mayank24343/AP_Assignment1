public class Car extends LandVehicle implements FuelConsumable, PassengerCarrier, Maintainable{
    //properties
    private double fuelLevel;
    private int passengerCapacity;
    private int currentPassengers;
    private boolean maintenanceNeeded = false;

    //constructor
    Car(String id, String model, double maxSpeed, double currentMileage, int numWheels, double fuelLevel, int passengerCapacity, int currentPassengers) {
        super(id,model,maxSpeed,currentMileage,numWheels);
        this.fuelLevel = fuelLevel;
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = currentPassengers;
        if (currentMileage > 10000){
            this.maintenanceNeeded = true;
        }
    }

    @Override
    public void move(double distance) throws InvalidOperationException{
        if (distance < 0) {
            throw new InvalidOperationException("Cannot move negative distance.");
        }
        consumeFuel(distance);

        setCurrentMileage(getCurrentMileage()+distance);
        System.out.println("Driving on road ...");

    }

    @Override
    double calculateFuelEfficiency() {
        return 15.0;
    }

    //FuelConsumable Interface
    @Override
    public void refuel(double amount) throws InvalidOperationException{
        if (amount <= 0){
            throw new InvalidOperationException("Amount must be greater than 0.");
        }
        fuelLevel += amount;
    }

    @Override
    public double getFuelLevel(){
        return fuelLevel;
    }

    @Override
    public double consumeFuel(double distance) throws InsufficientFuelException {
        double amountConsumed = distance/calculateFuelEfficiency();
        if (fuelLevel < amountConsumed){
            throw new InsufficientFuelException("Insufficient fuel to move distance.");
        }
        fuelLevel -= amountConsumed;
        return amountConsumed;
    }

    //Maintenance Interface
    @Override
    public void scheduleMaintenance() {
        maintenanceNeeded = true;
        System.out.println("Maintenance is scheduled.");
    }

    @Override
    public boolean needsMaintenance() {
        if (getCurrentMileage() > 10000){
            maintenanceNeeded = true;
        };
        return maintenanceNeeded;
    }

    @Override
    public void performMaintenance() {
        maintenanceNeeded = false;
        setCurrentMileage(0);
        System.out.println("Maintenance is performed.");
    }

    //PassengerCarrier Interface
    @Override
    public void boardPassengers(int count) throws OverloadException{
        if (count + currentPassengers > passengerCapacity){
            throw new OverloadException("Cannot board more than max capacity.");
        }
        currentPassengers += count;
    }

    @Override
    public void disembarkPassengers(int count) throws InvalidOperationException {
        if (count > currentPassengers) {
            throw new InvalidOperationException("Cannot disembark more passengers than in the vehicle.");
        }
        currentPassengers-=count;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public int getCurrentPassengers() {
        return currentPassengers;
    }
}
