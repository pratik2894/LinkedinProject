package com.services.dataBaseService.DbQueryhandler;

import com.services.dataBaseService.configuration.Db1Config;
import com.services.dataBaseService.model.ContactInfo;
import com.services.dataBaseService.model.Education;
import com.services.dataBaseService.model.position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserServiceQueries {

    private final Db1Config db1Config;
    public UserServiceQueries(Db1Config db1Config) {
        this.db1Config = db1Config;
    }
    public void CreateUser(UUID userId, String City, String firstName, String Lastname, String userName, String Country , String email) {
        db1Config.UserjdbcTemplate()
                .update("INSERT INTO user_table (user_id , username , first_name , last_name , country , city , email ) VALUES ( ? , ? , ? , ? , ? , ? , ?)",
                        userId, userName, firstName, Lastname, Country, City , email);
    }
    public void UpdateUser(UUID userId, String City, String firstName, String Lastname, String userName, String Country , String email) {
        db1Config.UserjdbcTemplate()
                .update("UPDATE  user_table SET username  = ? , first_name = ? , last_name = ? , country =  ? , city =  ? , email = ? WHERE user_id = ?",
                         userName, firstName, Lastname, Country, City , email , userId);
    }
    public void RemoveUser(UUID userId) {
        db1Config.UserjdbcTemplate()
                .update("DELETE FROM  user_table WHERE user_id  = ? ",
                         userId);
    }


}