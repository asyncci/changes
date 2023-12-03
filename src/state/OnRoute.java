package state;

import exceptions.CustomException;
import model.Driver;
import model.Truck;

public class OnRoute implements State{
    @Override
    public void changeDriver(Truck truck, Driver driver) throws CustomException {
        throw new CustomException("The truck is on the way, it is impossible to change the driver");
    }

    @Override
    public void startDriving(Truck truck) throws CustomException {
        throw new CustomException("The truck is on its way");
    }

    @Override
    public void startRepair(Truck truck) {
        truck.setStateObj(new OnRepair());
        truck.setState("repair");
        System.out.println("successfully completed repairs! ");
    }
}
