package com.cvct.cvctwebsite.data;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cvct.cvctwebsite.models.UserEntity;
import com.cvct.cvctwebsite.models.UserModel;

public class UsersDataServiceForRepository implements UsersDataAccessInterface<UserModel>{

    @Autowired
    UsersRepositoryInterface usersRepository;


    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserModel getById(String id)
    {
        UserEntity entity = usersRepository.findById(id).orElse(null);


        UserModel model = modelMapper.map(entity, UserModel.class);

        return model;
    }

    @Override
    public List<UserModel> getUsers()
    {
        Iterable<UserEntity> usersEntity = usersRepository.findAll();

        List<UserModel> models = new ArrayList<UserModel>();

        for(UserEntity item: usersEntity)
        {
            models.add(modelMapper.map(item, UserModel.class));
        }

        return models;
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm)
    {
        Iterable<UserEntity> usersEntity = usersRepository.findByUsername(searchTerm);

        List<UserModel> users = new ArrayList<UserModel>();

        for(UserEntity item: usersEntity)
        {
            users.add(modelMapper.map(item, UserModel.class));
        }

        return users;
    }

    @Override
    public String addOne(UserModel newUser)
    {
        UserEntity entity = modelMapper.map(newUser, UserEntity.class);
        UserEntity result = usersRepository.save(entity);
        if (result == null)
        {
            return null;
        }
        else
        {
            return result.getId();
        } 
    }

    @Override 
    public boolean deleteOne(String id)
    {
        usersRepository.deleteById(id);
        return true;
    }

    @Override 
    public UserModel updateOne(String idToUpdate, UserModel updateUser)
    {
        UserEntity entity = modelMapper.map(updateUser, UserEntity.class);
        UserEntity result = usersRepository.save(entity);
        UserModel user = modelMapper.map(result, UserModel.class);

        return user;
    }
}
