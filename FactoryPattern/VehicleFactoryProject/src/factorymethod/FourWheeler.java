package factorymethod;

public class FourWheeler implements Vehicle {
    @Override
    public void assemble() {
        System.out.println("Assembling Four-Wheeler (Car/Sedan)...");
    }

    @Override
    public void testDrive() {
        System.out.println("Test driving Four-Wheeler: Safe and comfortable!");
    }
}