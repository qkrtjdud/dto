package com.example.kakao.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kakao.cart.Cart;

public interface OrderJPARepository extends JpaRepository<Order, Integer> {


    

}
