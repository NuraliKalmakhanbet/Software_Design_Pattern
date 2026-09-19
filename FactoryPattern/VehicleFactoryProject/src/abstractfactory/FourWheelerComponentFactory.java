package abstractfactory;

public class FourWheelerComponentFactory implements VehicleComponentFactory {
    @Override
    public Engine createEngine() {
        return new FourWheelerEngine();
    }

    @Override
    public Tire createTire() {
        return new FourWheelerTire();
    }
}