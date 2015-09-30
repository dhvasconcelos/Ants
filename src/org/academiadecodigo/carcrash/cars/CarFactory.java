package org.academiadecodigo.carcrash.cars;

public class CarFactory {

    public static int player;

    public static Car getNewCar() {
        Car car;
        CarType carType;
        double probability = Math.random();

        if (probability < 0.25) {
            carType = CarType.FERRARI;
        } else if (probability < 0.5) {
            carType = CarType.BUGATTI;
        } else if (probability < 0.75) {
            carType = CarType.LAMBORGHINI;
        } else {
            carType = CarType.MAYBACH;
        }

      //  if (player < 1) {
        //    player++;
          //  System.out.println("Created a new Healer");
          //  car = new PlayerCar(4);


//        } else {
            switch (carType) {
                case FERRARI:
                    car = new Ferrari(carType, 3);
                    break;

                case BUGATTI:
                    car = new Bugatti(carType, 4);
                    break;

                case LAMBORGHINI:
                    car = new Lamborghini(carType, 3);
                    break;

                case MAYBACH:
                    car = new Maybach(carType, 2);
                    break;

                default:
                    car = null;
                    break;
            }
  //      }

        return car;

    }

}
