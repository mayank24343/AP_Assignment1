AP Assignment1
Mayank Yadav 2024343

1) Inheritance and Abstraction

Vehicle is the parent class.
It is an abstract class (partially defined), with some
abstract methods:
concrete methods:
concrete attributes:

It is inherited by children classes LandVehicle, WaterVehicle and AirVehicle (concrete attributes and methods are inherited).
They are also abstract as they override and implement the estimateJourneyTime() method but other abstract methods are not implemented.

LandVehicle contains,
concrete attributes:
concrete methods:
abstract methods:

It is inherited by children classes Car, Bus and Truck (concrete attributes and methods are inherited).
These are concrete classes - all methods are concrete i.e. implemented fully.
They contain the respective concrete attributes and methods as given in the UML diagram.

Similarly,
WaterVehicle contains,
concrete attributes:
concrete methods:
abstract methods:

It is inherited by children class Cargoship (concrete attributes and methods are inherited).
It is a concrete classes - all methods are concrete i.e. implemented fully.
It contains the respective concrete attributes and methods as given in the UML diagram.

and
AirVehicle contains,
concrete attributes:
concrete methods:
abstract methods:

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



