package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;

/**
 * Created by cadet on 28/09/15.
 */
public class PlayerCar extends Car {
    public CarType carType = CarType.HEALER;

    public PlayerCar(int movement) {
        super(CarType.HEALER, movement, "CarCrash/car-crash/src/org/academiadecodigo/carcrash/Resources/AntMan.jpg");
    }


    @Override
    public void move() {

    }

    public void moveNorth() {
        if (pos.getRow() - 1 >= 0) {
            representation.translate(0, -Field.getRowSize());
            pos.setRow(pos.getRow() - 1);
        }
        crashDetector.crashDetection(this);
    }

    public void moveSouth() {
        if (pos.getRow() + 1 < Field.rowNumber) {
            representation.translate(0, Field.getRowSize());
            pos.setRow(pos.getRow() + 1);
        }
        crashDetector.crashDetection(this);
    }

    public void moveEast() {
        if (pos.getCol() + 1 < Field.colNumber) {
            representation.translate(Field.getColSize(), 0);
            pos.setCol(pos.getCol() + 1);
        }
        crashDetector.crashDetection(this);
    }

    public void moveWest() {
        if (pos.getCol() - 1 >= 0) {
            representation.translate(-Field.getColSize(), 0);
            pos.setCol(pos.getCol() - 1);
        }
        crashDetector.crashDetection(this);
    }



}
