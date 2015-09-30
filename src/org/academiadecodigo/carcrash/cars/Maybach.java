package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by cadet on 23/09/15.
 */
public class Maybach extends Car {
    public CarType carType = CarType.MAYBACH;

    public Maybach(CarType carType, int speed) {
        super(carType, speed, "CarCrash/car-crash/src/org/academiadecodigo/carcrash/Resources/BlackAnt.png");
    }

 /*   @Override
    public String toString() {
        return this.carType.getSymbol();
    }*/

}
