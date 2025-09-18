AP Assignment1
Mayank Yadav 2024343

1) Inheritance and Abstraction

Vehicle is the parent class.
It is an abstract class (partially defined), with some
abstract methods(move(), estimateJourneyTime() etc.), concrete methods (displayInfo() etc.) and concrete attributes(id, model, maxSpeed etc.).

It is inherited by children classes LandVehicle, WaterVehicle and AirVehicle (concrete attributes and methods are inherited).
They are also abstract as they override and implement the estimateJourneyTime() method but other abstract methods are not implemented.

LandVehicle contains,
concrete attributes (numWheels), concrete methods(estimateJourneyTime()), and abstract methods(move() etc.).

It is inherited by children classes Car, Bus and Truck (concrete attributes and methods are inherited).
These are concrete classes - all methods are concrete i.e. implemented fully.
They contain the respective concrete attributes and methods as given in the UML diagram.

Similarly,
WaterVehicle contains,
concrete attributes (hasSail), concrete methods(estimateJourneyTime()), and abstract methods(move() etc.).

It is inherited by children class Cargoship (concrete attributes and methods are inherited).
It is a concrete classes - all methods are concrete i.e. implemented fully.
It contains the respective concrete attributes and methods as given in the UML diagram.

and
AirVehicle contains,
concrete attributes (maxAltitude), concrete methods(estimateJourneyTime()), and abstract methods(move() etc.).

It is inherited by children class Airplane (concrete attributes and methods are inherited).
It is a concrete classes - all methods are concrete i.e. implemented fully.
It contains the respective concrete attributes and methods as given in the UML diagram.

2)Polymorphism

In the FleetManager class,
many methods like refuel(), move(), toCSV() etc. are called on an object of type Vehicle but at runtime, the corresponding method from the actual type of this Vehicle (Bus, Car etc.) is called.
In Vehicle class,
the compareTo() method calls calculateFuelEfficiency() on itself (type Vehicle), but the calculate fuel efficiency of the respective type is called at runtime.
So, objects of type Vehicle show behaviour (by executing methods) to their corresponding actual concrete classes.

3)Interfaces

Interfaces FuelConsumable, Maintainable, PassengerCarrier and CargoCarrier define functions that vehicles implementing these interfaces must implement.
This ensures that vehicles which implement an interface, say FuelConsumable, have the actual implementations of the functions they are expected to have.

4)Exceptions

Custom exceptions were created by extending the exception class, to better accomate the type of exceptions and errors which could arise in this program.

5)Compilation Instructions

Download the src folder.
Open the terminal in src folder, and run: "javac Main.java" (since Main imports all other classes, it compiles them all as well)
Now run: "java Main" ,to run the CLI

6)Persistence

In the CLI Menu, options for loading and saving data are available, which will prompt the user for the filename.
Loading and saving will be done in the provided filename (if no error occurs).

7)How to use the CLI

The CLI prompts the user with the menu,
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:

The user can enter numbers 1 to 18 to navigate to the respective functionality.
Each functionality now prompts the users with the required inputs (if any), and then executes.
It prints appropriate messages in case of error.
for eg:

Option 2 runs:
REMOVING VEHICLE
Enter Vehicle ID:  {input here}

If executes successfully, then:
Removed Vehicle ID: id

In case of errors, then:
Could not remove vehicle!
Error: {error message}

or

Invalid Input.

8)Demo/Test Cases

Here is a demo run of the Main method (with compile)
It demonstrates how each functionality works, along with some deliberate error creation, and load/save operations showing persistence.

PS C:\Users\Mayank\IdeaProjects\AP_Assignment1> cd src
PS C:\Users\Mayank\IdeaProjects\AP_Assignment1\src> javac Main.java
PS C:\Users\Mayank\IdeaProjects\AP_Assignment1\src> java Main
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
6
GENERATE REPORT

Report Generated:

Total Vehicles: 0
Total Cars: 0
Total Trucks: 0
Total Busses: 0
Total Airplanes: 0
Total Cargo Ships: 0
Average Fuel Efficiency: 0.000000
Total Mileage: 0.000000
Total Vehicles Needing Maintenance: 0
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
8
LOAD FLEET
Enter Filename To Load From:
test.csv
Error reading from file-Data incorrect/not arranged as expected.
Error: java.security.InvalidParameterException: Invalid Vehicle Information

{Since content of test.csv was:
Car,CAR1411,Toyota,120.000000,1210.000000,4,64.333333,5,0,false
Bus,BUS1211,Volvo,120.000000,8710.000000,8,55.611111,5,0,2000.000000,1125.000000,false
Truck,TRUCK002,Mahindra,120.000000,8710.000000,8,55.611111,2000.000000,1125.000000,false
Airplane,AIR2501,Airbus A350,1000.000000,0.000000,1200.000000,423.000000,250,120,1000.000000,540.000000,false
Cargoship,SHIP121,ship,120.000000,8710.000000,false,55.611111,2000.000000,1125.000000,false
Bike,ThrowError101,Error11, ,HELLO,
}

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
6
GENERATE REPORT

Report Generated:

Total Vehicles: 5
Total Cars: 1
Total Trucks: 1
Total Busses: 1
Total Airplanes: 1
Total Cargo Ships: 1
Average Fuel Efficiency: 8.240000
Total Mileage: 27340.000000
Total Vehicles Needing Maintenance: 0
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
1
ADD VEHICLE
Vehicle Type:
1. Car
2. Truck
3. Bus
4. Airplane
5. Cargoship
Enter Vehicle Type Number:
4
Would you like to construct:
1)Default Vehicle
2)Set Detailed Parameters like fuel level, passenger capacity, cargo capacity etc.
Enter Choice Number:
1
Enter Vehicle ID:
AIR111
Enter Vehicle Model:
AIRBUS A380
Enter Vehicle Max Speed:
1200
Enter Vehicle Current Mileage:
30000
Enter Vehicle Max Altitude:
2500
Vehicle ID:AIR111: Maintenance scheduled.
Vehicle added successfully!

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
1
ADD VEHICLE
Vehicle Type:
1. Car
2. Truck
3. Bus
4. Airplane
5. Cargoship
Enter Vehicle Type Number:
2
Would you like to construct:
1)Default Vehicle
2)Set Detailed Parameters like fuel level, passenger capacity, cargo capacity etc.
Enter Choice Number:
2
Enter Vehicle ID:
TRUCK007
Enter Vehicle Model:
TRUCK
Enter Vehicle Max Speed:
120
Enter Vehicle Current Mileage:
12000
Enter Vehicle Number of Wheels:
12
Enter Vehicle Fuel Level:
40
Enter Vehicle Cargo Capacity:
200
Enter Vehicle Current Cargo:
90
Vehicle ID:TRUCK007: Maintenance scheduled.
Vehicle added successfully!

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
6
GENERATE REPORT

Report Generated:

Total Vehicles: 7
Total Cars: 1
Total Trucks: 2
Total Busses: 1
Total Airplanes: 2
Total Cargo Ships: 1
Average Fuel Efficiency: 7.742857
Total Mileage: 69340.000000
Total Vehicles Needing Maintenance: 2
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
10
VEHICLES NEEDING MAINTENANCE:

Vehicle ID: AIR111 | Model: AIRBUS A380 | Current Mileage: 30000.00 | Maximum Speed: 1200.00
Vehicle ID: TRUCK007 | Model: TRUCK | Current Mileage: 12000.00 | Maximum Speed: 120.00
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
5
PERFORM MAINTENANCE

Vehicle ID:AIR111: Maintenance performed.
Vehicle ID:TRUCK007: Maintenance performed.
Maintenance Complete.

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
6
GENERATE REPORT

Report Generated:

Total Vehicles: 7
Total Cars: 1
Total Trucks: 2
Total Busses: 1
Total Airplanes: 2
Total Cargo Ships: 1
Average Fuel Efficiency: 7.742857
Total Mileage: 27340.000000
Total Vehicles Needing Maintenance: 0
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
3
START JOURNEY
Enter Distance:
10
Starting All Journeys:
Vehicle ID:CAR1411: Driving on road ...
Vehicle ID:BUS1211: Transporting passengers and cargo ...
Vehicle ID:TRUCK002: Hauling cargo ...
Vehicle ID:AIR2501: Flying at 1200.0 ...
Vehicle ID:SHIP121: Sailing with cargo.
Could not move all vehicles by distance!
Error:Exceptions.InsufficientFuelException: Insufficient fuel.

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
4
REFUELING ALL
Enter Refuel Amount:
500
Refueled all vehicles!

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
3
START JOURNEY
Enter Distance:
10
Starting All Journeys:
Vehicle ID:CAR1411: Driving on road ...
Vehicle ID:BUS1211: Transporting passengers and cargo ...
Vehicle ID:TRUCK002: Hauling cargo ...
Vehicle ID:AIR2501: Flying at 1200.0 ...
Vehicle ID:SHIP121: Sailing with cargo.
Vehicle ID:AIR111: Flying at 2500.0 ...
Vehicle ID:TRUCK007: Hauling cargo ...
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
2
REMOVING VEHICLE
Enter Vehicle ID:
TRUCK007
Removed Vehicle ID: TRUCK007
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
2
REMOVING VEHICLE
Enter Vehicle ID:
V101
Could not remove vehicle!
Error:Exceptions.InvalidOperationException: Vehicle with this ID has not been found.

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
7
SAVE FLEET
Enter Filename To Save At:
newdemo.csv
Saved Fleet Information to File newdemo.csv

{newdemo.csv content:
Car,CAR1411,Toyota,120.000000,1230.000000,4,563.000000,5,0,false
Bus,BUS1211,Volvo,120.000000,8730.000000,8,553.611111,5,0,2000.000000,1125.000000,false
Truck,TRUCK002,Mahindra,120.000000,8730.000000,8,552.833333,2000.000000,1125.000000,false
Airplane,AIR2501,Airbus A350,1000.000000,20.000000,1200.000000,919.000000,250,120,1000.000000,540.000000,false
Cargoship,SHIP121,ship,120.000000,8730.000000,false,550.611111,2000.000000,1125.000000,false
Airplane,AIR111,AIRBUS A380,1200.000000,10.000000,2500.000000,498.000000,200,0,10000.000000,0.000000,false}

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
9
SEARCH BY TYPE:
Vehicle Type:
1. Car
2. Truck
3. Bus
4. Airplane
5. Cargoship
Enter Vehicle Type Number:
4
Vehicles of required class:

Vehicle ID: AIR2501 | Model: Airbus A350 | Current Mileage: 20.00 | Maximum Speed: 1000.00
Vehicle ID: AIR111 | Model: AIRBUS A380 | Current Mileage: 10.00 | Maximum Speed: 1200.00
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
12
Fleet Sorted By Efficiency!
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
13
BOARD PASSENGERS VEHICLE
Enter Vehicle ID:
AIR111
Enter number of passengers to board:
20
Boarded passengers in vehicle: AIR111
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
14
DISEMBARK PASSENGERS VEHICLE
Enter Vehicle ID:
AIR111
Enter number of passengers to disembark:
12
Disembarked passengers from vehicle: AIR111
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
15
LOAD CARGO VEHICLE
Enter Vehicle ID:
TRUCK001
Enter amount of cargo to load:
40
Could not load cargo!
Error:Exceptions.InvalidOperationException: Vehicle with this ID has not been found.

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
15
LOAD CARGO VEHICLE
Enter Vehicle ID:
TRUCK002
Enter amount of cargo to load:
20
Loaded cargo to vehicle: TRUCK002
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
16
UNLOAD CARGO VEHICLE
Enter Vehicle ID:
TRUCK002
Enter amount of cargo to unload:
30
Unloaded cargo from vehicle: TRUCK002
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
17
ESTIMATE JOURNEY TIME
Enter Vehicle ID:
AIR111
Enter distance:
200
Estimated time: 0.15833333333333333
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Add Passengers by Vehicle ID
14. Disembark Passengers by Vehicle ID
15. Load Cargo by Vehicle
16. Unload Cargo by Vehicle ID
17. Estimate Journey Time by Vehicle ID
18. Exit
Please Enter Your Choice Number:
18
Program Exited.




