package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by cadet on 23/09/15.
 */
public class Ferrari extends Car {
    public CarType carType = CarType.FERRARI;


    public Ferrari(CarType carType, int speed) {
        super(carType, speed, "CarCrash/car-crash/src/org/academiadecodigo/carcrash/Resources/AntPolice.jpeg");
    }


  /*  @Override
    public String toString() {
        return this.carType.getSymbol();
    } */
}
