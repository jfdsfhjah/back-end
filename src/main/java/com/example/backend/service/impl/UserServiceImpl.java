package com.example.backend.service.impl;

import com.example.backend.mapper.UserMapper;
import com.example.backend.model.User;
import com.example.backend.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public List<User> selectByName(Integer offset, Integer limit, String name) {
        return userMapper.selectByName(offset, limit, name);
    }

    public Integer countByName(String name) {
        return userMapper.countByName(name);
    }

    public List<User> selectAll(Integer offset, Integer limit) {
        return userMapper.selectAll(offset, limit);
    }

    public Integer countAll() {
        return userMapper.countAll();
    }
}
