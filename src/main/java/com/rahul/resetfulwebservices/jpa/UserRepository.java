package com.rahul.resetfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.resetfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
