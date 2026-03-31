package com.services.dataBaseService.services;


import com.services.dataBaseService.DbQueryhandler.UserServiceQueries;
import com.services.dataBaseService.configuration.Db1Config;
import com.services.dataBaseService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDbserviceHandler {

    @Autowired
    private UserServiceQueries userServiceQueries;

    public void CreateUser(User user){
        userServiceQueries.CreateUser(user.getUserId(), user.getCity(), user.getFirstName(),  user.getLastName(),  user.getUsername(), user.getCountry());
    }

}

