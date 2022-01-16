package com.ze1sure99.mapper;

import com.ze1sure99.pojo.Order;
import com.ze1sure99.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderMapper {
    //查询订单的同时还查询订单所属的用户
    @Results({
            @Result(property="id",column="id"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "total",column = "total"),
            @Result(property = "user",column = "uid",javaType = User.class,
                    one = @One(select = "com.ze1sure99.mapper.IUserMapper.findUserById"))
    })
    @Select("select * from orders")
    public List<Order> findOrderAndUser();


    @Select("select * from orders where uid=#{uid}")
    public List<Order> findOrderByUid(Integer uid);



}
