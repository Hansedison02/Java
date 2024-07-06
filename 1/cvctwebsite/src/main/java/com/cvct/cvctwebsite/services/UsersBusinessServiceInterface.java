package com.cvct.cvctwebsite.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cvct.cvctwebsite.models.UserModel;

@Service
public interface UsersBusinessServiceInterface {
    public void test();
    public void init();
    public void destroy();

    public UserModel getById(String id);
    public List<UserModel> getUsers();
    public List<UserModel> searchUsers(String searchTerm);

    public String addOne(UserModel newUser);

    public boolean deleteOne (String id);

    public UserModel updateOne(String idToUpdate, UserModel updateUser);

}
