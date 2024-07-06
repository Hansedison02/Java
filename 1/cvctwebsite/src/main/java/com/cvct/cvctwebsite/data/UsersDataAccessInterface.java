package com.cvct.cvctwebsite.data;

import java.util.List;

public interface UsersDataAccessInterface <T>{

    public T getById(String id);
    public List<T> getUsers();
    public List<T> searchUsers(String searchTerm);
    public String addOne(T newUser);
    public boolean deleteOne(String id);
    public T updateOne(String idToUpdate, T updateOrder);


}
