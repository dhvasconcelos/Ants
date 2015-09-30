package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by cadet on 23/09/15.
 */
public class Bugatti extends Car {
    public CarType carType = CarType.BUGATTI;


    public Bugatti(CarType carType, int speed) {
        super(carType, speed, "CarCrash/car-crash/src/org/academiadecodigo/carcrash/Resources/DigitalAnt.jpg");
    }

   /* @Override
    public String toString() {
        return this.carType.getSymbol();
    }*/
}
