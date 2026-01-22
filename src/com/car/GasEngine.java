package com.car;

public class GasEngine extends Motor {
    @Override
    public void start() {
        startFuelPump();
        injectFuel();
        removeExhaust();
        System.out.println("Engine is started");
    }

    private void removeExhaust() {
        System.out.println("Exhast has been removed");
    }

    private void injectFuel() {
        System.out.println("Fuel is injected");
        startFuelPump();
    }

    private void startFuelPump() {
        System.out.println("Fuel pump is pumping");
    }
}
