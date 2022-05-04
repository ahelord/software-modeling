package co.software.modeling.main;

public class Beer {
    private int id;
    private double milliliters;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Beer(int id, double milliliters, String name) {
        this.id = id;
        this.milliliters = milliliters;
        this.name = name;
    }
}
