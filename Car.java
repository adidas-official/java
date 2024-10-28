import java.lang.Math;

public class Car {
    String color;
    String manufactor;
    String model;
    int year;
    int seats;
    double weight;
    double engineVolume;
    int power;
    boolean automaticTransmission;
    int topSpeed;
    double price;

    public Car (String color, String manufactor, String model, int year, double weight, int power, int seats, double engineVolume, boolean automaticTransmission) {
        this.color = color;
        this.manufactor = manufactor;
        this.model = model;
        this.year = year;
        this.seats = seats;
        this.weight = weight;
        this.engineVolume = engineVolume;
        this.automaticTransmission = automaticTransmission;
        this.power = power;
        this.topSpeed = calculateTopSpeed();
    };

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private int calculateTopSpeed() {
        double dragCoeff = 0.3;
        double frontArea = 2.2;
        double airDensity = 1.225;
        return (int) (Math.sqrt( 2 * this.power * 1000 / (airDensity * frontArea * dragCoeff) ) * 3.6);
    }

    public double getTopSpeed() {
        return this.topSpeed;
    }

    // calculate price of the car
    public double calculatePrice() {
        double price = 0;
        price += this.year * 1000;
        price += this.power * 100;
        price += this.engineVolume * 1000;
        price += this.weight * 10;
        price += this.seats * 1000;
        if (this.automaticTransmission) {
            price += 2000;
        }
        return price;
    }

    public static void main(String[] args) {
        Car audiR8 = new Car("Silver", "Audi", "R8", 2008, 1900, 550, 2, 5.8, false);
        Car skodaFabia = new Car("Blue", "Skoda", "Fabia", 2018, 1500, 86, 4, 1.1, false);

        System.out.println("Top speed of R8 is " + audiR8.getTopSpeed() + "m/s");

    }

};
