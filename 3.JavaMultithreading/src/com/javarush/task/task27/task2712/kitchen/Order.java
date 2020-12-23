package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    protected void initDishes() throws IOException{
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Dish dish : dishes) {
            stringBuffer.append(dish);
            stringBuffer.append(", ");
        }
        String dishesInOrder = stringBuffer.toString().substring(0, stringBuffer.toString().length() - 2);

        return "Your order: [" + dishesInOrder + "] of " + tablet.toString();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime(){
        int totalTime = 0;
        for (Dish dish:dishes
             ) {
            totalTime += dish.getDuration();
        }
        return totalTime;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
