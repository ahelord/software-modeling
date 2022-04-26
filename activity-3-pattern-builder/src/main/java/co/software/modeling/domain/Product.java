package co.software.modeling.domain;

public class Product {

    private int id;
    private String name;
    private double price;
    private boolean isBase;

    public Product(int id, String name, double price,boolean isBase) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isBase = isBase;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsBase() {
        return isBase;
    }

    public void setIsBase(boolean isBase) {
        this.isBase = isBase;
    }


    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }

}