package factorymethod;

public class ThreeWheelerFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new ThreeWheeler();
    }
}