package com.cvct.cvctwebsite.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.cvct.cvctwebsite.models.UserModel;
import com.cvct.cvctwebsite.services.UsersBusinessServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("api/v1/users")
public class UsersRestController {

    UsersBusinessServiceInterface service;

    @Autowired
    public UsersRestController(UsersBusinessServiceInterface service)
    {
        super();
        this.service = service;
    }

    @GetMapping("/users")
    public List<UserModel> showAllUsers()
    {
        List<UserModel> users = service.getUsers();

        return users;
    }

    @GetMapping("/users/search/{searchTerm}")
    public List<UserModel> searchUsers(@PathVariable(name="searchTerm") String searchTerm)
    {
        List<UserModel> users = service.searchUsers(searchTerm);

        return users;
    }

    @PostMapping("/users")
    public String addUsers(@RequestBody UserModel model)
    {
        return service.addOne(model);
    }

    @GetMapping("/users/{id}")
    public UserModel getById(@PathVariable(name="id") String id)
    {
        return service.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteOne(@PathVariable(name="id") String id)
    {
        return service.deleteOne(id);
    }

    @PutMapping("/users/{id}")
    public UserModel updateOne(@RequestBody UserModel model, @PathVariable(name="id") String id)
    {
        return service.updateOne(id, model);
    }
}
