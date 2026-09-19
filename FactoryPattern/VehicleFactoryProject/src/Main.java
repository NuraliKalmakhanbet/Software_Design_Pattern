import factorymethod.VehicleFactory;
import factorymethod.TwoWheelerFactory;
import factorymethod.ThreeWheelerFactory;
import factorymethod.FourWheelerFactory;

import abstractfactory.VehicleComponentFactory;
import abstractfactory.TwoWheelerComponentFactory;
import abstractfactory.ThreeWheelerComponentFactory;
import abstractfactory.FourWheelerComponentFactory;
import abstractfactory.Engine;
import abstractfactory.Tire;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== PART 1: FACTORY METHOD DEMO ===");
        
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        twoWheelerFactory.deliverVehicle();
        System.out.println();

        VehicleFactory threeWheelerFactory = new ThreeWheelerFactory();
        threeWheelerFactory.deliverVehicle();
        System.out.println();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        fourWheelerFactory.deliverVehicle();
        System.out.println();

        System.out.println("=== PART 2: ABSTRACT FACTORY DEMO ===");
        
        buildVehiclePackage(new TwoWheelerComponentFactory());
        System.out.println();

        buildVehiclePackage(new ThreeWheelerComponentFactory());
        System.out.println();

        buildVehiclePackage(new FourWheelerComponentFactory());
    }

    // Client method that works strictly via Abstract Factory and Abstract Product interfaces
    private static void buildVehiclePackage(VehicleComponentFactory componentFactory) {
        Engine engine = componentFactory.createEngine();
        Tire tire = componentFactory.createTire();

        System.out.println("Building vehicle component set:");
        System.out.println(" - Engine: " + engine.getSpecification());
        System.out.println(" - Tires:  " + tire.getType());
    }
}