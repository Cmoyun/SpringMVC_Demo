package com.sinaapp.moyun.dao;

import com.sinaapp.moyun.model.po.User;

import java.util.List;

/**
 * Created by Moy on ����24  024.
 */
public interface UserDao {
 public List<User> findByName(String name);
}
