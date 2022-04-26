package co.software.modeling.domain;

public class Dish {
    protected String name;
    protected String pathOfMultimedia;
    protected double price;
    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPathOfMultimedia() {
        return this.pathOfMultimedia;
    }

    public void setPathOfMultimedia(final String pathOfMultimedia) {
        this.pathOfMultimedia = pathOfMultimedia;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" + "name=" + name + ", price=" + getPrice() + ", pathOfMultimedia=" + pathOfMultimedia + '}';
    }
}
