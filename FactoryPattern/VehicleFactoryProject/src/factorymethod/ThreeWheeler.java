package factorymethod;

public class ThreeWheeler implements Vehicle {
    @Override
    public void assemble() {
        System.out.println("Assembling Three-Wheeler (Tuk-Tuk/Rickshaw)...");
    }

    @Override
    public void testDrive() {
        System.out.println("Test driving Three-Wheeler: Balanced urban transport!");
    }
}