package com.danielpm1982.REST_WS6.dao;
import com.danielpm1982.REST_WS6.entity.User;

public interface UserDaoInterface {
    public abstract User findByUserName(String userName);
    public abstract void save(User user);
    public abstract User findByUserId(Long userId);
    public abstract void deleteUserById(Long userId);
}

/*could have used Spring Data automatic CRUD repositories generation 
by extending any extension of the Repository interface, for instance, 
org.springframework.data.jpa.repository.JpaRepository . And later adding
any custom method or implementation needed.*/
