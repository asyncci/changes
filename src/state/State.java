package state;

import exceptions.CustomException;
import model.Driver;
import model.Truck;

public interface State {
    void changeDriver(Truck truck, Driver driver) throws CustomException;

    void startDriving(Truck truck) throws CustomException;

    void startRepair(Truck truck) throws CustomException;
}
