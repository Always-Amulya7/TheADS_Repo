import java.util.*;

import javax.security.sasl.SaslClientFactory;

class Car {
    private String make;
    private String model;

    Car(String make, String model) {
        this.make = make;
        this.model = model;
        System.out.println("Welcome To Car Shop");
    }

    void set(String make, String model) {
        this.make = make;
        this.model = model;
    }

    void get() {
        System.out.println("The Make Is: " + make);
        System.out.println("The Model Is: " + model);
    }
}

class CarTester {
    public static void main(String args[]) {
        System.out.println("My Car Details-1: ");
        Car myCar1 = new Car("Indian", "Fortuner");
        myCar1.get();
        System.out.println("My Car Details-2: ");
        Car myCar2 = new Car(null, null);
        myCar2.set("German", "Maserati");
        myCar2.get();
    }
}
