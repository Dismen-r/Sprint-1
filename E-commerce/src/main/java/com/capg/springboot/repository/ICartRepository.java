package com.capg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.springboot.entity.Cart;


public interface ICartRepository extends JpaRepository<Cart,String>{
	Cart findByCartId(String cartId);

}
