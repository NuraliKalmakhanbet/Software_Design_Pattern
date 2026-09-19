package abstractfactory;

public class ThreeWheelerComponentFactory implements VehicleComponentFactory {
    @Override
    public Engine createEngine() {
        return new ThreeWheelerEngine();
    }

    @Override
    public Tire createTire() {
        return new ThreeWheelerTire();
    }
}