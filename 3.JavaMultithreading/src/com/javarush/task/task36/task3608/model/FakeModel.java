package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }
//User{name='A', id=1, level=1}
//User{name='B', id=2, level=1}
    @Override
    public void loadUsers() {
       ArrayList<User> users = new ArrayList<>();
       users.add(new User("a",1,1));
       users.add(new User("b",2,1));
        modelData.setUsers(users);

    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw  new UnsupportedOperationException();
    }


}
