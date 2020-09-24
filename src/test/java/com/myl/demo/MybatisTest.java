package com.myl.demo;

import com.myl.dao.UserDao;
import com.myl.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    //查询所有
    @Test
    public void testFindAll() throws IOException {

        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //4.使用SqlSession创建Dao接口代理对象
        UserDao userDao = session.getMapper(UserDao.class);

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();

            System.out.println(users);

        //6.释放资源
        session.close();
        inputStream.close();
    }
    //查询单个
    @Test
    public void testFindById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        //--------------------------------------------

        UserDao userDao = session.getMapper(UserDao.class);

        User user = userDao.findById(1);

        System.out.println(user);

        session.close();
        inputStream.close();
    }

    //添加对象

    @Test
    public void testAddUser() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        //--------------------------------------------

        UserDao userDao = session.getMapper(UserDao.class);

        User user = new User();
        user.setName("张三");
        user.setPassword("12545");

        userDao.addUser(user);

        System.out.println(user);

        session.commit();

        session.close();
        inputStream.close();
    }

}
