package com.capg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.springboot.entity.User;


public interface IUserRepository extends JpaRepository<User,String> {

	public User findByUserId(String id);
}
