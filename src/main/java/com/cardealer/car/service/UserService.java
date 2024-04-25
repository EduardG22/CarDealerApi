package com.cardealer.car.service;

import com.cardealer.car.entity.User;

public interface UserService {
   User getUser(Long id);
   User getUser(String username);
   User saveUser(User user);
}
