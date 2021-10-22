package com.ze1sure99.mapper;

import com.ze1sure99.pojo.Order;

import java.util.List;

public interface IUserMapper {
    //查询订单的同时还查询订单所属的用户
    public List<Order> findOrderAndUser();
}
