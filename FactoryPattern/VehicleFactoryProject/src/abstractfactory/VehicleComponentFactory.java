package abstractfactory;

public interface VehicleComponentFactory {
    Engine createEngine();
    Tire createTire();
}