package com.myl.dao;

import com.myl.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    public List<User> findAll();

    public User findById(Integer id);

    public  void addUser(User user);

    public  void updateUser(User user);

    public  void deleteUser(String id);

    //模糊查询1
    public List<User> findByUserName1(String name);

    //模糊查询2
    public List<User> findByUserName2(String name);

    //模糊查询3
    public List<User> findByUserName3(String name);

    //获取总记录数
    public Integer getTotalCount();

    //获取分页数
    public List<User> findPageData(HashMap<String, Integer> hashMap);
}
