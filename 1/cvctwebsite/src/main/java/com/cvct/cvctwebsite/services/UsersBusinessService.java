package com.cvct.cvctwebsite.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cvct.cvctwebsite.data.UsersDataAccessInterface;
import com.cvct.cvctwebsite.models.UserModel;

public class UsersBusinessService implements UsersBusinessServiceInterface {

    @Autowired
    UsersDataAccessInterface<UserModel> usersDAO;

    @Override
    public List<UserModel> getUsers()
    {
        return usersDAO.getUsers();
    }

    @Override
    public void init()
    {
        System.out.println("Init method...");
    }

    @Override
    public void destroy()
    {
        System.out.println("Destroy method...");
    }

    @Override
    public UserModel getById(String id)
    {
        return usersDAO.getById(id);
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm)
    {
        return usersDAO.searchUsers(searchTerm);
    }

    @Override
    public String addOne(UserModel newUser)
    {
        return usersDAO.addOne(newUser);
    }

    @Override
    public boolean deleteOne(String id)
    {
        return usersDAO.deleteOne(id);
    }

    @Override
    public UserModel updateOne(String idToUpdate, UserModel updateUser)
    {
        return usersDAO.updateOne(idToUpdate, updateUser);
    }

    @Override
    public void test() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test'");
    }
}
