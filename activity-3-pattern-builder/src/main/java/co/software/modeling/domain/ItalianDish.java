package co.software.modeling.domain;

public class ItalianDish extends Dish {
    public ItalianDish() {
        super();
    }

    @Override
    public double getPrice() {
        double BASE_MULTIPLIER = 1.2;
        double OPTION_MULTIPLIER = 1.05;
        double SEASSON_DISCOUNT = 0.15;
        price = base.getPrice() * BASE_MULTIPLIER;
        for (Product option : options) {
            price = price + option.getPrice() * OPTION_MULTIPLIER;
        }
        switch (size) {
            case DOUBLE:
                price = 2 * price;
                break;
            case FAMILY:
                price = 4 * price;
                break;
        }

        return price-(price*SEASSON_DISCOUNT);
    }
}
