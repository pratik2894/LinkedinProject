package com.services.dataBaseService.DbQueryhandler;

import com.services.dataBaseService.configuration.Db1Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserServiceQueries {

    private final Db1Config db1Config;
    public UserServiceQueries(Db1Config db1Config) {
        this.db1Config = db1Config;
    }
    public void CreateUser(UUID userId, String City, String firstName, String Lastname, String userName, String Country) {
        db1Config.UserjdbcTemplate()
                .update("INSERT INTO user_table (user_id , username , first_name , last_name , country , city ) VALUES ( ? , ? , ? , ? , ? , ? )",
                        userId, userName, firstName, Lastname, Country, City);
    }

}