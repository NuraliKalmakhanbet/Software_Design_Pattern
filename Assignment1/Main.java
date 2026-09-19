enum CarType {
    SPORTS_CAR, SUV, CITY_CAR
}

enum Transmission {
    MANUAL, AUTOMATIC, SEMI_AUTOMATIC
}

class Engine {
    private final double volume;
    private final int horsepower;

    public Engine(double volume, int horsepower) {
        this.volume = volume;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return horsepower + " HP, " + volume + "L";
    }
}

class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final boolean hasGps;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission, boolean hasGps) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.hasGps = hasGps;
    }

    @Override
    public String toString() {
        return "Car [" + carType + "]: Seats=" + seats + 
               ", Engine=" + engine + ", Transmission=" + transmission + 
               ", GPS=" + (hasGps ? "Yes" : "No");
    }
}

interface Builder {
    Builder reset();
    Builder setCarType(CarType carType);
    Builder setSeats(int seats);
    Builder setEngine(Engine engine);
    Builder setTransmission(Transmission transmission);
    Builder setGps(boolean hasGps);
}

class SportsCarBuilder implements Builder {
    private static final int MIN_SEATS = 1;
    private static final int MAX_SEATS = 2;

    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private boolean hasGps;

    @Override
    public SportsCarBuilder reset() {
        this.carType = CarType.SPORTS_CAR;
        this.seats = 0;
        this.engine = null;
        this.transmission = null;
        this.hasGps = false;
        return this;
    }

    @Override
    public SportsCarBuilder setCarType(CarType carType) {
        this.carType = carType;
        return this;
    }

    @Override
    public SportsCarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public SportsCarBuilder setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public SportsCarBuilder setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    @Override
    public SportsCarBuilder setGps(boolean hasGps) {
        this.hasGps = hasGps;
        return this;
    }

    public Car build() {
        validateState();
        return new Car(carType, seats, engine, transmission, hasGps);
    }

    private void validateState() {
        if (seats < MIN_SEATS || seats > MAX_SEATS) {
            throw new IllegalStateException("Sports car seats must be between " + MIN_SEATS + " and " + MAX_SEATS);
        }
        if (engine == null) {
            throw new IllegalStateException("Engine is required");
        }
    }
}

class StandardCarBuilder implements Builder {
    private static final int MIN_SEATS = 1;
    private static final int MAX_SEATS = 8;

    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private boolean hasGps;

    @Override
    public StandardCarBuilder reset() {
        this.carType = CarType.CITY_CAR;
        this.seats = 0;
        this.engine = null;
        this.transmission = null;
        this.hasGps = false;
        return this;
    }

    @Override
    public StandardCarBuilder setCarType(CarType carType) {
        this.carType = carType;
        return this;
    }

    @Override
    public StandardCarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public StandardCarBuilder setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public StandardCarBuilder setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    @Override
    public StandardCarBuilder setGps(boolean hasGps) {
        this.hasGps = hasGps;
        return this;
    }

    public Car build() {
        validateState();
        return new Car(carType, seats, engine, transmission, hasGps);
    }

    private void validateState() {
        if (seats < MIN_SEATS || seats > MAX_SEATS) {
            throw new IllegalStateException("Standard car seats must be between " + MIN_SEATS + " and " + MAX_SEATS);
        }
        if (engine == null) {
            throw new IllegalStateException("Engine is required");
        }
    }
}

class Director {
    public void constructSportsCar(Builder builder) {
        builder.reset()
               .setCarType(CarType.SPORTS_CAR)
               .setSeats(2)
               .setEngine(new Engine(3.0, 450))
               .setTransmission(Transmission.SEMI_AUTOMATIC)
               .setGps(true);
    }

    public void constructCityCar(Builder builder) {
        builder.reset()
               .setCarType(CarType.CITY_CAR)
               .setSeats(4)
               .setEngine(new Engine(1.6, 120))
               .setTransmission(Transmission.AUTOMATIC)
               .setGps(false);
    }
}

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        SportsCarBuilder sportsBuilder = new SportsCarBuilder();
        director.constructSportsCar(sportsBuilder);
        Car sportsCar = sportsBuilder.build();
        System.out.println(sportsCar);

        StandardCarBuilder standardBuilder = new StandardCarBuilder();
        director.constructCityCar(standardBuilder);
        Car cityCar = standardBuilder.build();
        System.out.println(cityCar);

        Car customCar = new StandardCarBuilder()
                .reset()
                .setCarType(CarType.SUV)
                .setSeats(7)
                .setEngine(new Engine(2.5, 290))
                .setTransmission(Transmission.AUTOMATIC)
                .setGps(true)
                .build();
        System.out.println(customCar);
    }
}