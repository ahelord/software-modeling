package co.software.modeling.main;

import co.software.modeling.domain.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("running");
        DishDirector director = new DishDirector();

        director.setBuilder(new OrientalDishBuilder());
        director.create("Wok for family", "https://www.hola.com/imagenes/cocina/noticiaslibros/20200206159868/recetas-con-wok/0-778-991/portada-wok-age-m.jpg", Size.PERSONAL);
        ArrayList<Dish> orientalMenu = new ArrayList<>();
        orientalMenu.add(director.getDish());
        Restaurant orientalRestaurant = new Restaurant("My Oriental Restaurant", orientalMenu);
        System.out.println(orientalRestaurant.getName());
        for (Dish dish : orientalRestaurant.getMenu()) {
            System.out.println(dish.toString());
        }


        director.setBuilder(new ItalianDishBuilder());
        director.create("Spaghetti Amatriciana","https://okdiario.com/img/recetas/2017/04/04/espaguetis-amatriciana-00.jpg", Size.DOUBLE);
        ArrayList<Dish> italianMenu = new ArrayList<>();
        italianMenu.add(director.getDish());
        Restaurant italianRestaurant = new Restaurant("My Italian Restaurant", italianMenu);
        System.out.println(italianRestaurant.getName());
        for (Dish dish : italianRestaurant.getMenu()) {
            System.out.println(dish.toString());
        }
    }
}
