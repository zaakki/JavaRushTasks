package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }
//3. Реализуй логику метода loadUsers:
//3.1. Достань всех пользователей между 1 и 100 уровнями. (Метод getUsersBetweenLevels(1, 100)).
//3.2. Положи всех пользователей в modelData.
//
//4. Обнови Solution.main: замени FakeModel на MainModel.
//Преимущества MVC в том, что в любой момент времени легко можно заменить любую часть паттерна.
    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
       modelData.setUsers(getAllUsers());
    }
    private List<User> getAllUsers(){
       List<User> users = userService.getUsersBetweenLevels(1,100);
        return userService.filterOnlyActiveUsers(users);
    }


    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }
    public void loadUserById(long userId){
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
    public void deleteUserById(long id){
        userService.deleteUser(id);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }
    //В классе MainModel в методе changeUserData(String, long, int)
    // ты не вызвал метод createOrUpdateUser у объекта класса UserService.
    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name,id,level);
        modelData.setUsers(getAllUsers());

    }


}
