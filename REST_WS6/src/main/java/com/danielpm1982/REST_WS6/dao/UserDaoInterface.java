package com.danielpm1982.REST_WS6.dao;
import com.danielpm1982.REST_WS6.entity.User;

public interface UserDaoInterface {
    public abstract User findByUserName(String userName);
    public abstract void save(User user);
    public abstract User findByUserId(Long userId);
    public abstract void deleteUserById(Long userId);
}
