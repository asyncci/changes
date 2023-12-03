package state;

import exceptions.CustomException;
import model.Driver;
import model.Truck;

public class OnBase implements State {
    @Override
    public void changeDriver(Truck truck, Driver driver) {
//        if (driver != null) {
            truck.setDriver(driver.getId());
            System.out.printf("Now the %s truck is driven by the driver %s%n", truck.getName(), driver.getName());
//        } else {
//            System.out.println("No available drivers");
//        }
    }

    @Override
    public void startDriving(Truck truck) throws CustomException {
        if (truck.getDriver() != null && !truck.getDriver().isEmpty()) {
            truck.setStateObj(new OnRoute());
            truck.setState("route");
            System.out.println("Successfully set out on the route!");
        } else {
            throw new CustomException("The truck does not have a driver assigned");
        }
    }

    @Override
    public void startRepair(Truck truck) throws CustomException{
        if (truck.getDriver() != null && !truck.getDriver().isEmpty()) {
            truck.setStateObj(new OnRepair());
            truck.setState("repair");
            System.out.println("Successfully completed repairs!");
        } else {
            throw new CustomException("The truck does not have a driver assigned");
        }
    }

//    @Override
//    public void changeDriver(Truck truck, Driver newDriver) throws CustomException {
//        if (newDriver != null) {
//            Driver currentDriver = findCurrentDriver(truck);
//            if (currentDriver != null) {
//                // Освободить предыдущего водителя
//                currentDriver.setAssigned(false);
//
//                // Освободить предыдущий грузовик
//                Truck currentTruck = findCurrentTruck(currentDriver);
//                if (currentTruck != null) {
//                    currentTruck.setDriver(null);
//                }
//            }
//
//            // Назначить нового водителя
//            newDriver.setAssigned(true);
//            truck.setDriver(newDriver.getId());
//
//            System.out.printf("Now the %s truck is driven by the driver %s%n", truck.getName(), newDriver.getName());
//        } else {
//            System.out.println("No available drivers");
//        }
//    }

//    private Driver findCurrentDriver(Truck truck) {
//        if (truck.getDriver() != null && !truck.getDriver().isEmpty()) {
//            for (Driver driver : truck.getDrivers()) {
//                if (driver.getId().equals(truck.getDriver())) {
//                    return driver;
//                }
//            }
//        }
//        return null;
//    }
//
//    private Truck findCurrentTruck(Driver driver) {
//        for (Truck truck : driver.getTrucks()) {
//            if (truck.getDriver().equals(driver.getId())) {
//                return truck;
//            }
//        }
//        return null;
//    }
}
