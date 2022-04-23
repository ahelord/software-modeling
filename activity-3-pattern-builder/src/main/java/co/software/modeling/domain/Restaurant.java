package co.software.modeling.domain;

public class Restaurant {

    private String name;

    private Dish[] menu;

    public Restaurant(String name, Dish[] menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Dish[] getMenu() {
        return this.menu;
    }

    public void setMenu(final Dish[] dishes) {
        this.menu = dishes;
    }

}
