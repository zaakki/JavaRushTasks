package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Model;

public class Controller {
    private Model model;

    public Controller(Model model) {
        if(model != null) {
            this.model = model;
        } else throw new IllegalArgumentException();
    }

    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }
}
