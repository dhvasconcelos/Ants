package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int col;
    private int row;



    public Position() {
        int colPosition = (int) (Math.random() * Field.colNumber);
        int rowPosition = (int) (Math.random() * Field.rowNumber);

        setCol(colPosition);
        setRow(rowPosition);


    }

    public void setCol(int colPosition) {
        col = colPosition;
    }

    public void setRow(int rowPosition) {
        row = rowPosition;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean equals(Position position) {

        if (this.getCol() == position.getCol() &&
                this.getRow() == position.getRow()) {
            return true;

        } else {
            return false;
        }
    }

    public double getCurrentColPosition() {
        return col * Field.getColSize();
    }

    public double getCurrentRowPosition() {
        return row * Field.getRowSize();
    }


}
