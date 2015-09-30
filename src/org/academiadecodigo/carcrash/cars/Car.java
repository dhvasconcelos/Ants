package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

abstract  public class Car {

    /** The position of the car on the grid */
    Position pos;
    CarType carType;
    CrashDetector crashDetector;
    private boolean crashed;
    public Picture representation;
    int movement;
    MoveDirection lastDirection = MoveDirection.NORTH;
    String picLink;




    //Constructor with random placement
    public Car (CarType carType, int movement, String link) {
        this.carType = carType;
        this.movement = movement;
        this.pos = new Position();
        this.crashDetector = new CrashDetector();
        this.picLink = link;

    }

    public void createRepresentation() {
        this.representation = new Picture(pos.getCurrentColPosition(), pos.getCurrentRowPosition(),
                picLink);
        this.representation.draw();
    }

    public Position getPos() {
        return pos;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCrashed(boolean check) {
        this.crashed = check;
    }

    public boolean isCrashed() {
        return crashed;
    }


    public void move() {
        MoveDirection moveDirection = chooseDirection();
        int movementsRemaining = movement;

        if (isCrashed()) {
            return;
        }


        while (movementsRemaining > 0) {

          //  if (movementsRemaining % 4 == 0) {
          //      moveDirection = chooseDirection();
          //  }
            if (isCrashed()) {
                return;
            }

            switch (moveDirection) {
                case EAST:
                    if (pos.getCol() + 1 == Field.colNumber) {
                        this.move();

                    } else {
                       if (pos.getCol() + 1 < Field.colNumber) {
                           representation.translate(Field.getColSize() ,0);
                           pos.setCol(pos.getCol() + 1);
                           lastDirection = MoveDirection.EAST;
                       }
                    }
                    break;

                case WEST:
                    if (pos.getCol() - 1 < 0) {
                        this.move();

                    } else {
                        if (pos.getCol() - 1 >= 0) {
                            representation.translate(-Field.getColSize() ,0);
                            pos.setCol(pos.getCol() - 1);
                            lastDirection = MoveDirection.WEST;
                        }
                    }
                    break;

                case NORTH:
                    if (pos.getRow() - 1 < 0) {
                        this.move();

                    } else {
                        if (pos.getRow() - 1 >= 0) {
                            representation.translate(0, -Field.getRowSize());
                            pos.setRow(pos.getRow() - 1);
                            lastDirection = MoveDirection.NORTH;
                        }
                    }
                    break;

                case SOUTH:
                    if (pos.getRow() + 1 == Field.rowNumber) {
                        this.move();

                    } else {
                        if (pos.getRow() + 1 < Field.rowNumber) {
                            representation.translate(0, Field.getRowSize());
                            pos.setRow(pos.getRow() + 1);
                            lastDirection = MoveDirection.SOUTH;
                        }
                    }
                    break;
            }
            movementsRemaining--;
            crashDetector.crashDetection(this);
        }
    }


    public MoveDirection chooseDirection() {
        MoveDirection moveDirection;

        double probability = Math.random();


        if (probability < 0.25){
            moveDirection = MoveDirection.EAST;
        } else if (probability < 0.5) {
            moveDirection = MoveDirection.WEST;
        } else if (probability < 0.75) {
            moveDirection = MoveDirection.NORTH;
        } else {
            moveDirection = MoveDirection.SOUTH;
        }

        return moveDirection;
    }

    @Override
    public String toString() {
        return this.isCrashed() ? "C" : this.carType.getSymbol();
    }
}
