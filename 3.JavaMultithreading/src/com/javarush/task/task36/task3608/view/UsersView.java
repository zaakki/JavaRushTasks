package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;
public class UsersView implements View {
    private Controller controller;


//Измени метод refresh в UsersView так, чтобы он отображал "All users:" либо "All deleted users:"
//в зависимости от того, какие пользователи находятся в списке.
    @Override
    public void refresh(ModelData modelData) {
        if(modelData.isDisplayDeletedUserList() == false) {
            System.out.println("All users:");
        } else if(modelData.isDisplayDeletedUserList() == true) {
            System.out.println("All deleted users:");
        }
        for (User u : modelData.getUsers()
        ) {
            System.out.println("\t" + u);
        }
        System.out.println("===================================================");
    }


    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id){
        controller.onOpenUserEditForm(id);
    }



}
