package co.software.modeling.domain;

import java.util.ArrayList;

public class ItalianDishBuilder extends DishBuilder {
    private ItalianDish italianDish;
    private final ArrayList<Product> italianProducts = new ArrayList<Product>() {
        {
            add(new Product(1, "pasta", 10000d, true));
            add(new Product(2, "meatballs", 9000d, false));
            add(new Product(3, "shrimp", 2000d, false));

        }
    };
    ArrayList<Product> bases;
    ArrayList<Product> options;

    @Override
    public DishBuilder init() {
        dish = new ItalianDish();
        italianDish = (ItalianDish) dish;
        bases = new ArrayList<>();
        options = new ArrayList<>();
        for (Product italianProduct : italianProducts) {
            if (italianProduct.getIsBase())
                bases.add(italianProduct);
            else
                options.add(italianProduct);
        }
        return this;
    }

    @Override
    public DishBuilder setName(String name) {
        italianDish.setName(name);
        return this;
    }

    @Override
    public DishBuilder setPathOfMultimedia(String pathOfMultimedia) {
        italianDish.setPathOfMultimedia(pathOfMultimedia);
        return this;
    }

    @Override
    public DishBuilder setCore() {
        italianDish.setType(TypePasta.RAVIOLI);
        italianDish.setBase(bases.get(0));
        return this;
    }

    @Override
    public boolean addPart() {
        italianDish.addOption(options.get(0));
        italianDish.addOption(options.get(1));
        italianDish.setAddParmesanCheese(true);
        return false;
    }

    @Override
    public DishBuilder setSize(Size size) {
        italianDish.setSize(size);
        return this;
    }
}