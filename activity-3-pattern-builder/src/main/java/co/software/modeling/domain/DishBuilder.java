package co.software.modeling.domain;

public abstract class DishBuilder {
    public Dish getDish() {
        return dish;
    }

    protected Dish dish;

    public abstract DishBuilder init();

    public abstract DishBuilder setName(String name);

    public abstract DishBuilder setPathOfMultimedia(String pathOfMultimedia);

    public abstract DishBuilder setCore();

    public abstract boolean addPart();

    public abstract DishBuilder setSize();

}
