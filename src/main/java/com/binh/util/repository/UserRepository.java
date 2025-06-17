package com.binh.util.repository;

import com.binh.util.entity.User;


public interface UserRepository {
    User findByUsername(String username);
}
