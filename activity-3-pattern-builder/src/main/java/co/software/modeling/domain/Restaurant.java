package co.software.modeling.domain;

import java.util.ArrayList;

public class Restaurant {

    private String name;

    private ArrayList<Dish> menu;

    public Restaurant(String name, ArrayList<Dish> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ArrayList<Dish> getMenu() {
        return this.menu;
    }

    public void setMenu(final ArrayList<Dish> dishes) {
        this.menu = dishes;
    }

}
