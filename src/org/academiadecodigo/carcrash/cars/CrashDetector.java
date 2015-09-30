package org.academiadecodigo.carcrash.cars;


/**
 * Created by cadet on 24/09/15.
 */
public class CrashDetector {

    public static int savedCrashes;

    /*
    public static Vector<Car> carList = new Vector<Car>();

    public void addCar(Car car) {
        carList.addElement(car);
    }*/

    public static Car[] carList;

    public static void setCarList(Car[] carList) {
        CrashDetector.carList = carList;
    }

    public static void crashDetection(Car car) {
        for (Car car2 : carList) {
            if (!car.equals(car2)) {

                if (car.getPos().equals(car2.getPos()) /*&& !car2.isCrashed()*/) {
                    if (car.carType != CarType.HEALER && car2.carType != CarType.HEALER) {
                        car.setCrashed(true);
                        car2.setCrashed(true);
                        car.representation.load("CarCrash/car-crash/src/org/academiadecodigo/carcrash/Resources/Cross.png");
                        car.representation.draw();
                        car2.representation.load("CarCrash/car-crash/src/org/academiadecodigo/carcrash/Resources/Cross.png");
                        car2.representation.draw();

                    } else {
                        car.setCrashed(false);
                        car2.setCrashed(false);
                        car.representation.load(car.picLink);
                        car.representation.draw();
                        car2.representation.load(car2.picLink);
                        car2.representation.draw();
                        savedCrashes++;
                    }
                }

            }
        }
    }


}
