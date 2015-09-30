package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public final class Field {

    public static int colSize;
    public static int rowSize;
    public static int colNumber;
    public static int rowNumber;
    public static int height;
    public static int width;

    //This class is not supposed to be instantiated
    private Field() {
    }

    //Gameboard
    private static Rectangle board;


    /**
     * Initializes the Screen
     * @param width screen width
     * @param height screen height
     */

    /*public static void init(int width, int height) {

        // Create the GUI
        screen = TerminalFacade.createScreen();


        // Set field size
        Field.width = width;
        Field.height = height;
        screen.getTerminal().setCursorVisible(false); // Not Working
        screen.getTerminal().getTerminalSize().setColumns(width);
        screen.getTerminal().getTerminalSize().setRows(height);

        // Default screen writing options
        screenWriter = new ScreenWriter(screen);
        screenWriter.setBackgroundColor(Terminal.Color.BLUE);
        screenWriter.setForegroundColor(Terminal.Color.WHITE);

        screen.startScreen();

    }*/

    public static void init(int width, int height, int cols, int rows) {

        board = new Rectangle(0, 0, width, height);

        Field.rowNumber = rows;
        Field.colNumber = cols;
        Field.height = height;
        Field.width = width;
        Field.colSize = width/cols;
        Field.rowSize = height/rows;

    }

    public static int getColSize() {
        return colSize;
    }

    public static int getRowSize() {
        return rowSize;
    }

    /**
     * Displays a group of cars in the screen
     * @param cars an array of cars
     */


    public static void draw(Car[] cars) {

        board.draw();
        for (Car car : cars) {
           car.createRepresentation();
        }

    }

    public static void changeBoardColor(Color color) {
        board.setColor(color);
        board.fill();
    }

}
