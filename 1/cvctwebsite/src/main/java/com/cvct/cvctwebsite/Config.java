package com.cvct.cvctwebsite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.context.annotation.RequestScope;

import com.cvct.cvctwebsite.data.UsersDataAccessInterface;
import com.cvct.cvctwebsite.data.UsersDataServiceForRepository;
import com.cvct.cvctwebsite.models.UserModel;
import com.cvct.cvctwebsite.services.UsersBusinessService;
import com.cvct.cvctwebsite.services.UsersBusinessServiceInterface;

@Configuration
public class Config {

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSenderImpl();
    }

    @Bean(name="usersBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public UsersBusinessServiceInterface getUsersBusiness()
    {
        return new UsersBusinessService();
    }

    @Bean(name="ordersDAO")
    @RequestScope
    public UsersDataAccessInterface<UserModel> getDataService()
    {
        return new UsersDataServiceForRepository();
    }
}