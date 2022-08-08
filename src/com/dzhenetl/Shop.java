package com.dzhenetl;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    final List<Car> cars = new ArrayList<>(10);

    public synchronized void addCar(Car car) {
        cars.add(car);
        notify();
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в магазин");
            while (cars.size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        return cars.remove(0);
    }
}
