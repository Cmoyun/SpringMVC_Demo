package com.sinaapp.moyun.service.imp;

import com.sinaapp.moyun.dao.imp.UserDaoImp;
import com.sinaapp.moyun.model.po.User;
import com.sinaapp.moyun.service.BaseService;
import com.sinaapp.moyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Moy on ÎåÔÂ27  027.
 */
@Transactional
@Service
public class UserServiceImp extends BaseService implements UserService{

    @Autowired
    private UserDaoImp userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public void delete(Integer id) {
        try {
            userDao.delete(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> queryAll() {
        try {
            return userDao.findAll().list();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<User> queryByName(String name) {
        return userDao.findByName(name);
    }
}
