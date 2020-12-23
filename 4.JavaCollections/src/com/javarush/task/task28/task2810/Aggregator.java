package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {
        Strategy strategy = new HHStrategy();
        Provider provider = new Provider(strategy);
        Strategy strategy11 = new MoikrugStrategy();
        Provider provider1 = new Provider(strategy11);
//3. Для запуска нужно еще обновить метод main в Aggregator.
//3.1. Создай вью, модель, контроллер.
//3.2. Засэть во вью контроллер.
//3.3. Вызови у вью метод userCitySelectEmulationMethod.
        HtmlView view = new HtmlView();
        Model model = new Model(view, provider, provider1);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();

    }
}
