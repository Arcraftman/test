package com.aoding.dev.test;

import com.aoding.dev.mapper.UserMapper;
import com.aoding.dev.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        // 加载 MyBatis 配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);

            // 插入用户
            User newUser = new User();
            newUser.setName("John Doe");
            newUser.setEmail("john.doe@example.com");
            newUser.setAge(30);
            userMapper.insertUser(newUser);
            session.commit();

            // 查询所有用户
            List<User> users = userMapper.getAllUsers();
            users.forEach(user -> System.out.println(user.getName()));

            // 根据 ID 查询用户
            User user = userMapper.getUserById(1);
            System.out.println(user.getName());

            // 更新用户
            user.setName("Jane Doe");
            userMapper.updateUser(user);
            session.commit();

            // 删除用户
            userMapper.deleteUser(user.getId());
            session.commit();
        }
    }
}
