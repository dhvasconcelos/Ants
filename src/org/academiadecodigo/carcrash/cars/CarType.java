package org.academiadecodigo.carcrash.cars;

/**
 * Created by cadet on 23/09/15.
 */
public enum CarType {
        LAMBORGHINI("L"),
        FERRARI("F"),
        BUGATTI("B"),
        MAYBACH("M"),
        HEALER("H");


        private String symbol;

        private CarType(String symbol){
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

}
