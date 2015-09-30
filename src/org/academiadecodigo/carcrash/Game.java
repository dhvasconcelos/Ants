package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.*;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Game implements KeyboardHandler {

    /** Container of Cars */
    Car[] cars;

    /** Number of Cars */
    int numberOfCars;

    /** Animation delay */
    int delay;

    /** Game Over **/
    boolean gameOver;

    Keyboard key;



    public Game(int width, int height, int cols, int rows, int delay, int numberOfCars) {

        Field.init(width, height, cols, rows);
        this.delay = delay;
        this.numberOfCars = numberOfCars;
        setKeyboard();

    }


    public Car[] getCars() {
        return cars;
    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        gameOver = false;
        CrashDetector.savedCrashes = 0;

        cars = new Car[numberOfCars];
        CrashDetector.setCarList(cars);


        for(int i = 1; i < numberOfCars; i++) {
            cars[i] = CarFactory.getNewCar();
        }
        cars[0] = new PlayerCar(4);


        Field.draw(cars);

    }


    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */

    public void start() throws InterruptedException {

        double startTime = System.currentTimeMillis();

        while (!gameOver) {


            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            for (Car car : cars) {
                car.move();
                checkGameOver();
            }


        }

        for (Car car : cars) {
            car.representation.delete();
        }

        cars = null;

        //Field.changeBoardColor(Color.BLACK);

        Picture pic = new Picture(Field.width - 475, Field.height - 450,
                "CarCrash/car-crash/src/org/academiadecodigo/carcrash/Resources/GameOver.jpg");
        pic.draw();

        double endTime = System.currentTimeMillis();
        double survivalTime = (int) Math.round((endTime - startTime) / 1000);

        String endMessage = "You managed to keep the colony alive for " + survivalTime + " seconds!";
        String antsSaved = "You saved " + CrashDetector.savedCrashes + " ants!";

        Text finalTime = new Text(125, Field.height - 100, endMessage);
        finalTime.setColor(Color.BLACK);
        finalTime.draw();

        Text finalAntsSaved = new Text(225, Field.height - 50, antsSaved);
        finalAntsSaved.setColor(Color.BLACK);
        finalAntsSaved.draw();


        Thread.sleep(5000);
        pic.delete();
        finalTime.delete();
        finalAntsSaved.delete();
        init();
        start();
    }


    private boolean checkGameOver() {
        int carsCrashed = 0;
        gameOver = false;

        for (Car car : cars) {
            if (car.isCrashed()) {
                carsCrashed++;
            }
        }

        if (carsCrashed > numberOfCars - 2) {
            gameOver = true;
        }


        return gameOver;
    }

    private void setKeyboard() {
        key = new Keyboard(this);
        KeyboardEvent[] events = new KeyboardEvent[8];

        for (int i = 0; i < events.length; i++) {
            events[i] = new KeyboardEvent();
        }

        events[0].setKey(KeyboardEvent.KEY_W);
        events[1].setKey(KeyboardEvent.KEY_S);
        events[2].setKey(KeyboardEvent.KEY_D);
        events[3].setKey(KeyboardEvent.KEY_A);
        events[4].setKey(KeyboardEvent.KEY_UP);
        events[5].setKey(KeyboardEvent.KEY_DOWN);
        events[6].setKey(KeyboardEvent.KEY_LEFT);
        events[7].setKey(KeyboardEvent.KEY_RIGHT);

        for (KeyboardEvent event : events) {
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            key.addEventListener(event);
        }

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (cars == null || cars[0] == null) {
            return;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
            case KeyboardEvent.KEY_W:
                ((PlayerCar) cars[0]).moveNorth();
                break;

            case KeyboardEvent.KEY_DOWN:
            case KeyboardEvent.KEY_S:
                ((PlayerCar) cars[0]).moveSouth();
                break;

            case KeyboardEvent.KEY_RIGHT:
            case KeyboardEvent.KEY_D:
                ((PlayerCar) cars[0]).moveEast();
                break;

            case KeyboardEvent.KEY_LEFT:
            case KeyboardEvent.KEY_A:
                ((PlayerCar) cars[0]).moveWest();
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
