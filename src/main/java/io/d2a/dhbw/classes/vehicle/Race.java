package io.d2a.dhbw.classes.vehicle;

public class Race {

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Bike(20);
        vehicles[1] = new Car(150);
        vehicles[2] = new RacingCar(200);
        vehicles[3] = new AmbulanceCar(80, true);

        // set current speed to max speed
        for (final Vehicle vehicle : vehicles) {
            vehicle.setSpeed(vehicle.getvMax());
        }

        // 4 hours lead for the bike
        vehicles[0].drive(240.0);

        // 1 hour of driving for everyone
        for (final Vehicle vehicle : vehicles) {
            vehicle.drive(60);
        }

        // Output Race
        for (final Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

}
