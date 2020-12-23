package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;
// EditUserView editUserView с сеттером.
public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void setModel(Model model) {
        this.model = model;
    }
  
    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
       this.usersView = usersView;
    }
    public void onShowAllDeletedUsers(){
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }
    //В методе onOpenUserEditForm(long) ты не вызвал метод loadUserById(long) у объекта класса Model.
    public void onOpenUserEditForm(long userId){
        model.loadUserById(userId);
       editUserView.refresh(model.getModelData());
    }
    public void onUserDelete(long id){
        model.deleteUserById(id);
        //editUserView.refresh(model.getModelData());
        usersView.refresh(model.getModelData());
    }
    public void onUserChange(String name, long id, int level){
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }


}
