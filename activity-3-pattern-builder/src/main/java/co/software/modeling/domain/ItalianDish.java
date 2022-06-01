package co.software.modeling.domain;

public class ItalianDish extends Dish {

    private TypePasta type;
    private boolean addParmesanCheese;

    public ItalianDish() {
        super();
    }

    public TypePasta getType() {
        return type;
    }

    public void setType(TypePasta type) {
        this.type = type;
    }

    public boolean getAddParmesanCheese() {
        return addParmesanCheese;
    }

    public void setAddParmesanCheese(boolean addParmesanCheese) {
        this.addParmesanCheese = addParmesanCheese;
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
