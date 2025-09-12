import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FleetManager {
    private ArrayList<Vehicle> fleet;
    FleetManager() {}

    void addVehicle(Vehicle v) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(v.getId()) == 0){
                throw new InvalidOperationException("Vehicle with this ID already exists.");
            }
        }
        fleet.add(v);
    }

    void removeVehicle(String id) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                fleet.remove(vehicle);
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    void maintainAll(){
        for (Vehicle v : fleet) {
            if (((Maintainable) v).needsMaintenance()){
                ((Maintainable) v).performMaintenance();
            }
        }
    }

    void startAllJourneys(double distance){
        for (Vehicle v : fleet) {
            v.move(distance);
        }
    }

    double getTotalFuelConsumption(double distance){
        double totalFuelConsumption = 0;
        for (Vehicle v : fleet) {
            if ((v instanceof CargoShip) && ((CargoShip) v).hasSail()) {
                continue;
            }
            totalFuelConsumption += ((FuelConsumable) v).consumeFuel(distance);
        }

        return totalFuelConsumption;
    }

    List<Vehicle> searchByType( Class<?> type){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (type.isInstance(v)){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    void sortFleetByEfficiency(){
        Collections.sort(fleet);
    }

    String generateReport(){
        String report = "";
        int totalvehicles = fleet.size();
        int totalCars=0, totalTrucks=0, totalBusses=0, totalAirplanes=0, totalCargoships=0;
        double totalMileage=0, efficiencySum=0;
        int needMaintenance=0;
        for (Vehicle v : fleet) {
            if (v instanceof CargoShip){
                totalCargoships++;
            }
            else if  (v instanceof Airplane){
                totalAirplanes++;
            }
            else if (v instanceof Bus){
                totalBusses++;
            }
            else if (v instanceof Truck){
                totalTrucks++;
            }
            else if (v instanceof Car){
                totalCars++;
            }

            totalMileage+= v.getCurrentMileage();
            efficiencySum+= v.calculateFuelEfficiency();
            if (((Maintainable) v).needsMaintenance()){
                needMaintenance++;
            }
        }

        report = String.format("Total Vehicles: %d\nTotal Cars: %d\nTotal Trucks: %d\nTotal Busses: %d\nTotal Airplanes: %d\nTotal Cargo Ships: %d\nAverage Fuel Efficiency: %f\nTotal Mileage: %f\nTotal Vehicles Needing Maintenance: %d", totalvehicles, totalCars, totalTrucks, totalBusses, totalAirplanes, totalCargoships, efficiencySum/totalvehicles, totalMileage,  needMaintenance);

        return report;
    }

    List<Vehicle> getVehiclesNeedingMaintenance(){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (((Maintainable) v).needsMaintenance()){
                vehicles.add(v);
            }
        }

        return vehicles;
    }
}
