package co.software.modeling.domain;

import java.util.List;
import java.util.Vector;

public class Dish {
    protected String name;
    protected String pathOfMultimedia;
    protected double price;
    protected Product base;
    protected List<Product> options;
    protected Size size;

    public Product getBase() {
        return base;
    }

    public void setBase(Product base) {
        this.base = base;
    }

    public List<Product> getOptions() {
        return options;
    }

    public void setOptions(List<Product> options) {
        this.options = options;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }


    public Dish() {
        this.options = new Vector<>();
    }

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

    void addOption(Product option) {
        getOptions().add(option);
    }

    @Override
    public String toString() {
        return "Dish{" + "name=" + name + ", price=" + getPrice() + ", pathOfMultimedia=" + pathOfMultimedia + '}';
    }
}
