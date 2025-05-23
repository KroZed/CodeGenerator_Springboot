package com.prj.service.impl;
import com.prj.dao.UserDao;
import com.prj.entity.User;
import com.prj.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao UserDao;
    @Override
    public User getById(Object Id) {
        return UserDao.getById(Id);
    }
    @Override
    public List<User> findAll() {
        return UserDao.findAll();
    }
    @Override
    public boolean save(User User) {
        return UserDao.insert(User) > 0;
    }
    @Override
    public boolean update(User User) {
        return UserDao.update(User) > 0;
    }
    @Override
    public boolean deleteById(Object Id) {
        return UserDao.deleteById(Id) > 0;
    }
} 
