package co.software.modeling.domain;

public class ItalianDishBuilder extends DishBuilder {
    public ItalianDish getItalianDish() {
        return italianDish;
    }

    public void setItalianDish(ItalianDish italianDish) {
        this.italianDish = italianDish;
    }

    public ItalianDish italianDish;

    @Override
    public DishBuilder init() {
        return super.init();
    }

    @Override
    public DishBuilder setCore() {
        return super.setCore();
    }

    @Override
    public boolean addPart() {
        return super.addPart();
    }

    @Override
    public DishBuilder setSize() {
        return super.setSize();
    }
}