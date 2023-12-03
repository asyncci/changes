import model.Driver;
import model.Truck;
import state.OnBase;
import util.FileUtil;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class AutoBase {
    private static Scanner sc = new Scanner(System.in);
    private static Truck[] trucks = FileUtil.readFile();
    private static Driver[] drivers = FileUtil.takeFile();


    public void showTrucks() {
        String str = "+---+-----------------+-----------------+----------+";
        System.out.println(str);
        System.out.printf("| # | %-15s | %-15s | %-9s|%n+---+-----------------+-----------------+----------+%n", "Bus", "Driver", "State");
        for (Truck truck : trucks) {
            truck.setStateObj(new OnBase());
            System.out.println(truck);
        }
        System.out.println(str);
    }

    public void showDrivers() {
        String str =("+---+-----------+-----------------+");
        System.out.printf(str);
        System.out.printf("%n| # | %-10s|%-17s|%n+---+-----------+-----------------+%n", "Driver"," Bus");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        System.out.printf(str);
    }

        public void chooseTheBus() {
        System.out.println("\n\n=== === === === === === ===\nChoose the truck by ID: ");
        for (int i = 0; i < trucks.length; i++) {
            System.out.printf("%d.%s%n", i + 1, trucks[i].getName());
        }
        System.out.println("Any number - Finish the work");
        try {
            int id = num("Truck: ");
            System.out.println();
            System.out.println(trucks[id - 1].toString2());
            chooseTheAction(trucks[id - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bye!\n");
            System.out.println();
        }
    }

    private void chooseTheAction(Truck truck) {
        System.out.println("== == == == == == == == == ==\nChoose the action: ");
        System.out.println("1.Change driver.\n2.Send by route.\n3.Send by repair.\n4.I want choose another truck.");
        int chosen = num("Action: ");
        System.out.println();
        switch (chosen) {
            case 1:
                changeDriver(truck);
                chooseTheBus();
                break;
            case 2:
                truck.startDriving();
                chooseTheBus();
                break;
            case 3:
                truck.startRepair();
                chooseTheBus();
                break;
            case 4:
                chooseTheBus();
                break;
            default:
                System.out.println("Choose the one of amount 3 action!");
                chooseTheAction(truck);
        }
    }

    private int num(String prompt) {
        System.out.print(prompt);
        try {
            String str = sc.nextLine();
            if (str.isEmpty() || str.isBlank()) {
                throw new NoSuchElementException(String.format("%s :", "field cannot be empty"));
            }
            if (Integer.parseInt(str)<0){
                throw  new IllegalArgumentException(String.format("%s :","r u serious?: "));
            }
            return Integer.parseInt(str);
        } catch (NoSuchElementException | NumberFormatException e) {
            return num(e.getMessage() + " ");
        }catch (IllegalArgumentException e){
            return num(e.getMessage());
        }
    }

    private void changeDriver(Truck truck) {
        if (truck.getState().equals("base")) {
            Driver freeDriver = findFreeDriver(truck);
            if (freeDriver != null) {
                truck.changeDriver(freeDriver);
            } else {
                System.out.println("No available drivers for the truck");
            }
        } else {
            truck.changeDriver(null);
        }
    }

    private Driver findFreeDriver(Truck truck) {
        if (truck.getState().equals("base")) {
            for (Driver driver : drivers) {
                if (!driverIsAssigned(driver)) {
                    driver.setBus(truck.getName());
                    return driver;
                }
            }
        }
        return null;
    }

    private boolean driverIsAssigned(Driver driver) {
        for (Truck truck : trucks) {
            if (driver.getId().equals(truck.getDriver())) {
                return true;
            }
        }
        return false;
    }

}
