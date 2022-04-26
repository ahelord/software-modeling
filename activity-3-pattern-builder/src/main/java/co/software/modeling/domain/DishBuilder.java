package co.software.modeling.domain;

public abstract class DishBuilder {
    public Dish getDish() {
        return dish;
    }

    protected Dish dish;

    public  DishBuilder init(){return this;};

    public  DishBuilder setName(String name){return this;};

    public  DishBuilder setPathOfMultimedia(String pathOfMultimedia){return this;};

    public DishBuilder setCore(){return this;};

    public boolean addPart(){return false;};

    public DishBuilder setSize(){return this;};

}
