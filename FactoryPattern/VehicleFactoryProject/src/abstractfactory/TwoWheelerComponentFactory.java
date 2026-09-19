package abstractfactory;

public class TwoWheelerComponentFactory implements VehicleComponentFactory {
    @Override
    public Engine createEngine() {
        return new TwoWheelerEngine();
    }

    @Override
    public Tire createTire() {
        return new TwoWheelerTire();
    }
}