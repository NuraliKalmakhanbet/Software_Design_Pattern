package abstractfactory;

public class ThreeWheelerEngine implements Engine {
    @Override
    public String getSpecification() {
        return "500cc Twin-Cylinder CNG/Petrol Engine";
    }
}