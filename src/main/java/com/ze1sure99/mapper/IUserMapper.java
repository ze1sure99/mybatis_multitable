package com.ze1sure99.mapper;

import com.ze1sure99.pojo.User;

import java.util.List;

public interface IUserMapper {
    //查询所有用户信息同时查询出每个用户关联的订单信息
    public List<User> findAll();
}
