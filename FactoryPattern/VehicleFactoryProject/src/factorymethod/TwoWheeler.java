package factorymethod;

public class TwoWheeler implements Vehicle {
    @Override
    public void assemble() {
        System.out.println("Assembling Two-Wheeler (Motorcycle/Bike)...");
    }

    @Override
    public void testDrive() {
        System.out.println("Test driving Two-Wheeler: Agile and fast!");
    }
}