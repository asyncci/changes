package model;

public class Driver {


    private String id;
    private String name;

    public String getBus() {
        return bus;
    }

    private String bus = "";

    private Driver() {
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("|%2s | %-9s | %-16s|", id.charAt(id.length() - 1), name,bus);
    }
}

