package com.tibame.tga105.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ogabe.mall.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
