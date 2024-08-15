package com.example.backend.service.interfaces;

import com.example.backend.model.User;

import java.util.List;

public interface UserService {

    int insert(User user);

    int delete(Integer id);

    int update(User user);

    List<User> selectByName(Integer offset, Integer limit, String name);

    Integer countByName(String name);

    List<User> selectAll(Integer offset, Integer limit);

    Integer countAll();
}
