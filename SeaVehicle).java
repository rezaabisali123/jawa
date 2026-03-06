class SeaVehicle extends Vehicle {
    private String shipType;

    public SeaVehicle(
            int seats,
            String name,
            double fuels,
            int speed,
            String shipType
    ){
        super(seats, name, fuels, speed);
        this.shipType = shipType;
    }

    @Override
    public void move(){
        System.out.println(
            getName() + " is sailing as a "
            + shipType
            + " with speed "
            + getSpeed() + " km/h"
        );
    }

    @Override
    public double calculateFuelConsumption(double distance){
        return distance / (getFuels() * 0.6);
    }
}