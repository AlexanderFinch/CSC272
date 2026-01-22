package com.car;

public class Car implements DriverInterface{
    private Motor motor;
    private Wheels wheels;
    private GasPedal gasPedal;
    private StartButton startButton;
    private String type;

    public Car(String type){
        this.type = type;
        if(type.equalsIgnoreCase("Gas")) {
            motor = new GasEngine();
        } else if (type.equalsIgnoreCase("Electric")){
            motor = new ElectricMotor();
        }
        wheels = new Wheels();
        gasPedal = new GasPedal();
        startButton = new StartButton();
        System.out.println("\n---------\nNew car created: " + type);
    }

    static public void main(String[] args){
        Car gcar = new Car("Gas");
        DriverInterface di1 = gcar.getDriverInterface();
        di1.startTheCar();


        Car ecar = new Car("Electric");
        DriverInterface di2 = ecar.getDriverInterface();
        di2.startTheCar();
    }

    private DriverInterface getDriverInterface() {
        return this;
    }

    @Override
    public void startTheCar() {
        startButton.pushButton();
        motor.start();
        System.out.println("The car is started");
    }

    @Override
    public void accerateTheCar() {

    }

    @Override
    public void stopTheCar() {

    }
}
