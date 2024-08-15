package com.example.backend.mapper;

import com.example.backend.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    int delete(Integer id);

    int update(User user);

    List<User> selectByName(Integer offset, Integer limit, String name);

    Integer countByName(String name);

    List<User> selectAll(Integer offset, Integer limit);

    Integer countAll();
}
