package co.software.modeling.domain;

import java.util.List;
import java.util.Vector;

public class OrientalDish extends Dish {
    private Product base;
    private List<Product> options;
    private Size size;

    OrientalDish(double price) {
        this.price = price;
        options = new Vector<>();
    }

    void setBase(Product base) {
        this.base = base;
    }

    void addOption(Product option) {
        getOptions().add(option);
    }

    /**
     * @return the base
     */
    public Product getBase() {
        return base;
    }

    /**
     * @return the myOptions
     */
    public List<Product> getOptions() {
        return options;
    }

    /**
     * @return the size
     */
    public Size getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        price = base.getPrice();
        for (Product option : options) {
            price = price + option.getPrice();
        }
        switch (size) {
            case DOUBLE:
                price = 1.8 * price;
                break;
            case FAMILY:
                price = 3 * price;
                break;
        }
        return price;
    }
}
