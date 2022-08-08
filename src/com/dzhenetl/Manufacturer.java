package com.dzhenetl;

public class Manufacturer {
    final int CAR_BUILD_TIMEOUT = 3000;

    public synchronized void buildCar(Shop shop, int i) {
        for (int j = 0; j < i; j++) {
            try {
                Thread.sleep(CAR_BUILD_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
            shop.addCar(new Car());
        }
    }
}
