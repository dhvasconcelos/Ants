package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.field.Field;

public class Game {

    /** Graphical Car Field */
    Field field;

    /** Container of Cars */
    Car[] cars;

    /** Animation delay */
    int delay;

    Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[]{
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
                CarFactory.getNewCar(),
        };

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars

            // Update screen
            Field.draw(cars);

        }

    }

}
