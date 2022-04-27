package co.software.modeling.domain;

import java.util.ArrayList;

public class OrientalDishBuilder extends DishBuilder {

    private OrientalDish orientalDish;
    private final ArrayList<Product> orientalProducts = new ArrayList<Product>() {
        {
            add(new Product(1, "rice", 7000d, true));
            add(new Product(2, "shrimp", 8000d, false));
            add(new Product(4, "steamed vegetables", 5000d, false));

        }
    };
    ArrayList<Product> bases;
    ArrayList<Product> options;


    @Override
    public DishBuilder init() {
        dish = new OrientalDish();
        orientalDish = (OrientalDish) dish;
        bases = new ArrayList<>();
        options = new ArrayList<>();
        for (Product orientalProduct : orientalProducts) {
            if (orientalProduct.getIsBase())
                bases.add(orientalProduct);
            else
                options.add(orientalProduct);
        }
        return this;
    }

    @Override
    public DishBuilder setName(String name) {
        orientalDish.setName(name);
        return this;
    }

    @Override
    public DishBuilder setPathOfMultimedia(String pathOfMultimedia) {
        orientalDish.setPathOfMultimedia(pathOfMultimedia);
        return this;
    }

    @Override
    public DishBuilder setCore() {
        orientalDish.setBase(bases.get(0));
        return this;
    }

    @Override
    public boolean addPart() {
        orientalDish.addOption(options.get(0));
        orientalDish.addOption(options.get(1));
        return false;
    }

    @Override
    public DishBuilder setSize() {
        orientalDish.setSize(Size.FAMILY);
        return this;
    }

}