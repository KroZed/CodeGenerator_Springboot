package com.prj.service;
import com.prj.entity.User;
import java.util.List;
public interface UserService {
    User getById(Object Id);
    List<User> findAll();
    boolean save(User User);
    boolean update(User User);
    boolean deleteById(Object Id);
} 
