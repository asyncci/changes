package model;

import exceptions.CustomException;
import state.State;


public class Truck {
    private int id;
    private String name;
    private String driver;
    private String state;
    private State stateObj;

    private Truck() {
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setStateObj(State stateObj) {
        this.stateObj = stateObj;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getDriver() {
        return driver;
    }

    public String getDrivers() {
        return driver;
    }

    public void changeDriver(Driver driver1) {
        try {
            stateObj.changeDriver(this, driver1);
        } catch (CustomException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startDriving() {
        try {
            stateObj.startDriving(this);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startRepair() {
        try {
            stateObj.startRepair(this);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("|%2d | %-15s | %-15s | %-9s|", id, name, driver, state);
    }

    public String toString2() {
        return String.format("%-10s: %d%n%-10s: %s%n%-10s: %s%n%-10s: %s%n", "#", id, "Bus", name, "Driver", driver, "Bus state", state);
    }
}
