package com.rahul.resetfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.resetfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
