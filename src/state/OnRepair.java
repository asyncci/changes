package state;

import exceptions.CustomException;
import model.Driver;
import model.Truck;

import java.util.Random;

public class OnRepair implements State{

    @Override
    public void changeDriver(Truck truck, Driver driver) throws CustomException {
        throw new CustomException("Can't change driver");
    }

    @Override
    public void startDriving(Truck truck) {
        Random rnd = new Random();
        int x = rnd.nextInt(2);
        if (x==1){
            truck.setStateObj(new OnRoute());
            truck.setState("route");
            System.out.println("successfully repaired the truck and set out on the route");
        }else {
            truck.setStateObj(new OnBase());
            truck.setState("base");
            System.out.println("successfully repaired the truck and set out on the route");
        }
    }

    @Override
    public void startRepair(Truck truck) throws CustomException {
        throw new CustomException("Already under renovation");
    }
}
