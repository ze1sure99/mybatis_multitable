package com.ze1sure99.test;

import com.ze1sure99.mapper.IOrderMapper;
import com.ze1sure99.mapper.IUserMapper;
import com.ze1sure99.pojo.Order;
import com.ze1sure99.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 测试一对一查询
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IOrderMapper mapper = sqlSession.getMapper(IOrderMapper.class);
        List<Order> orderAndUser = mapper.findOrderAndUser();
        for (Order order : orderAndUser) {
            System.out.println(order);
        }
    }

    /**
     * 测试一对多查询
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取到IUserMapper的代理对象
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user.getUsername());
            System.out.println(user);
            System.out.println("===================");
        }
    }
    @Test
    public void test3() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> allUserAndRole = mapper.findAllUserAndRole();
        for (User u : allUserAndRole){
            System.out.println(u);
        }
    }

    private IUserMapper userMapper;
    private IOrderMapper orderMapper;
    @Before  //在@test之前执行
    public void befor() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper  = sqlSession.getMapper(IUserMapper.class);
        orderMapper  = sqlSession.getMapper(IOrderMapper.class);
    }
    @Test
    public void addUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("测试数据");
        userMapper.addUser(user);
    }

    @Test
    public void updateUser(){
        User user =  new User();
        user.setId(3);
        user.setUsername("修改了测试数据");
        userMapper.updateUser(user);
    }

    @Test
    public void selectUser(){
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteUser(){
        userMapper.deleteUser(3);
    }

    @Test
    public void oneToOne(){
        List<Order> orderAndUser = orderMapper.findOrderAndUser();
        for (Order order : orderAndUser) {
            System.out.println(order);
        }
    }

    @Test
    public void oneToMany(){
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
