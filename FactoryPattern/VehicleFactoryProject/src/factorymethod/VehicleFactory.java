package factorymethod;

public abstract class VehicleFactory {
    
    public abstract Vehicle createVehicle();

    public Vehicle deliverVehicle() {
        Vehicle vehicle = createVehicle();
        vehicle.assemble();
        vehicle.testDrive();
        return vehicle;
    }
}