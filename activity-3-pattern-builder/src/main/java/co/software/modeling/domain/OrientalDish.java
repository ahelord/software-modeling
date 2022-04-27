package co.software.modeling.domain;

public class OrientalDish extends Dish {

    OrientalDish() {
        super();
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
