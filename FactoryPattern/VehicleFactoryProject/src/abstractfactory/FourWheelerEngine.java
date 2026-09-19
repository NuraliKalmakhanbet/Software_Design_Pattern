package abstractfactory;

public class FourWheelerEngine implements Engine {
    @Override
    public String getSpecification() {
        return "2.0L Turbocharged Inline-4 Engine";
    }
}