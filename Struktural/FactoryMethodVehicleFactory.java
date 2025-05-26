interface Vehicle {
    void assemble();
    String getType();
}

class Car implements Vehicle {
    public void assemble() { System.out.println("Assembling Car"); }
    public String getType() { return "Car"; }
}

class Truck implements Vehicle {
    public void assemble() { System.out.println("Assembling Truck"); }
    public String getType() { return "Truck"; }
}

abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
    public void produceVehicle() {
        Vehicle vehicle = createVehicle();
        vehicle.assemble();
        System.out.println("Produced: " + vehicle.getType());
    }
}

class CarFactory extends VehicleFactory {
    public Vehicle createVehicle() { return new Car(); }
}

class TruckFactory extends VehicleFactory {
    public Vehicle createVehicle() { return new Truck(); }
}

public class FactoryMethodVehicleFactory {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();
        carFactory.produceVehicle();
        truckFactory.produceVehicle();
    }
}