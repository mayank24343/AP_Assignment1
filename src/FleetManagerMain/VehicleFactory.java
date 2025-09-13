package FleetManagerMain;

import Exceptions.InvalidOperationException;
import Vehicles.*;

import java.security.InvalidParameterException;

public class VehicleFactory {
    VehicleFactory(){}

     public static Vehicle create(String info){
        String[] attributes = info.split(",");
        if (attributes.length == 10 || attributes.length == 12){
          if (attributes[0].trim().equals("Car")) {
               for (int i = 1; i < 10; i++){
                   if (attributes[i].trim().isEmpty()){
                       throw new InvalidOperationException("Empty Attributes.");
                   }
               }
               Vehicle v = new Car(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Integer.parseInt(attributes[7]), Integer.parseInt(attributes[8]));
               return v;
          }
          else if (attributes[0].trim().equals("Bus")) {
              for (int i = 1; i < 12; i++){
                  if (attributes[i].trim().isEmpty()){
                      throw new InvalidOperationException("Empty Attributes.");
                  }
              }
              Vehicle v = new Bus(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]), Integer.parseInt(attributes[9]), Integer.parseInt(attributes[10]));
              return v;

          }
          else if (attributes[0].trim().equals("Truck")) {
              for (int i = 1; i < 10; i++){
                  if (attributes[i].trim().isEmpty()){
                      throw new InvalidOperationException("Empty Attributes.");
                  }
              }
              Vehicle v = new Truck(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]));
              return v;
          }
          else if  (attributes[0].trim().equals("Cargoship")) {
              for (int i = 1; i < 10; i++){
                  if (attributes[i].trim().isEmpty()){
                      throw new InvalidOperationException("Empty Attributes.");
                  }
              }
              Vehicle v = new CargoShip(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Boolean.parseBoolean(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]));
              return v;
          }
          else if (attributes[0].trim().equals("Airplane")) {
              for (int i = 1; i < 12; i++){
                  if (attributes[i].trim().isEmpty()){
                      throw new InvalidOperationException("Empty Attributes.");
                  }
              }
              Vehicle v = new Airplane(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Double.parseDouble(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]), Integer.parseInt(attributes[9]), Integer.parseInt(attributes[10]));
              return v;
          }
          else{
              throw new InvalidOperationException("Unknown Vehicle Type");
          }

        }
        else{
            throw new InvalidParameterException("Invalid Vehicle Information");
        }

    }
}
