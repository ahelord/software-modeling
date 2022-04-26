package co.software.modeling.main;

import co.software.modeling.domain.Dish;
import co.software.modeling.domain.DishDirector;
import co.software.modeling.domain.OrientalDishBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("running");
        DishDirector director = new DishDirector();
        director.setBuilder(new OrientalDishBuilder());
        director.create("Wok for family","https://images.ecestaticos.com/YZgCquOcdaoGk1RKQJyISooxkw0=/61x36:2033x1515/600x450/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F826%2Fda0%2F32c%2F826da032cba8e60ff4ed201dcc8e61c4.jpg");
        Dish orientalDish = director.getDish();
        System.out.println(orientalDish.toString());
    }
}
