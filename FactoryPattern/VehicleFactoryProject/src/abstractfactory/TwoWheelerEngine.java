package abstractfactory;

public class TwoWheelerEngine implements Engine {
    @Override
    public String getSpecification() {
        return "250cc Single-Cylinder Engine";
    }
}