package com.dzhenetl;

public class Main {

    public static void main(String[] args) {

        final int CUSTOMER_COUNT = 10;

        final Shop shop = new Shop();
        final Manufacturer manufacturer = new Manufacturer();

        new Thread(null, () -> manufacturer.buildCar(shop, CUSTOMER_COUNT), "Производитель Toyota").start();

        for (int i = 1; i <= CUSTOMER_COUNT; i++) {
            new Thread(null, shop::sellCar, "Покупатель " + i).start();
        }
    }
}
