package co.software.modeling.domain;


public class DishDirector {


    public DishBuilder dishBuilder;


    public void setBuilder(final DishBuilder dishBuilder) {
        this.dishBuilder = dishBuilder;
    }

    public void create(String name, String pathOfMultimedia, Size size) {
        boolean moreParts = true;
        dishBuilder.init();
        dishBuilder.setCore();
        while(moreParts){
            moreParts = dishBuilder.addPart();
        }
        dishBuilder.setSize(size);
        dishBuilder.setName(name);
        dishBuilder.setPathOfMultimedia(pathOfMultimedia);
    }

    public Dish getDish() {
        return this.dishBuilder.getDish();
    }

}

