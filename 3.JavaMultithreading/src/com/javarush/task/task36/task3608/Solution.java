package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;
// Класс Solution будет эмулятором пользователя. Открой класс Solution, стань на красный метод.
//C помощью горячих клавиш Идеи создай проперти(поле) для usersView.
//Нужен только сеттер. Если у тебя создался геттер, то удали его.

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireEventShowAllUsers();
//Добавь в main вызов fireEventUserChanged перед вызовом метода fireEventShowDeletedUsers().
        //Вывод метода main должен содержать пользователя с измененными данными.
        //В методе main необходимо вызвать метод fireEventUserChanged(String, long, int)
        // перед вызовом метода fireEventShowDeletedUsers().
        EditUserView editUserView = new EditUserView();
        editUserView.setController(controller);

        controller.setEditUserView(editUserView);
        
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Zaki",126L,25);
        usersView.fireEventShowDeletedUsers();
    }
}