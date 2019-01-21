package com.wipro.danielgorski.service;

import org.springframework.data.repository.CrudRepository;

import com.wipro.danielgorski.domain.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
	
}
