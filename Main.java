abstract class Vehicle {
    private int seats;
    private String name;
    private double fuels;
    private int speed;

    public Vehicle(int seats, String name, double fuels, int speed) {
        this.seats = seats;
        this.name = name;
        this.fuels = fuels;
        // FIX: speed selalu terisi
        this.speed = Math.min(speed, 200);
    }

    // Getter
    public int getSeats() { return seats; }
    public String getName() { return name; }
    public double getFuels() { return fuels; }
    public int getSpeed() { return speed; }

    // Setter
    public void setSeats(int seats) { this.seats = seats; }
    public void setName(String name) { this.name = name; }
    public void setFuels(double fuels) { this.fuels = fuels; }
    public void setSpeed(int speed) { this.speed = Math.min(speed, 200); }

    public abstract void move();
    public abstract double calculateFuelConsumption(double distance);
}


class LandVehicle extends Vehicle {
    private int wheels;

    public LandVehicle(int seats, String name, double fuels, int speed, int wheels) {
        super(seats, name, fuels, speed);
        this.wheels = wheels;
    }

    @Override
    public void move() {
        System.out.println(
            getName() + " is moving on " + wheels +
            " wheels with speed " + getSpeed() + " km/h"
        );
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance / getFuels();
    }
}


class AirVehicle extends Vehicle {
    private int altitude;

    public AirVehicle(int seats, String name, double fuels, int speed, int altitude) {
        super(seats, name, fuels, speed);
        this.altitude = altitude;
    }

    @Override
    public void move() {
        System.out.println(
            getName() + " is flying at " + getSpeed() +
            " km/h at altitude " + altitude + " meters"
        );
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance / (getFuels() * 0.8);
    }
}


class SeaVehicle extends Vehicle {
    private String type;

    public SeaVehicle(int seats, String name, double fuels, int speed, String type) {
        super(seats, name, fuels, speed);
        this.type = type;
    }

    @Override
    public void move() {
        System.out.println(
            getName() + " is sailing as a " + type +
            " with speed " + getSpeed() + " km/h"
        );
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance / (getFuels() * 0.6);
    }
}


public class Main {
    public static void main(String[] args) {

        Vehicle car = new LandVehicle(4, "Car", 50, 120, 4);
        car.move();
        System.out.println("Fuel: " + car.calculateFuelConsumption(200));

        Vehicle bike = new LandVehicle(2, "Motor Bike", 8.1, 100, 2);
        bike.move();
        System.out.println("Fuel: " + bike.calculateFuelConsumption(100));

        Vehicle plane = new AirVehicle(180, "Airplane", 3000, 900, 10000);
        plane.move();
        System.out.println("Fuel: " + plane.calculateFuelConsumption(1000));

        Vehicle ship = new SeaVehicle(50, "Ship", 5000, 80, "Cargo Ship");
        ship.move();
        System.out.println("Fuel: " + ship.calculateFuelConsumption(500));
    }
}