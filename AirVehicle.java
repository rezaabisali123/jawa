class AirVehicle extends Vehicle {
    private double maxAltitude;

    public AirVehicle(
            int seats,
            String name,
            double fuels,
            int speed,
            double maxAltitude
    ){
        super(seats, name, fuels, speed);
        this.maxAltitude = maxAltitude;
    }

    @Override
    public void move(){
        System.out.println(
            getName() + " is flying at "
            + getSpeed() + " km/h "
            + "at altitude " + maxAltitude + " meters"
        );
    }

    @Override
    public double calculateFuelConsumption(double distance){
        return distance / (getFuels() * 0.8);
    }
}