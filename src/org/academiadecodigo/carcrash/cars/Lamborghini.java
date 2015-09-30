package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by cadet on 23/09/15.
 */
public class Lamborghini extends Car {
    CarType carType = CarType.LAMBORGHINI;

    public Lamborghini(CarType carType, int speed) {
        super(carType, speed, "CarCrash/car-crash/src/org/academiadecodigo/carcrash/Resources/AnotherAnt.gif");
    }

  /*  @Override
    public String toString() {
        return this.carType.getSymbol();
    }*/

}
