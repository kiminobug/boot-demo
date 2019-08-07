package com.example.bootdemo.mapper;

import com.example.bootdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserById(@Param("id") Long id);
}
