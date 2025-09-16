package Interfaces;

import Exceptions.*;

public interface FuelConsumable {
    void refuel(double amount) throws InsufficientFuelException;
    double getFuelLevel();
    double consumeFuel(double distance) throws InsufficientFuelException;

}
